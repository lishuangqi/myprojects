package com.lishuangqi.test.tree;

import java.util.BitSet;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by michael on 2019/4/17.
 */
public class BitSetTest implements Runnable{

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
        System.out.println(bitSet.toString());

        TreeMap<Integer,Object> treeMap = new TreeMap<Integer,Object>();
        long start1 = System.currentTimeMillis();
        for(int i =1; i<=100; i++) {
            treeMap.put(new Random().nextInt(100), i);
        }
        long start2 = System.currentTimeMillis();
        System.out.println(treeMap.get(10));
        System.out.println(treeMap.headMap(10));
        long start3 = System.currentTimeMillis();
        System.out.println(start2-start1);
        System.out.println(start3-start2);
    }
}
