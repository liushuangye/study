package com.study.demo.test;

public class test {
    public static void main(String[] args){
        System.out.println("静态域-基本数据类型int："+T.si);
        System.out.println("静态域-基本数据类型int："+T.so);
        T t = new T();
        System.out.println("实例域-基本数据类型int："+t.oi);
        System.out.println("实例域-基本数据类型int："+t.oo);
        /*
        静态域-基本数据类型int：0
        静态域-基本数据类型int：null
        实例域-基本数据类型int：0
        实例域-基本数据类型int：null
        */
    }
}
class T{
    static int si;
    static O so;
    int oi;
    O oo;
}
class O{
}