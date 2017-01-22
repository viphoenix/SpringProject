package com.chengfeng.aop.aopmethod;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * Created by chengfeng on 2017/1/22.
 */
public class PrintAfterReturning implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After method~~~");
    }
}
