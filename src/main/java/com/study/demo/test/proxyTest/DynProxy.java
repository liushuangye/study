package com.study.demo.test.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynProxy implements InvocationHandler {
    private Object target;
    public DynProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        Object rtn = method.invoke(target, args);
        System.out.println("After invoke " + method.getName());
        return rtn;
    }
    //这里返回值使用泛型，这样不用到调用的地方再去强转
    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
