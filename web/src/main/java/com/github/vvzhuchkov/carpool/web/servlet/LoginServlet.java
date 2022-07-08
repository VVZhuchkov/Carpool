package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;
import com.github.vvzhuchkov.carpool.service.factory.FactoryService;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;
import com.github.vvzhuchkov.carpool.web.WebUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    private static final AuthUserService authUserService = FactoryService.getInstance().getAuthUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Object authUser = request.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtils.forward("login", request, response);
            return;
        }
        WebUtils.redirect("/home", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        AuthUser authUser = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            authUser = authUserService.login(email, password);
            if (authUser == null) {
                request.setAttribute("error", "Invalid email or password");
                WebUtils.forward("login", request, response);
                return;
            }
        } catch (ServiceException e) {
            logger.error(Level.ERROR, e);
        }
            request.getSession().setAttribute("AuthUser", authUser);
        }
    }
