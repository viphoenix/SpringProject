package com.chengfeng.beanlife.context;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.chengfeng.beanlife.service.IModel;
import com.chengfeng.beanlife.service.IModelService;
import com.chengfeng.beanlife.service.impl.MyModel;
import com.chengfeng.beanlife.service.impl.MyService;

/**
 * Created by chengfeng on 2017/1/20.
 */

@Configuration
public class ServiceConfiguration {

    @Bean
    public IModelService myService() {
        return new MyService(myModel());
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public IModel myModel() {
        return new MyModel();
    }
}
