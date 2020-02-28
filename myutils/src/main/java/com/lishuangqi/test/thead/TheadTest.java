package com.lishuangqi.test.thead;

import java.util.concurrent.*;
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

    private static ExecutorService executorService1 = Executors.newFixedThreadPool(30);

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
//        TheadTest tt= new TheadTest(countDownLatch);
//        tt.start();
//        TheadTest tt1= new TheadTest(countDownLatch);
//        tt1.start();
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for(int i =0; i < 100; i++) {
//            executorService.execute(new TheadTest(countDownLatch));
            executorService.execute(()->{
                scenetTask();
            });
        }
        executorService.shutdown();
//        tt.interrupt();
//        tt.testLock("aaa");
        System.out.println("11112");
    }

    private static void scenetTask() {
        Future<Boolean> future = executorService1.submit(() -> {
            int temp=1+(int)(Math.random()*(5));
            Thread.sleep(temp*1000);
            return true;

        });
        try {
            if (future.get(2, TimeUnit.SECONDS)) {
                System.out.println("任务执行成功");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("执行超时");
            future.cancel(true);
        }
    }
}
