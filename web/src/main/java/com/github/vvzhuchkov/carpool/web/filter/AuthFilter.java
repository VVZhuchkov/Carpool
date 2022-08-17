package com.github.vvzhuchkov.carpool.web.filter;

import com.github.vvzhuchkov.carpool.web.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/main")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object authUser = request.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtil.forward("login", request, response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
