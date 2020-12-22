package com.study.demo.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName(Entity.class.getName());
        Entity e = new Entity();
        e.setName("小明");
        Field nameField = clazz.getDeclaredField("name");
        //name是私有属性 如果不setAccessible，nameField.get(e)会报java.lang.IllegalAccessException
        nameField.setAccessible(true);//
        String name = (String) nameField.get(e);
        System.out.println(name);//小明
    }
}
