//package authen;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.ext.Provider;
//
//@Provider
//public class CorsFilter implements Filter {
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//		resp.addHeader("Access-Control-Allow-Origin", "*");
//		resp.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
//		resp.addHeader("Access-Control-Allow-Headers", "accept, authorization, content-type, x-requested-with, access-control-allow-origin, Access-Control-Allow-Methods, access-control-allow-headers, bearer");
//
//		// Just ACCEPT and REPLY OK if OPTIONS
//		// TODO removing this if
//		if (request.getMethod().equals("OPTIONS")) {
//			resp.setStatus(HttpServletResponse.SC_OK);
//			return;
//		}
//
//		chain.doFilter(request, servletResponse);
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}
//
//}
