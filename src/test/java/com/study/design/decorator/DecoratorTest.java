package com.study.design.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {
    @Test
    public void test(){
        Component component = new Component();
        System.out.println("--------------------被装饰的元素单独使用-------------------");
        component.operation();
        System.out.println("\n--------------------被A装饰-------------------");
        AComponentDecorator aComponentDecorator = new AComponentDecorator(component);
        aComponentDecorator.operation();
        System.out.println("\n--------------------被B装饰-------------------");
        BComponentDecorator bComponentDecorator = new BComponentDecorator(component);
        bComponentDecorator.operation();
        System.out.println("\n--------------------被A和B同时装饰-------------------");
        AComponentDecorator aDecorator = new AComponentDecorator(component);
        BComponentDecorator bDecorator = new BComponentDecorator(aDecorator);
        bDecorator.operation();
    }
}