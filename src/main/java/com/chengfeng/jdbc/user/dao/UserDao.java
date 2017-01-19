package com.chengfeng.jdbc.user.dao;

import java.util.List;

import com.chengfeng.jdbc.user.model.User;

/**
 * Created by chengfeng on 2017/1/18.
 */
public interface UserDao {

    public void insert(User user);

    public User findUserById(int id);

    public List<User> findUserByName(String name);
}
