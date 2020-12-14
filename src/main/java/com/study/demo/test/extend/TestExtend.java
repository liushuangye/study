package com.study.demo.test.extend;
public class TestExtend {
    public static void main(String[] args) {
        Parent p1 = new Child();
        Parent p2 = new Child2();
        p1.doIt();
        p2.doIt();
        /*
        由于Parent是抽象的，所以p1/p2不会调用Parent的doIt(),而是引用Child、Child2这样的具体对象的方法
        child do
        child2 do
         */
        String ok1 = "OK";
        String ok2 = new String("OK");
        System.out.println(ok1.hashCode());//2524
        System.out.println(ok2.hashCode());//2524
    }
}
