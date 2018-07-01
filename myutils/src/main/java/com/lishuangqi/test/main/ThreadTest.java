package com.lishuangqi.test.main;

/**
 * Created by michael on 2018/3/14.
 */
public class ThreadTest {
    private int j;

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();


        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(dec);
        Thread t3 = new Thread(inc);
        Thread t4 = new Thread(dec);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName()+"inc:"+j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName()+"dec:"+j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
