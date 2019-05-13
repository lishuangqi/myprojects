package com.lishuangqi.test.thead.callable;

import java.util.concurrent.*;

public class TestCallableFuture {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Task2 task = new Task2();
        Future<Integer> result = executor.submit(task);

        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + result.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            result.cancel(true);
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            sum += i;
        }
        return sum;
    }
}
