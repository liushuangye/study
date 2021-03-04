package com.study.design.easyFactory;

public class EasyFactory {
    public static IObj getObj(int type){
        if(type == 1){
            return new Car();
        }
        if(type == 2){
            return new Bread();
        }
        return new Car();
    }
}
