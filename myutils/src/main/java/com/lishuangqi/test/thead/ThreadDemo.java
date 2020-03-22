package com.lishuangqi.test.thead;

public class ThreadDemo {
    public static void main(String[] args){
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.run();
        thread2.run();

        thread1.start();
        thread2.start();
    }
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().toString()+i);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
