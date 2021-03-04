package com.study.design.abstractFactory;

import com.study.design.easyFactory.IObj;

class AirBread implements IEatable {
    @Override
    public void operation(){
        System.out.print("  吃航空面包  ");
    }
}
