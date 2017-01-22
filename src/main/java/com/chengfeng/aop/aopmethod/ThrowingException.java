package com.chengfeng.aop.aopmethod;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by chengfeng on 2017/1/22.
 */
public class ThrowingException implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("Exception be catched!!!");
    }
}
