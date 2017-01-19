package com.chengfeng.jdbc.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.chengfeng.jdbc.user.dao.UserDao;
import com.chengfeng.jdbc.user.model.User;

/**
 * Created by chengfeng on 2017/1/18.
 */
public class JdbcUserDao extends JdbcDaoSupport implements UserDao {

    //private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
/*
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/
    public void insert(User user) {
        String sql = "INSERT INTO user " + "(name) VALUES (?)";

        getJdbcTemplate().update(sql, new Object[] {user.getName()});
    }

    public User findUserById(int id) {
        // 在findUserById调用结束后,局部变量会消失,但是内部类对象可能还一直存在,
        // 为了保证内部类能访问到局部变量,通过将局部变量复制一份来实现,同时将局部变量设置为final保证不变
        final User user = new User();
        String sql = "SELECT * FROM user WHERE id = ?";

        getJdbcTemplate().query(sql, new Object[]{id}, new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setCreateTime(resultSet.getString("create_time"));
                    }
                });

        return user;

    }

    public List<User> findUserByName(String name) {
        String sql = "SELECT * FROM user WHERE name = ? AND id < 100";
        final List<User> list = new ArrayList<User>();

        getJdbcTemplate().query(sql, new Object[] {name}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCreateTime(resultSet.getString("create_time"));
                list.add(user);
            }
        });

        return list;
    }

}
