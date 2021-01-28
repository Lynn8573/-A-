package com.qfedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        if (requestURI.endsWith(request.getContextPath()+"/after/login.jsp") || requestURI.endsWith(request.getContextPath()+"/LoginServlet")) {

            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath()+"/after/login.jsp");
        } else if (session != null && session.getAttribute("username") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
