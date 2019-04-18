package com.lishuangqi.test.thead;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * Created by michael on 2019/4/18.
 */
public class TestCompletableFuture extends Thread {
    final static ExecutorService executor = Executors.newFixedThreadPool(2);
    private static RpcService rpcService = new RpcService();
    private static HttpService httpService = new HttpService();

    public TestCompletableFuture() {
    }

    @Override
    public void run() {
        try {

            CompletableFuture asyncFuture1 = new CompletableFuture();
            CompletableFuture asyncFuture2 = new CompletableFuture();

            long startTime1 = System.currentTimeMillis();
            executor.submit(() -> {
                try {
                    asyncFuture1.complete(rpcService.getRpcRequest());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            long startTime2 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ":asyncFuture1: " + (startTime2 - startTime1));
            executor.submit(() -> {
                try {
                    asyncFuture2.complete(httpService.getHttpRequest());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            long startTime3 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ":asyncFuture2: " + (startTime3 - startTime2));
            CompletableFuture<Integer> asyncFuture3 = CompletableFuture.allOf(asyncFuture1, asyncFuture2)
                    .thenApplyAsync((v) -> {
                        Integer result = 0;
                        try {
                            result = (Integer) asyncFuture1.get() + (Integer) asyncFuture2.get();
                            System.out.println(Thread.currentThread().getName() +result);
                            System.out.println(Thread.currentThread().getName() + ":asyncFuture3 finish " );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return result;
                    });
            long startTime4 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ":total: " + (startTime4 - startTime1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> getHttpData(Integer addV) throws IOException {
        CompletableFuture asyncFuture1 = new CompletableFuture();
        CompletableFuture asyncFuture2 = new CompletableFuture();

        long startTime1 = System.currentTimeMillis();
        executor.submit(() -> {
            try {
                asyncFuture1.complete(rpcService.getRpcRequest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long startTime2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ":asyncFuture1: " + (startTime2 - startTime1));
        executor.submit(() -> {
            try {
                asyncFuture2.complete(httpService.getHttpRequest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long startTime3 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ":asyncFuture2: " + (startTime3 - startTime2));
        CompletableFuture<Integer> asyncFuture3 = CompletableFuture.allOf(asyncFuture1, asyncFuture2)
                .thenApplyAsync((v) -> {
                    Integer result = 0;
                    try {
                        System.out.println(asyncFuture1.get());
                        System.out.println(asyncFuture2.get());
                        result = (Integer) asyncFuture1.get() + (Integer) asyncFuture2.get()+addV;
                        System.out.println(result);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return result;
                });
        long startTime4 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ":asyncFuture3: " + (startTime4 - startTime3));
        return asyncFuture3;
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        CompletableFuture<Integer> future1 = getHttpData(10);
        System.out.println(Thread.currentThread().getName() + ":httpData: " + (System.currentTimeMillis() - startTime));
//        System.out.println(future1.get());
        System.out.println("finish 1");
        long startTime1 = System.currentTimeMillis();
        CompletableFuture<Integer> future2 = getHttpData(9);
        System.out.println(Thread.currentThread().getName() + ":httpData: " + (System.currentTimeMillis() - startTime1));
//        System.out.println(future2.get());
        System.out.println("finish 2");

        CompletableFuture.allOf(future1, future2)
                .thenAcceptAsync((Void) -> {
                    try {
                        System.out.println(future1.get());
                        System.out.println(future2.get());
                        System.out.println("finish 3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("finish all");
        executor.shutdown();
    }

    static class RpcService {
        Integer getRpcRequest() throws Exception {
            System.out.println("TestFuture:" + Thread.currentThread().getName());
            Thread.sleep(3000);
            return 1;
        }
    }

    static class HttpService {
        Integer getHttpRequest() throws Exception {
            System.out.println("TestFuture:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            return 2;
        }
    }
}
