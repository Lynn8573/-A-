package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BeforeUserRegisterServlet")
public class BeforeUserRegisterServlet extends HttpServlet {
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
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");

        User user = new User();
        UserService userService = new UserServiceImpl();



        int row = 0;
        if (username != null && !"".equals(username)
                && password != null && !"".equals(password)){
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setMail(mail);
            row = userService.addUser(user);
        }
        if (row >0){
            response.sendRedirect(request.getContextPath()+"/before/login.html");
        }else {
            response.getWriter().append("注册失败,注意是否有少填的信息!!!");
        }
    }
}
