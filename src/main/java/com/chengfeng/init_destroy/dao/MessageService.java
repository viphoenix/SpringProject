package com.chengfeng.init_destroy.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by chengfeng on 2017/1/20.
 */
/*
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
*/
@Component("messageService")
public class MessageService {

    @Value("Component message")
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //属性注入后,执行初始化方法
    public void initMethod() {
        System.out.println("Init method after properties are set : " + message);
    }

    //context.close()后,执行cleanUpMethod
    public void cleanUpMethod() {
        System.out.println("Spring Container is destroy! MessageService clean up");
    }

}
