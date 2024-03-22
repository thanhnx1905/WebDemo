package service.authen.test;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.criteria.Order;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import service.authen.Role;
import service.authen.session.SessionLoginInfo;
import service.authen.session.asynctask.AsyncTaskService;

@Path("/orders")
//@PermitAll
public class OrderService {

	@Inject
	private AsyncTaskService asyncTaskService;
	
	@GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id) {
        System.out.println("OrderService->get()");
        return Response.ok("OrderService->get()").build();
    }
 
    @RolesAllowed(Role.ROLE_CUSTOMER)
    @POST
    public Response insert(Order order, @Context SecurityContext securityContext) {
        System.out.println("User: " + securityContext.getUserPrincipal().getName());
        System.out.println("OrderService->insert()");
        return Response.ok("OrderService->insert()").build();
    }
 
    @RolesAllowed({ Role.ROLE_ADMIN, Role.ROLE_CUSTOMER })
    @PUT
    public Response update(Order order) {
        System.out.println("OrderService->update()");
        return Response.ok("OrderService->update()").build();
    }
 
    @RolesAllowed(Role.ROLE_ADMIN)
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        System.out.println("OrderService->delete()"+ SessionLoginInfo.context().getUsername());
        asyncTaskService.execute(()-> {
        	 try {
				Thread.sleep(5000);
				System.out.println("ASYNC: OrderService->delete()"+ SessionLoginInfo.context().getUsername());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        return Response.ok("OrderService->delete()").build();
    }
}
