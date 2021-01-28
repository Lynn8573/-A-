package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
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

        String pNo = request.getParameter("pageNo");
        if (pNo == null ) {
            pNo = "1";
        }
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        PageUtil pageUtil = new PageUtil();
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 3;
        int dataCount = goodsTypeService.getDataCount();
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);

        int pageCount = pageUtil.getPageCount();
        List<GoodsType> list = goodsTypeService.GoodsTypeFuzzySelect(pageNo,pageSize);
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);

        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);

    }
}
