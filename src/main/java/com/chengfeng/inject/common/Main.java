package com.chengfeng.inject.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chengfeng.inject.customer.Customer;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Customer customer = (Customer) context.getBean("customer");

        System.out.println(customer);
    }
}
