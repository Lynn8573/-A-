package com.qfedu.service.impl;
import com.qfedu.dao.OrderDao;
import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int getDataCount(String condition) {
        return orderDao.getDataCount(condition);
    }

    @Override
    public List<Order> fuzzySelectOder(int pageNo, int pageSize, String condition) {
        return orderDao.fuzzySelectOder(pageNo,pageSize,condition);
    }

    @Override
    public int delOrder(int id) {
        return orderDao.delOrder(id);
    }
}
