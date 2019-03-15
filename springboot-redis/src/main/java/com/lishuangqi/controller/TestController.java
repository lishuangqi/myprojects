package com.lishuangqi.controller;

import com.lishuangqi.service.TestService;
import com.lishuangqi.utils.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by michael on 2019/3/15.
 */
@RestController
public class TestController {
    @Autowired
    DistributedLock distributedLock;
    @Autowired
    TestService testService;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add() {
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
//            TestService testService = new TestService();
            ThreadA threadA = new ThreadA(testService);
//			threadA.start();

            newCachedThreadPool.execute(threadA);
        }
        return " Result is " + 1;
    }


    @RequestMapping(value = "/testLock" ,method = RequestMethod.GET)
    public String testLock(String id) {
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
            ThreadB threadB = new ThreadB(testService, id);
            newCachedThreadPool.execute(threadB);
        }
        return " Result is " + 1;
    }

    public class ThreadA extends Thread {
        private TestService service;

        public ThreadA(TestService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.seckill();
        }
    }

    public class ThreadB extends Thread {
        private TestService service;
        private String id;

        public ThreadB(TestService service, String id) {
            this.service = service;
            this.id = id;
        }

        @Override
        public void run() {
            service.testLock(id);
        }
    }
}
