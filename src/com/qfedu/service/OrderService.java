package com.qfedu.service;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderService {
    public int getDataCount(String condition);
    public List<Order> fuzzySelectOder(int pageNo,int pageSize,String condition);
    public int delOrder(int id);
}
