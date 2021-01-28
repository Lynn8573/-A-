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

@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
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
        Goods goods = new Goods();
        int rs =0 ;

        String uid = request.getParameter("id");
        String goodsName = request.getParameter("goodsName");
        String price  = request.getParameter("price");
        String imgPath = request.getParameter("imgPath");
        String comment = request.getParameter("comment");
        String typeId = request.getParameter("typeId");

        if (uid != null && !"".equals(uid)){

            goods.setId(Integer.parseInt(uid));
            goods.setGoodsName(goodsName);
            goods.setPrice(Integer.parseInt(price));
            goods.setImgPath(imgPath);
            goods.setComment(comment);
            goods.setTypeId(Integer.parseInt(typeId));
            rs = goodsService.updateGoods(goods);
        }else {
            if (goodsName == null || "".equals(goodsName)){
                goods.setGoodsName("5G手机");
            }else {
                goods.setGoodsName(goodsName);
            }
            if (price == null || "".equals(price)){
                goods.setPrice(9999);
            }else {
                goods.setPrice(Integer.parseInt(price));
            }
            if (imgPath == null || "".equals(imgPath)){
                String img="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1542746180,3783070933&fm=179&app=42&f=JPEG?w=121&h=140";
                goods.setImgPath(img);
            }else {
                goods.setImgPath(imgPath);
            }
            if (comment == null || "".equals(comment)){
                goods.setComment("这是一个测试商品");
            }else {
                goods.setComment(comment);
            }
            if ( typeId == null ||  "".equals(typeId)){
                goods.setTypeId(5);
            }else {
                goods.setTypeId(Integer.parseInt(typeId));
            }
            goods.setDeployDate("2020-10-23");
            rs = goodsService.addGoods(goods);
        }

        System.out.println("添加商品控制层打印得到的goods数据：" + goods.toString());
        if (rs > 0){
            response.sendRedirect(request.getContextPath()+"/FuzzySelectGoods");
        }else {
            response.getWriter().append("添加失败");
        }
    }
}
