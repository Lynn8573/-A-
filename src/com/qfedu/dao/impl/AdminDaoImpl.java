package com.qfedu.dao.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public boolean login(Admin admin) {
        String sql = "select * from admin where username = ? and password = ? ";
        boolean check =false;
        Object[] object = {admin.getUsername(),admin.getPassword()};
        try {
            ResultSet select = this.select(sql,object);
            while (select.next()){
                check =true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
