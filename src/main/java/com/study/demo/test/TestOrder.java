package com.study.demo.test;

import java.util.Arrays;

public class TestOrder {
    public static void main(String[] args){
        System.out.println("----第一次构造child----");
        new Child("str");
        System.out.println("----第二次构造child----");
        new Child("str");
        /*
        ----第一次构造child----
        父类静态代码块1
        父类静态代码块2
        子类静态代码块1
        子类静态代码块2
        父类普通代码块1
        父类普通代码块2
        父类无参构造方法
        子类普通代码块1
        子类普通代码块2
        子类普通造方法
        ----第二次构造child----
        父类普通代码块1
        父类普通代码块2
        父类无参构造方法
        子类普通代码块1
        子类普通代码块2
        子类普通造方法
         */
    }



}
class Parent{
    Parent(){System.out.println("父类无参构造方法");}
    Parent(String str){System.out.println("父类普通造方法");}
    static{System.out.println("父类静态代码块1");}
    static{System.out.println("父类静态代码块2");}
    {System.out.println("父类普通代码块1");}
    {System.out.println("父类普通代码块2");}
}
class Child extends Parent{
    Child(){System.out.println("子类无参构造方法");}
    Child(String str){System.out.println("子类普通造方法");}
    static{System.out.println("子类静态代码块1");}
    static{System.out.println("子类静态代码块2");}
    {System.out.println("子类普通代码块1");}
    {System.out.println("子类普通代码块2");}
}
