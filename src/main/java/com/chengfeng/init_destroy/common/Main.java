package com.chengfeng.init_destroy.common;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chengfeng.init_destroy.dao.MessageService;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageService messageService = (MessageService) context.getBean("messageServiceBean");

        System.out.println(messageService);

        context.close();
    }
}
