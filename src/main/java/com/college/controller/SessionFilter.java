package com.college.controller;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;



@WebFilter("/**")
@Component
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user has a session
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            // Redirect unauthenticated users to the login page, excluding the login page itself
            if (!httpRequest.getRequestURI().endsWith("/kumar/add")&&
                !httpRequest.getRequestURI().endsWith("/fetchresult")&&
                !httpRequest.getRequestURI().endsWith("/results")&&
                !httpRequest.getRequestURI().endsWith("/contact")&&
            		!httpRequest.getRequestURI().endsWith("/teacherintodb")&&
            		!httpRequest.getRequestURI().endsWith("/lecturerloginverify")&&
            		!httpRequest.getRequestURI().endsWith("/add")&&
            		!httpRequest.getRequestURI().endsWith("/verifyotp")&&
            		!httpRequest.getRequestURI().endsWith("/resetpassword")&&
            		!httpRequest.getRequestURI().endsWith("/details")&&
            		!httpRequest.getRequestURI().endsWith("/sendotp")&&
            		!httpRequest.getRequestURI().endsWith("/adminloginverify")&&!httpRequest.getRequestURI().endsWith("/adminlogin")&&!httpRequest.getRequestURI().endsWith("/results")&&!httpRequest.getRequestURI().endsWith("/lecturerlogin")&&!httpRequest.getRequestURI().endsWith("/")) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if any
    }

    @Override
    public void destroy() {
        
    }


}
