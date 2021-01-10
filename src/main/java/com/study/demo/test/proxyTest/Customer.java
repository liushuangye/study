package com.study.demo.test.proxyTest;

import com.study.demo.test.proxyTest.impl.ProxyMovie;
import com.study.demo.test.proxyTest.impl.RealMovie;

public class Customer {
    public static void main(String[] args) {
        System.out.println("-----------直接调用-------------");
        IMovie realMovie = new RealMovie();
        seeMovie(realMovie);

        System.out.println("-----------静态代理-------------");
        /**
         * ProxyMovie不实现IMovie接口也可以对RealMovie进行增强
         * 但是我们可看出直接调用 用户看电影的方法seeMovie 与 代理调用并没有修改seeMovie方法的业务逻辑
         * 这是因为RealMovie和ProxyMovie都实现了IMovie接口。
         */
        IMovie proxyMovie = new ProxyMovie(realMovie);
        seeMovie(proxyMovie);

        System.out.println("-----------动态代理-------------");
        DynProxy proxy = new DynProxy(realMovie);
        IMovie movieDynProxy = proxy.getProxy();
        seeMovie(movieDynProxy);
    }
    public static void seeMovie(IMovie movie){
        movie.play();
    }
}
