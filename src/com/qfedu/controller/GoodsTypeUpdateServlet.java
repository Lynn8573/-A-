package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
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
        GoodsType goodsType = new GoodsType();
        String sid = request.getParameter("id");
        String typename = request.getParameter("typename");

        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        int id;
        if (sid != null && !"".equals(sid)){
            id = Integer.parseInt(sid);
            goodsType.setId(id);
            goodsType.setTypename(typename);
            if (goodsTypeService.updateGoodsType(goodsType) == 1){
                request.setAttribute("goodsname",goodsType.getTypename());
                response.sendRedirect(request.getContextPath()+"/GoodsTypeSelectServlet");
            }else{
                response.getWriter().append("修改失败");
            }
        }else{
            goodsType.setTypename(typename);
            if ( goodsTypeService.addGoodsType(goodsType) == 1){
                response.sendRedirect(request.getContextPath()+"/GoodsTypeSelectServlet");
            }else{
                response.getWriter().append("添加失败");
            }
        }
    }
}
