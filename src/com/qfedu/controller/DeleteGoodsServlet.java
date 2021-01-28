package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;
import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
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

        GoodsService goodsService = new GoodsServiceImpl();

        String sid = request.getParameter("goodsid");

        System.out.println("删除商品控制层前端传回的id值:"+sid);
        int id =0;
        if (sid != null){
            id = Integer.parseInt(sid);
        }
        if (goodsService.delByGoodsId(id) == 1){
            response.sendRedirect(request.getContextPath()+"/FuzzySelectGoods");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}
