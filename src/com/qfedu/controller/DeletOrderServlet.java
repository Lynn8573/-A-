package com.qfedu.controller;

import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeletOrderServlet")
public class DeletOrderServlet extends HttpServlet {
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

        String  orderid = request.getParameter("orderid");
        int id = 0;
        if (orderid != null){
            id = Integer.parseInt(orderid);
        }

        OrderService orderService = new OrderServiceImpl();

        if (orderService.delOrder(id) == 1){
            response.sendRedirect(request.getContextPath()+"/OrderFuzzySelectServlet");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}
