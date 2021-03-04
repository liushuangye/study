package com.study.design.abstractFactory;

import com.study.design.easyFactory.IObj;

class AirPlane implements IMoveable {
    @Override
    public void operation(){
        System.out.print("  开飞机  ");
    }
}
