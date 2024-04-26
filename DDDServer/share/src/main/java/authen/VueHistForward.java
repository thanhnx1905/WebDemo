//package authen;
//
//import java.io.IOException;
//
//import javax.enterprise.context.RequestScoped;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//
//@Produces("application/json")
//@RequestScoped
//public class VueHistForward {
//
//	@Path("/")
//	@GET
//	public void forward(@Context HttpServletRequest req, @Context HttpServletResponse resp)
//			throws ServletException, IOException {
//		doGet(req, resp);
//	}
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// req.getRequestURI();
//		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher(req.getRequestURI());
//		dispatcher.forward(req, resp);
//	}
//
//}
