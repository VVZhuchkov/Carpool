package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;
import com.github.vvzhuchkov.carpool.service.factory.FactoryService;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;
import com.github.vvzhuchkov.carpool.web.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@WebServlet(urlPatterns = {"/index.html", "/login"})
public class LoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    private static final AuthUserService authUserService = FactoryService.getInstance().getAuthUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        if (authUser == null) {
            WebUtil.forward("login", request, response);
            return;
        }
        WebUtil.redirect("/main", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        AuthUser authUser = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            authUser = authUserService.login(email, password);
        } catch (ServiceException e) {
            logger.error(Level.ERROR, e);
        }
        if (authUser == null) {
            request.setAttribute("error", "Invalid email or password");
            WebUtil.forward("login", request, response);
            return;
        }
        request.getSession().setAttribute("authUser", authUser);
        WebUtil.redirect("/main", request, response);
    }
}
