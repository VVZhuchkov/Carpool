package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;
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

import java.util.List;

@WebServlet("/create_user")
public class CreateUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CreateUserServlet.class);
    private static final AuthUserService authUserService = FactoryService.getInstance().getAuthUserService();
    private static final RoleService roleService = FactoryService.getInstance().getRoleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        WebUtil.forward("user/create_user", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String status = request.getParameter("status");
                String role = request.getParameter("role");

        WebUtil.forward("user/users", request, response);
    }
}
