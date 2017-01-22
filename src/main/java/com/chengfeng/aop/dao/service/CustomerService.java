package com.chengfeng.aop.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.chengfeng.aop.dao.entity.Customer;

/**
 * Created by chengfeng on 2017/1/22.
 */
@Component
public class CustomerService {

    @Autowired
    @Qualifier("AOPCustomer")
    public Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void printName() {
        System.out.println("Customer name : " + customer.getName());
    }

    public void printURL() {
        System.out.println("Customer website : " + customer.getUrl());
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }
}
