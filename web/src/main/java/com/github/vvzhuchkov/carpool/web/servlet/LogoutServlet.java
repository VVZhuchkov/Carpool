package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.web.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("authUser") != null) {
            AuthUser authUser = (AuthUser) request.getSession().getAttribute("authUser");
            logger.info("Employee " + authUser.getId() + "logged out at" + LocalDateTime.now());
            request.getSession().removeAttribute("authUser");
        }
        request.getSession().invalidate();
        WebUtil.forward("login", request, response);
    }

}
