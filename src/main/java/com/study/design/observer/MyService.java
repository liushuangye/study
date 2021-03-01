package com.study.design.observer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
class MyService {
    @Autowired
    ApplicationContext applicationContext;

    public void deal(){
        System.out.println("**************************************************");
        System.out.println("do something...");
        applicationContext.publishEvent(new MyEvent("我"));
        System.out.println("---------------------------------------------------");
        applicationContext.publishEvent(new OtherEvent("其他"));
        System.out.println("**************************************************");
    }
}
