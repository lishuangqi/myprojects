package com.lishuangqi.test.thead;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by michael on 2019/4/10.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        //在释放等待线程后可以重用
        final CyclicBarrier barrier = new CyclicBarrier(20);

        final ExecutorService es = Executors.newFixedThreadPool(20);

        System.out.println("****等人齐****");

        for (int i = 0; i < 20; i++) {

            final int j = i + 1;

            Runnable person = new Runnable() {

                @Override

                public void run() {

                    try {

                        System.out.println(j + "号来了");

                        if (barrier.await() == 0) {

                            System.out.println("****人都到齐了****");

                        }

                        System.out.println(j + "号开吃");

                        if (barrier.await() == 0) {

                            System.out.println("****吃完了出发****");

                        }

                        System.out.println(j + "号玩好了");

                        if (barrier.await() == 0) {

                            System.out.println("****游玩结束回家****");

                        }

                    } catch (Exception e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                    }

                }


            };

            es.submit(person);

        }

        es.shutdown();

    }


}
