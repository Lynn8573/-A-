package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserFuzzySelect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        //设置字符集，防止中文乱码


        UserService userService = new UserServiceImpl();
        PageUtil pageUtil = new PageUtil();

        StringBuffer condition=new StringBuffer();
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");

        if (username != null && !"".equals(username)&& sex != null && !"".equals(sex)) {
            condition.append(" and username like '%" + username + "%'" + " and sex =\""+ sex+ "\"");
        } else if (username != null && !"".equals(username)) {
            condition.append(" and username like '%" + username + "%'" );
        } else if (sex != null && !"".equals(sex)) {
            condition.append(" and sex =\""+ sex+ "\"");
        }

        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }

        int pageNo = Integer.parseInt(pNo);
        int pageSize = 5;
        int dataCount = userService.userFuzzyDataCount(condition.toString());

        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);

        int pageCount = pageUtil.getPageCount();
        System.out.println(pageCount);

        List<User> users = userService.fuzzySelectUser(pageNo,pageSize,condition.toString());

        request.setAttribute("list",users);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);

        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);

    }
}
