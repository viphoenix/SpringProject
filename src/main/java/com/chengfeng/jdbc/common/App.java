package com.chengfeng.jdbc.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chengfeng.jdbc.user.dao.UserDao;
import com.chengfeng.jdbc.user.model.User;

/**
 * Created by chengfeng on 2017/1/18.
 */
public class App {
    public static void main(String[] args) {
        //自动加载src/resources目录下的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao)context.getBean("jdbcUserDao");
        User user = new User("mike");
        userDao.insert(user);

        User user1 = userDao.findUserById(3);
        System.out.println(user1);

        List<User> list = userDao.findUserByName("mike");
        System.out.println(list);
    }
}
