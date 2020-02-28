package com.lishuangqi.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestApplication.class)
public class SpringTestApplicationTests {
    @Autowired
    private ApplicationContext context;
    @Test
    public void test() {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringTestApplication.class);
        MyBean myBean1 = (MyBean) context.getBean("myBean");
        System.out.println("mybean1 = " +myBean1.getMessage());
        MyBean myBean2 = (MyBean) context.getBean("&myBean");
        System.out.println("myBean2 = " +myBean2.getMessage());
        MyBean myBean3 = (MyBean) context.getBean("myBean");
        System.out.println("myBean3 = " +myBean3.getMessage());

        System.out.println("myBean1.equals(myBean2) = "+ myBean1.equals(myBean2));
        System.out.println("myBean1.equals(myBean3) = "+ myBean1.equals(myBean3));
        System.out.println("myBean2.equals(myBean3) = "+ myBean2.equals(myBean3));
    }


}
