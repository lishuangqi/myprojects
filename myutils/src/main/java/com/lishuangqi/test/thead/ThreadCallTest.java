package com.lishuangqi.test.thead;

import java.util.concurrent.*;

/**
 * Created by michael on 2019/4/18.
 */
public class ThreadCallTest {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        TaskCallable task = new TaskCallable();

        Future<Integer> result = exe.submit(task);
        exe.shutdown();

        try {
            System.out.println("11");
            System.out.println("call result" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("over");

    }

    static class TaskCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("begin ....");
            Thread.sleep(3000);
            return 100;
        }
    }

}
