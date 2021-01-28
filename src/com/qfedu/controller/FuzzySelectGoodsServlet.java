package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FuzzySelectGoods")
public class FuzzySelectGoodsServlet extends HttpServlet {
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
        PageUtil pageUtil = new PageUtil();
        StringBuffer condition =new StringBuffer();

        String pNo = request.getParameter("pageNo");
        String goodsname = request.getParameter("goodsname");
        String deployDate = request.getParameter("deployDate");
        String typeId = request.getParameter("typeId");

        System.out.println(typeId);
        //if (username != null && !"".equals(username)&& sex != null && !"".equals(sex)) {
        //            condition.append("and username like '%" + username + "%'" + " and sex =\""+ sex+ "\"");
        //        } else if (username != null && !"".equals(username)) {
        //            condition.append("and username like '%" + username + "%'" );
        //        } else if (sex != null && !"".equals(sex)) {
        //            condition.append(" and sex =\""+ sex+ "\"");
        //        }
        //        String pNo = request.getParameter("pageNo");
        //        if (pNo == null) {
        //            pNo = "1";
        //        }

        if (goodsname != null && !"".equals(goodsname) && deployDate != null && !"".equals(deployDate) && typeId != null && !"".equals(typeId)) {
            condition.append(" and  goodsname like '%" + goodsname + "%'" + " and deployDate like '%" + deployDate + "%'" + " and typeId like '%" + typeId + "%'" );
        }else if (goodsname != null && !"".equals(goodsname)
                && deployDate != null && !"".equals(deployDate)){
            condition.append(" and  goodsname like '%" + goodsname + "%'" + " and deployDate like '%" + deployDate + "%'");
        }else if (deployDate != null && !"".equals(deployDate)
                && typeId != null && !"".equals(typeId)){
            condition.append(" and deployDate like '%" + deployDate + "%'" + " and typeId like '%" + typeId + "%'" );
        }else if (goodsname != null && !"".equals(goodsname)&& typeId != null && !"".equals(typeId)){
            condition.append(" and  goodsname like '%" + goodsname + "%'" + " and typeId like '%" + typeId + "%'" );
        }else if (goodsname != null && !"".equals(goodsname)){
            condition.append(" and  goodsname like '%" + goodsname + "%'");
        }else if (deployDate != null && !"".equals(deployDate)){
            condition.append(" and deployDate like '%" + deployDate + "%'" );
        }else if(typeId != null && !"".equals(typeId)){
            condition.append(" and typeId like '%" + typeId + "%'");
        }

        System.out.println("控制层condition.toString()输出结果：  "+condition.toString());

        if (pNo == null){
            pNo = "1";
        }

        int pageNo = Integer.parseInt(pNo);
        int pageSize = 5;
        int dataCount = goodsService.getFuzzyDataCount(condition.toString());

        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();

        List<Goods> list = goodsService.fuzzySelectGoods(pageNo,pageSize,condition.toString());

        //test
        for (Goods goods : list) {
            System.out.println("控制层获取数据库返回对象: " + goods);
        }

        //test
        System.out.println("控制层获取pageNo" + pageNo);
        System.out.println("控制层获取pageSize" + pageSize);
        System.out.println("控制层获取pageCount" + pageCount);


        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);


        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);
    }
}
