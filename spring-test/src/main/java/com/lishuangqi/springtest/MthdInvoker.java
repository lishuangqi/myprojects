package com.lishuangqi.springtest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MthdInvoker implements MethodInterceptor {
    Class cglibProxy;
    public MthdInvoker(Class cglibProxy){
        this.cglibProxy =  cglibProxy;
    }

    private  void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        beforeMethod();
        return method.invoke(cglibProxy.newInstance(), args);
    }
}
