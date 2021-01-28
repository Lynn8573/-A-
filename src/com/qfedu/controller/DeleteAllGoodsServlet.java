package com.qfedu.controller;

import com.qfedu.service.GoodsService;
import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DeleteAllGoodsServlet")
public class DeleteAllGoodsServlet extends HttpServlet {
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

        String goodsid = request.getParameter("goodsid");
        String[] arrs = goodsid.split("[ ,]+");
        List<String> tmp = new ArrayList<String>();//新建List

        for(String str:arrs){

            if(str!=null && str.length()!=0){

                tmp.add(str);
            }
        }
        arrs= tmp.toArray(new String[0]);


        System.out.println(arrs.length);
        int count =0;
        for (int i =0; i<arrs.length;i++){
            int id = Integer.parseInt(arrs[i]);
            count += goodsService.delByGoodsId(id);
        }
        if (count == arrs.length){
            response.sendRedirect(request.getContextPath()+"/FuzzySelectGoods");
        }else {
            response.getWriter().append("批量删除失败");
        }

    }
}
