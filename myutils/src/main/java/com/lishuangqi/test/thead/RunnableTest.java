package com.lishuangqi.test.thead;

import java.util.BitSet;

/**
 * Created by michael on 2019/4/17.
 */
public class RunnableTest implements Runnable{

    @Override
    public void run() {

    }
    public static void main(String[] args) {
//        RunnableTest tt= new RunnableTest();
//        tt.run();
//        Thread t = new Thread(new RunnableTest());
//        t.start();

        int [] array = new int [] {1,2,3,22,0,3,9,4,5,6,6};
        BitSet bitSet  = new BitSet();
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            if(bitSet.get(array[i])){
                System.out.println(array[i]);
            }else{

                bitSet.set(array[i], true);
            }
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(3));
    }
}
