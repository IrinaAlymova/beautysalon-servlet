package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter to access pages for authorized users only
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/services", "/home", "/"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Checks if session of this request contains user email attribute, forwards to login page
     * in case there's no necessary attribute or no session is associated with this request
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("email") == null) {
            request.getServletContext().getRequestDispatcher("/login").forward(request, response);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
