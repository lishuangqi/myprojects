package com.lishuangqi.springtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHanlder<T> implements InvocationHandler {
    T javaProxy;
    public MyInvocationHanlder(T javaProxy){
        this.javaProxy =  javaProxy;
    }

    private  void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        return method.invoke(javaProxy,args);
    }
}
