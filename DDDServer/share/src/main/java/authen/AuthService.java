package authen;

import java.util.Date;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import refreshtoken.RefreshToken;
import refreshtoken.RefreshTokenRepository;
import authen.session.UserSessionInfo;
import authen.session.asynctask.SessionHelper;

@Path("/auth")
@Produces("application/json")
@RequestScoped
public class AuthService {

	@Inject
	private UserService userService;

	@Inject
	private HttpServletRequest httpRequest;

	@Inject
	private RefreshTokenRepository repo;

	@POST
	@Path("login")
	public Response authenticateUser(UserForLogin userLogin) {

		// Authenticate the user using the credentials provided
		User user = userService.getUser(userLogin.getUsername());
		if (user == null || !user.getPassword().equals(userLogin.getPassword())) {
			return Response.status(Response.Status.FORBIDDEN) // 403 Forbidden
					.entity("Wrong username or password") // the response entity
					.build();
		}

		// save session
		saveSessionInfo(user);

		// Issue a token for the user
		TokenForAuthRefresh token = JwTokenHelper.createJWT(user);
		// create refresh token
		if (userLogin.getTokenId() != null && repo.findByKey(userLogin.getTokenId()).isPresent()) {
			repo.removeByKey(userLogin.getTokenId());
		}
		repo.insertTokenExp(new RefreshToken(token.getRefreshToken(), user.getSid(),
				new Date()));

		// Return the token on the response
		return Response.ok(token).build();
	}

	@POST
	@Path("logout")
	public Response logOut() {
		String authorizationHeader = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || authorizationHeader.isEmpty()) {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}

		// (3) Extract the token from the Authorization header
		String token = authorizationHeader.substring(AuthFilter.AUTHENTICATION_SCHEME.length()).trim();
		repo.removeByKey(token);
		return Response.ok().build();
	}

	@POST
	@Path("renew_session")
	public Response reNewSession() {
		// (1) Get Token Authorization from the header
		String authorizationHeader = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || authorizationHeader.isEmpty()) {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}

		// (3) Extract the token from the Authorization header
		String token = authorizationHeader.substring(AuthFilter.AUTHENTICATION_SCHEME.length()).trim();
		User user = JwTokenHelper.getUserFromToken(token);
		Date dateExp = JwTokenHelper.getExpirationDateFromToken(token);
		TokenForAuthRefresh responseToken = JwTokenHelper.createJWT(user, dateExp);
		Optional<RefreshToken> tokenSaved = repo.findByKey(token);
		if (tokenSaved.isPresent() && tokenSaved.get().validRenewSession(dateExp)) {
			repo.removeByKey(token);
			repo.insertTokenExp(tokenSaved.get().reNew(responseToken.getRefreshToken(), new Date()));
			return Response.ok().entity(responseToken).type(MediaType.APPLICATION_JSON).build();
		} else {
			if (tokenSaved.isPresent())
				repo.removeByKey(token);
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}

	}

	private void saveSessionInfo(User user) {
		HttpSession session = httpRequest.getSession();
		session.setAttribute("user", new UserSessionInfo(user.getSid(), user.getUsername()));
		SessionHelper.setSession(Thread.currentThread().getId(), session);

	}
}
