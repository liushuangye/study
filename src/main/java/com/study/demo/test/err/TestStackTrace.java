package com.study.demo.test.err;

import java.io.*;

public class TestStackTrace {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
    public static int factorial(int n){
        System.out.println("参数：:"+n);
        Throwable t = new Throwable();
        StackTraceElement[] frames = t .getStackTrace();
        for (StackTraceElement f : frames)
            System.out.println(f);
        int r;
        if(n <= 1) r = 1;
        else r = n * factorial(n-1);
        System.out.println("返回："+r);
        return r;
    }
}
