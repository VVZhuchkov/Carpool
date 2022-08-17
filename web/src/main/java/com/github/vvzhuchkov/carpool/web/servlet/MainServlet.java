package com.github.vvzhuchkov.carpool.web.servlet;

import com.github.vvzhuchkov.carpool.web.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        WebUtil.forward("main", request, response);
    }
}
