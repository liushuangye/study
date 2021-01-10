package com.study.demo.test.proxyTest.impl;

import com.study.demo.test.proxyTest.IMovie;

public class ProxyMovie implements IMovie {
    private IMovie realMovie;
    public ProxyMovie(IMovie realMovie){
        this.realMovie = realMovie;
    }
    @Override
    public void play() {
        System.out.println("买爆米花！");
        realMovie.play();
        System.out.println("收拾垃圾！");
    }
}
