package com.lishuangqi.test.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by michael on 2019/4/18.
 */
public class TestFuture extends Thread {
    final static ExecutorService executor = Executors.newFixedThreadPool(2);
    private static RpcService rpcService = new RpcService();
    private static HttpService httpService = new HttpService();

    public TestFuture() {
    }

    @Override
    public void run() {
        try {
            long startTime1 = System.currentTimeMillis();
            Future<Integer> future1 = null;
            Future<Integer> future2 = null;
            try {
                future1 = executor.submit(() -> rpcService.getRpcRequest());
                future2 = executor.submit(() -> httpService.getHttpRequest());
                System.out.println(Thread.currentThread().getName() + ":future: " + (System.currentTimeMillis() - startTime1));
                long startTime2 = System.currentTimeMillis();
                Integer result3 = future1.get(30000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + ":rpcService: " + (System.currentTimeMillis() - startTime2));
                long startTime3 = System.currentTimeMillis();
                Integer result4 = future2.get(30000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + ":httpService: " + (System.currentTimeMillis() - startTime3));
            } catch (Exception e) {
                if (future1 != null) {
                    future1.cancel(true);
                }
                if (future2 != null) {
                    future2.cancel(true);
                }
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Future<Integer> future1 = null;
        Future<Integer> future2 = null;
        try{
            future1 =executor.submit(()->rpcService.getRpcRequest());
            future2 =executor.submit(()->httpService.getHttpRequest());

            long startTime3 = System.currentTimeMillis();
            Integer result3 = future1.get(300, TimeUnit.MILLISECONDS);
            System.out.println("rpcService: " + (System.currentTimeMillis() - startTime3));
            Integer result4 = future2.get(300, TimeUnit.MILLISECONDS);
            System.out.println("httpService: " + (System.currentTimeMillis() - startTime3));
        }catch (Exception e){
            if(future1 != null){
                future1.cancel(true);
            }
            if(future2 != null){
                future2.cancel(true);
            }
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }

    static class RpcService {
        Integer getRpcRequest() throws Exception {
            System.out.println("TestFuture:" + Thread.currentThread().getName());
            Thread.sleep(100);
            return 1;
        }
    }

    static class HttpService {
        Integer getHttpRequest() throws Exception {
            System.out.println("TestFuture:" + Thread.currentThread().getName());
            Thread.sleep(200);
            return 2;
        }
    }
}
