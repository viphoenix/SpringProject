package com.chengfeng.aop.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chengfeng.aop.dao.service.CustomerService;

/**
 * Created by chengfeng on 2017/1/22.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerService customerService = (CustomerService) context.getBean("customerServiceProxy");

        customerService.printName();

        customerService.printURL();

        try {
            customerService.printThrowException();
        } catch (Exception e) {

        }
    }
}
