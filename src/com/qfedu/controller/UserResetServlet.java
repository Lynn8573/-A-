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

@WebServlet("/UserResetServlet")
public class UserResetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        //设置字符集，防止中文乱码

        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl();
        if (userService.userResetPass(id) == 1){
            response.sendRedirect(request.getContextPath()+"/UserFuzzyServlet");
        }else{
            response.getWriter().append("重置密码失败");
        }
    }
}
