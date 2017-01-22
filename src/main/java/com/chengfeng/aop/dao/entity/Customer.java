package com.chengfeng.aop.dao.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by chengfeng on 2017/1/22.
 */
@Component("AOPCustomer")
public class Customer {

    @Value("Jack")
    private String name;

    @Value("www.google.com")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "Customer: name=" + name + " url=" + url;
    }
}
