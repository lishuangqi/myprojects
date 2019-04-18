package com.lishuangqi.test.thead;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by michael on 2019/4/17.
 */
public class TheadTest extends Thread{
    private Lock lock = new ReentrantLock();
    private static int aaa = 100;
    private CountDownLatch countDownLatch;
    public TheadTest (CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    public void testLock(String name ){
        lock.lock();
        try{
            countDownLatch.countDown();
            System.out.println(name+": "+ countDownLatch.getCount()+":" +aaa--);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void run(){
        try {

            int b=(int)(Math.random()*10);//生成[0,9]之间的随机整数。
            int temp=1+(int)(Math.random()*(5)); //生成从m到n的随机整数[m,n]
            Thread.sleep(temp *1000);
            testLock(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
//        TheadTest tt= new TheadTest(countDownLatch);
//        tt.start();
//        TheadTest tt1= new TheadTest(countDownLatch);
//        tt1.start();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for(int i =0; i < 100; i++) {
//            executorService.execute(new TheadTest(countDownLatch));
            executorService.execute(new TestFuture());
        }
//        tt.interrupt();
//        tt.testLock("aaa");
    }
}
