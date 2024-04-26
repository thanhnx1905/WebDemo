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
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter("/*")
//public class VueRouterFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
//        
//        boolean allowedPath = path.startsWith("/webapi") || path.startsWith("/assets") || path.equals("/index.html");
//        
//        if (allowedPath) {
//            chain.doFilter(req, res);
//        } else {
//        	response.sendRedirect("http://localhost:3000/");
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
