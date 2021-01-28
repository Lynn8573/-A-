package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int getDataCount(String condition) {
        String sql = "select count(1) from t_order, t_user, t_status where 1=1 and t_order.status = t_status.id and t_order.uid = t_user.id" + condition;
        Object[]objects={};
        int count =0;
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                count = resultSet.getInt("count(1)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("订单dao层数据总条数"+count);
        return count;
    }

    @Override
    public List<Order> fuzzySelectOder(int pageNo, int pageSize, String condition) {
        String sql = "select * from t_order, t_user, t_status where 1=1 and t_order.status = t_status.id and t_order.uid = t_user.id " + condition + " limit ?, ?";
        Object [] objects = {(pageNo-1)*pageSize,pageSize};

        List<Order> list = new ArrayList<Order>();
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                Order order = new Order();
                //id,orderCode,totalPrice,order_status,createDate,username
                order.setId(resultSet.getInt("t_order.id"));
                order.setOrderCode(resultSet.getString("orderCode"));
                order.setTotalPrice(resultSet.getDouble("totalPrice"));
                order.setOrderStatus(resultSet.getString("order_status"));
                order.setCreateDate(resultSet.getString("createDate"));
                order.setUsername(resultSet.getString("username"));
                list.add(order);
                System.out.println(order.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DaoImpl层输出："+list.toString());
        return list;

    }

    @Override
    public int delOrder(int id) {
        String sql = "delete from t_order where id =? ";
        Object[] objects = {id};
        return this.setUpdate(sql,objects);
    }
}
