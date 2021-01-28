package com.qfedu.controller;
import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.service.impl.AdminServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
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
        //从前端页面接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //实例化对象，调用逻辑和方法
        AdminService adminService = new AdminServiceImpl();
        //实例化admin对象，进行构造方法赋值
        Admin admin = new Admin(username,password);
        //将实例化的admin对象传入到adminService方法中，获取结果
        boolean logincheck = adminService.login(admin);
        //为真判断，如果为真则重定向到UserFuzzySelect
        //如果为假则重定向到当前jsp页面中
        if(logincheck){
            request.getSession().setAttribute("username", username);
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/after/login.jsp");
        }
    }
}
