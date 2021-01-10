package com.study.demo.test.proxyTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib前置处理");
        Object invokeSuper = methodProxy.invokeSuper(object, args);
        System.out.println("CGLib后置处理");
        return invokeSuper;
    }
}