package com.chengfeng.beanlife.service.impl;

import com.chengfeng.beanlife.service.IModel;
import com.chengfeng.beanlife.service.IModelService;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class MyService implements IModelService {
    private IModel model;

    public MyService() {}

    public MyService(IModel model) {
        this.model = model;
    }

    public IModel getModel() {
        return model;
    }

    public void setModel(IModel model) {
        this.model = model;
    }

    public String toString() {
        if(model == null){
            return "none mode in service";
        }
        return  "bingo";
    }
}
