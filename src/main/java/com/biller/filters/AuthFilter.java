package com.biller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        if(isAuthenticatedUser(httpReq)
                || httpReq.getServletPath().equals("/index.jsp")
                || httpReq.getServletPath().equals("/registration_page.jsp")
                || httpReq.getServletPath().equals("/authorization.jsp")) filterChain.doFilter(httpReq,httpResp);
        else httpResp.sendRedirect("index.jsp");
        System.out.println("FILTER");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private boolean isAuthenticatedUser(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        return Arrays.stream(cookies).anyMatch(cookie -> cookie.getName().equals("username"));
    }
}
