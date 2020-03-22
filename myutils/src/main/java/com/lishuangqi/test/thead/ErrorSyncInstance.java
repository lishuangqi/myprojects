package com.lishuangqi.test.thead;

public class ErrorSyncInstance implements Runnable {
    static int i=0;
    //right way
//    public static synchronized void add(){
//        i++;
//    }
    //wrong way
    public synchronized void add(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0; j<100000; j++){
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ErrorSyncInstance());
        Thread t2 = new Thread(new ErrorSyncInstance());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
