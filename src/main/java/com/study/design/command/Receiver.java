package com.study.design.command;

public class Receiver {
    public void open(){
        System.out.println("开机。。。");
    };
    public void addLight(){
        System.out.println("亮度 + 1");
    };
}
