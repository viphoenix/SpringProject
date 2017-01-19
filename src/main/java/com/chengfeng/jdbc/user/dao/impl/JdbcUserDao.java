package com.chengfeng.jdbc.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

import com.chengfeng.jdbc.user.dao.UserDao;
import com.chengfeng.jdbc.user.model.User;

/**
 * Created by chengfeng on 2017/1/18.
 */
public class JdbcUserDao implements UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(User user) {
        String sql = "INSERT INTO user " + "(name) VALUES (?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            User user = null;
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("create_time"));
            }

            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }
/*
    public User findUserByName(String name) {
        String sql = "SELECT * FROM user WHERE id = ?";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, name);
            User user = null;
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("create_time"));
            }

            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    */
}
