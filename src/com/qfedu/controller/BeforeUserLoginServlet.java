package com.qfedu.controller;

import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BeforeUserLoginServlet")
public class BeforeUserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        //设置字符集，防止中文乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean rs = false;
        UserService userService = new UserServiceImpl();
        if (username != null
                && !"".equals(username)
                && password != null
                && !"".equals(password))
        {
            rs = userService.loginUser(username,password);
        }

        if (rs){
            response.sendRedirect(servletContext.getContextPath()+"/before/success.html");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/before/register.html");
        }
    }
}
