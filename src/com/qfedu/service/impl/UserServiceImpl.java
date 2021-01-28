package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition){
        List<User> list = userDao.fuzzySelectUser(pageNo, pageSize, condition);
        return list;
    }

    @Override
    public int userFuzzyDataCount(String condition) {

        System.out.println("service层数据条数:"+userDao.userFuzzyDataCount(condition));
        return userDao.userFuzzyDataCount(condition);

    }

    @Override
    public int UserDeleteById(int id) {
        return userDao.UserDeleteById(id);
    }

    @Override
    public int userResetPass(int id) {
        return userDao.userResetPass(id);
    }

    @Override
    public int userAdd(User user) {
        return userDao.userAdd(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Boolean selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    public Boolean loginUser(String username, String password) {
        return userDao.loginUser(username,password);
    }
}
