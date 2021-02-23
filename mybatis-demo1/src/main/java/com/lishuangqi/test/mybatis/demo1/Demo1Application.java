package com.lishuangqi.test.mybatis.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//@MapperScan("com.lishuangqi.test.mybatis.demo1.mapper")
@MapperScan("com.lishuangqi.test.mybatis.demo1.mapper")
@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
