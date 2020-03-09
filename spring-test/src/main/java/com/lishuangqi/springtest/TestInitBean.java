package com.lishuangqi.springtest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestInitBean implements InitializingBean {
    private String a,b;
    @Override
    public void afterPropertiesSet() throws Exception {
        a="123";
        b="321";
    }

    public String getA() {
        return this.a;
    }

    public void setA(final String a) {
        this.a = a;
    }

    public String getB() {
        return this.b;
    }

    public void setB(final String b) {
        this.b = b;
    }
}
