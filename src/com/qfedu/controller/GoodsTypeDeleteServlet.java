package com.qfedu.controller;

import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
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

        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        if (goodsTypeService.delById(id) == 1){ response.sendRedirect(request.getContextPath()+"/GoodsTypeSelectServlet"); }
        else {response.getWriter().append("删除失败");}

    }
}
