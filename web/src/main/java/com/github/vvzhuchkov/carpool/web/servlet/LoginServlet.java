package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.model.RoleAuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;
import com.github.vvzhuchkov.carpool.service.factory.FactoryService;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;
import com.github.vvzhuchkov.carpool.service.interf.RoleService;
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
    private static final RoleService roleService = FactoryService.getInstance().getRoleService();

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
        try {
            String roleAuthUser = roleService.getAuthUserRole(authUser);
            request.getSession().setAttribute("role", roleAuthUser);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        WebUtil.redirect("/main", request, response);
    }
}
