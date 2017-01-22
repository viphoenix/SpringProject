package com.chengfeng.beanlife.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.chengfeng.beanlife.service.IModel;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class MyModel implements IModel {

    private static AtomicInteger i = new AtomicInteger(0);

    private int value;

    public MyModel() {
        System.out.println("MyMode constructor call");
        this.value = i.incrementAndGet();
    }

    public void print() {
        System.out.println("MyMode print called");
        System.out.println(value);
    }

    public void beanInit() {
        System.out.println("Mode @Bean anno Init called");
    }


    public void beanDestroy() {
        System.out.println("Mode @Bean anno destory called");
    }


    @PostConstruct
    public void annotationInit() {
        System.out.println("Mode @PostConstruct anno init called");
    }


    @PreDestroy
    public void annotationDestroy() {
        System.out.println("Mode @PreDestroy anno destory called");
    }
}
