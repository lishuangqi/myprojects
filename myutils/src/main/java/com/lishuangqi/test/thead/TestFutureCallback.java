package com.lishuangqi.test.thead;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Created by michael on 2019/4/18.
 */
public class TestFutureCallback extends Thread {
    private static CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();

    @Override
    public void run() {

    }

    public static CompletableFuture<HttpResponse> getHttpData(String url) throws IOException {
        CompletableFuture asyncFuture = new CompletableFuture();

        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(new HttpGet(url));
        BasicAsyncResponseConsumer comsumer = new BasicAsyncResponseConsumer();
        FutureCallback callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                asyncFuture.complete(response);
            }

            @Override
            public void failed(Exception e) {
                asyncFuture.completeExceptionally(e);
            }

            @Override
            public void cancelled() {
                asyncFuture.cancel(true);
            }
        };
        httpAsyncClient.execute(producer, comsumer, callback);
        return asyncFuture;
    }

    public static void main(String[] args) throws Exception {
//        httpAsyncClient.start();
        CompletableFuture<HttpResponse> future1 = TestFutureCallback.getHttpData("http://www.jd.com");
        CompletableFuture<HttpResponse> future2 = TestFutureCallback.getHttpData("http://www.jd.com");


//        future1.thenAcceptBothAsync(future2, (future1Result,future2Result)->{
//            System.out.println(future1Result);
//            System.out.println(future2Result);
//        });
//        HttpResponse result = future1.get();
//        System.out.println(result.toString());
//        System.out.println(result.getEntity().toString());

    }

}
