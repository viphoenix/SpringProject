package com.chengfeng.beanlife.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import com.chengfeng.beanlife.service.impl.MyModel;
import com.sun.javafx.property.adapter.PropertyDescriptor;

/**
 * Created by chengfeng on 2017/1/20.
 */
/*
 * 继承自一个抽象类，主要实现的还是InstantiationAwareBeanPostProcessor接口的方法，
 * 该接口作用于实例化阶段，完成实例化，属性描述修改以及实例化后处理逻辑
 **/
@Component
public class MyInstantiationBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {

    public Object postProcessBeforeInstantiation(Class<?> beanClass,
                                                 String beanName) throws BeansException {
        if (beanClass.isAssignableFrom(MyModel.class)) {
            System.out
                    .println("InstantiationBeanPostProcessor postProcessBeforeInstantiation called");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof MyModel) {
            System.out
                    .println("InstantiationBeanPostProcessor postProcessAfterInstantiation called");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if (bean instanceof MyModel) {
            System.out
                    .println("InstantiationBeanPostProcessor postProcessPropertyValues called");
        }
        return pvs;
    }

}
