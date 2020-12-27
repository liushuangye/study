package com.study.demo.test.jiekou;
public interface MyInterface {
    static void staticMethocd(){System.out.println("staticMethocd");}
    default void dafaultMethocd(){System.out.println("dafaultMethocd");}
//    void method(){};//error
    void method();
}
