package com.chengfeng.jdbc.user.dao;

import com.chengfeng.jdbc.user.model.User;

/**
 * Created by chengfeng on 2017/1/18.
 */
public interface UserDao {

    public void insert(User user);

    public User findUserById(int id);

    //public User findUserByName(String name);
}
