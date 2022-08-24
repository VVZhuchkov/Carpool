package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.factory.FactoryService;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;
import com.github.vvzhuchkov.carpool.web.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainServlet.class);
    private static final AuthUserService authUserService = FactoryService.getInstance().getAuthUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        List<AuthUser> authUserList = authUserService.getAllAuthUsers();
        request.setAttribute("authUserList", authUserList);
        WebUtil.forward("main", request, response);
    }
}
