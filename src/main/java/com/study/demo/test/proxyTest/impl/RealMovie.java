package com.study.demo.test.proxyTest.impl;

import com.study.demo.test.proxyTest.IMovie;

public class RealMovie implements IMovie {
    @Override
    public void play() {
        System.out.println("放映电影！");
    }
}
