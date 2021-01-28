package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.dao.impl.AdminDaoImpl;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;

/**
 * 业务逻辑层
 */
public class AdminServiceImpl implements AdminService {
    //登录验证方法
    @Override
    public boolean login(Admin admin) {
        //实例化对象，调用持久层方法
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.login(admin);
    }
}
