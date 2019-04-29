package com.lishuangqi.test.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by michael on 2019/4/10.
 */
public class SemaphoreTest extends Thread{
    private String name;

    private Semaphore sh;



    public SemaphoreTest(String name,Semaphore sh){

        this.name = name;

        this.sh = sh;

    }



    public void run(){

        if(sh.availablePermits()>0){

            System.out.println("有笔");

        }else{

            System.out.println("笔没了，等等");

        }

        try {

            sh.acquire();//信号量减1

            System.out.println(this.name+"号在用笔");

            Thread.sleep((long) (Math.random()*1000));

            sh.release();

            System.out.println(this.name+"号用完了");

        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }



    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();

        Semaphore sh = new Semaphore(3);

        for(int i=0;i<20;i++){

            es.submit(new SemaphoreTest(i+"",sh));

        }

        es.shutdown();

    }



}
