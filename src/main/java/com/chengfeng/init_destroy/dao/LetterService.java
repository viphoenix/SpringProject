package com.chengfeng.init_destroy.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by chengfeng on 2017/1/20.
 */
@Component("letterService")
public class LetterService {

    @Value("#{messageService}")
    public MessageService messageService;

    @Value("#{messageService.message}")
    public String message;

    @Override
    public String toString() {
        return "LetterService: " + message;
    }
}
