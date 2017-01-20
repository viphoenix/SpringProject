package com.chengfeng.init_destroy.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class MessageService implements InitializingBean, DisposableBean {

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method after properties are set : " + message);
    }

    public void destroy() throws Exception{
        System.out.println("Spring Container is destroy! Customer clean up");
    }
}
