package com.chengfeng.beanlife.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.chengfeng.beanlife.service.impl.MyModel;

/**
 * Created by chengfeng on 2017/1/20.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    //作用于Bean初始化前
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof MyModel) {
            System.out
                    .println("BeanPostProcessor postProcessBeforeInitialization called");
        }
        return bean;
    }

    //作用于Bean初始化后
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof MyModel) {
            System.out
                    .println("BeanPostProcessor postProcessAfterInitialization called");
        }
        return bean;
    }
}
