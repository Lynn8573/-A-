package com.qfedu.controller;

import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        //设置字符集，防止中文乱码

        PageUtil pageUtil = new PageUtil();
        OrderService orderService =new OrderServiceImpl();
        StringBuffer condition = new StringBuffer();


        String username = request.getParameter("username");
        String status = request.getParameter("status");
        System.out.println(status);
        String pNo = request.getParameter("pageNo");

        if (username != null && !"".equals(username) && status != null && !"".equals(status)){
            condition.append(" and username like '%"+ username + "%'" + " and t_order.status = '" + status + "'" );
        }else if (username != null && !"".equals(username)){
            condition.append(" and username like '%"+ username + "%'");
        }else if (status != null && !"".equals(status)){
            condition.append(" and t_order.status = '" + status + "'" );
        }


        if (pNo == null){
            pNo ="1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 4;
        int dataCount = orderService.getDataCount(condition.toString());

        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);

        int pageCount = pageUtil.getPageCount();


        List<Order> orders = orderService.fuzzySelectOder(pageNo,pageSize,condition.toString());

        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);

        request.setAttribute("list",orders);
        System.out.println(orders.toString());
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);
    }
}
