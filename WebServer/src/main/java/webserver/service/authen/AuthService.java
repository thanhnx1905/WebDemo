package webserver.service.authen;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces("application/json")
@Stateless
public class AuthService {

	@Inject
	private UserService userService;

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

		// Issue a token for the user
		String token = JwTokenHelper.createJWT(user);

		// Return the token on the response
		return Response.ok(token).build();
	}
}
