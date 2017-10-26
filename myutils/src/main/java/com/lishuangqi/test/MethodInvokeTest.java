package com.lishuangqi.test;

import java.lang.reflect.Method;

/**
 * Created by michael on 2017/10/26.
 */
public class MethodInvokeTest {
    public static void main(String[] args) throws Exception {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));  // HELLO

        Object obj = Class.forName(MethodInvokeObj.class.getName()).newInstance();
        Method m1 = obj.getClass().getMethod("setName",String.class);
        Method m2 = obj.getClass().getMethod("getName");
        m1.invoke(obj,"aaaa");

        System.out.println(m2.invoke(obj));
    }
}
