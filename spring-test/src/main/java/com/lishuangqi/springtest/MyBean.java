package com.lishuangqi.springtest;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements FactoryBean {
    private String message;
    public MyBean(){
        this.message="通过构造方法初始化实例";
    }

    @Override
    public Object getObject() throws Exception {
        MyBean myBean= new MyBean();
        myBean.message= "通过FactoryBean.getObjet()创建实例";
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    public String getMessage() {
        return this.message;
    }
}
