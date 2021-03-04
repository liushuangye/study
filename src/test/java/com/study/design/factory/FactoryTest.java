package com.study.design.factory;

import com.study.design.abstractFactory.AbstractFacotry;
import com.study.design.abstractFactory.AirFactory;
import com.study.design.abstractFactory.WaterFactory;
import com.study.design.easyFactory.EasyFactory;
import com.study.design.easyFactory.IObj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {
    @Test
    public void easyFactoryTest(){
        IObj obj = EasyFactory.getObj(1);
        obj.fun();
        obj = EasyFactory.getObj(2);
        obj.fun();
    }
    @Test
    public void abstractFactoryTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AbstractFacotry airFactory = (AbstractFacotry)Class.forName(AirFactory.class.getName()).newInstance();
        airFactory.getMoveable().operation();
        airFactory.getEatable().operation();
        //开飞机    吃航空面包
        System.out.println();
        AbstractFacotry waterFactory = (AbstractFacotry)Class.forName(WaterFactory.class.getName()).newInstance();
        waterFactory.getMoveable().operation();
        waterFactory.getEatable().operation();
        //  开皮划艇    吃海鲜面包
    }

}