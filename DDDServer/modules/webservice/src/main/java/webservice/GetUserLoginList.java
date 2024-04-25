package webservice;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import authen.Role;
import authen.UserService;

@Path("/load")
@Produces("application/json")
@RequestScoped
public class GetUserLoginList {

	@Inject
	private UserService userService;

	@POST
	@Path("data")
	@RolesAllowed(Role.ROLE_ADMIN)
	public Response authenticateUser() {
		return Response.ok(userService.getLstUser()).type(MediaType.APPLICATION_JSON).build();

	}
}
