package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> fuzzySelectUser(int pageNo,int pageSize,String condition);
    public int userFuzzyDataCount(String condition);
    public int UserDeleteById(int id);
    public int userResetPass(int id);
    public int userAdd(User user);
    public int addUser(User user);
    public Boolean selectUserByName(String username);
    public Boolean loginUser(String username,String password);

}
