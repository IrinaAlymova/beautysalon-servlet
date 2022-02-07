package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Web filter that sets specific encoding to the request
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    private String ENCODING;

    public void init(FilterConfig filterConfig) throws ServletException {
        ENCODING = "utf-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        filterChain.doFilter(request, response);
    }

    public void destroy() {
    }
}
