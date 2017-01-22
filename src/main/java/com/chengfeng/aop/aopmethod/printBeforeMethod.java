package com.chengfeng.aop.aopmethod;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * Created by chengfeng on 2017/1/22.
 */

public class PrintBeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable{
        System.out.println("Before Method!!!");
    }
}
