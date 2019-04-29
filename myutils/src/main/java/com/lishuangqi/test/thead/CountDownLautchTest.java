package com.lishuangqi.test.thead;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by michael on 2019/4/10.
 */
public class CountDownLautchTest {
    public static void main(String[] args) {


        ExecutorService es = Executors.newFixedThreadPool(20);

        final CountDownLatch endFlag = new CountDownLatch(20);

        final CountDownLatch startFlag = new CountDownLatch(1);

        final CountDownLatch comeFlag = new CountDownLatch(20);


        for (int i = 0; i < 20; i++) {

            final int j = i + 1;

            Runnable person = new Runnable() {

                @Override

                public void run() {

                    System.out.println(j + "号游客来了");

                    comeFlag.countDown();

                    try {

                        startFlag.await();

                        Thread.sleep(1000);

                    } catch (InterruptedException e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                    } finally {

                        System.out.println(j + "号吃完了");

                        endFlag.countDown();

                    }

                }


            };

            es.submit(person);

        }

        try {

            comeFlag.await();   //保证所有人都到齐了

            System.out.println("人都齐了，大家一起吃饭");

            startFlag.countDown();//开吃

            endFlag.await();//等待所有人都吃完了

            System.out.println("全都吃完了，继续下个景点");

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        es.shutdown();

    }


}