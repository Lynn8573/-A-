package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    public List<User> fuzzySelectUser(int pageNo,int pageSize,String condition){
        String sql = "select * from t_user where 1=1 " + condition + " limit ?, ?";
        Object [] objects = {(pageNo - 1) * pageSize,pageSize};
        List<User> list = new ArrayList<User>();
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                //    private int id;
                //    private String username;
                //    private String password;
                //    private String phone;
                //    private String sex;
                //    private String mail;
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setSex(resultSet.getString("sex"));
                user.setMail(resultSet.getString("mail"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int userFuzzyDataCount(String condition) {
        String sql = "select count(1) from t_user where 1=1 " + condition;
        Object[] objects = {};
        int count = 0;
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                count = resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("dao层数据总条数"+count);
        return count;
    }

    @Override
    public int UserDeleteById(int id) {
        String sql = "delete from t_user where id = ?";
        Object[] object = {id};
        return  this.setUpdate(sql,object);

    }

    @Override
    public int userResetPass(int id) {
        String sql = "update t_user set password=123 where id = ?";
        Object[] objects = {id};
        return this.setUpdate(sql,objects);
    }

    @Override
    public int userAdd(User user) {
        //    private int id;
        //    private String username;
        //    private String password;
        //    private String phone;
        //    private String sex;
        //    private String mail;
        String sql = "INSERT INTO t_user (username,password,phone,sex,mail) VALUES ( ?, ?, ?, ?, ?)";
        Object[]objects = {
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                user.getSex(),
                user.getMail()
        };
        return this.setUpdate(sql,objects);
    }

    @Override
    public int addUser(User user) {
        //String sql= "INSERT INTO t_goods (goodsName,price,imgPath,comment,typeId) VALUES ( ?, ?, ?, ?, ?)";
        String sql = " INSERT into t_user (username,password,phone,mail) values(?,?,?,?)";
        Object[]objects={user.getUsername(),user.getPassword(),user.getPhone(),user.getMail()};
        return this.setUpdate(sql,objects);
    }

    @Override
    public Boolean selectUserByName(String username) {
        String sql = "select * from t_user where username = ?";
        Object [] objects = {username};
        boolean rs = false;
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                rs = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public Boolean loginUser(String username, String password) {
        String sql = "select * from t_user where username=? and password=? ";
        Object[] objects = {username,password};
        boolean rs = false;
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                rs = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
