package com.lishuangqi.test.tree;

//实现LRU
//使用LinkedHashMap实现
//LinkedHashMap底层就是用的【HashMap 加 双链表】实现的，而且本身已经实现了按照访问顺序的存储。
//此外，LinkedHashMap中本身就实现了一个方法removeEldestEntry用于判断是否需要移除最不常读取的数，
//方法默认是直接返回false，不会移除元素，所以需要重写该方法,即当缓存满后就移除最不常用的数。

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> {
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRU(int cacheSize)
    {
        this.cacheSize = cacheSize;
        map = new LinkedHashMap<K,V>(16,0.75F,true){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if(cacheSize + 1 == map.size()){
                    return true;
                }else{
                    return false;
                }
            }
        };  //end map
    }

    public synchronized V get(K key) {
        return map.get(key);
    }
    public synchronized void put(K key,V value) {
        map.put(key, value);
    }
    public synchronized void clear() {
        map.clear();
    }
    public synchronized int usedSize() {
        return map.size();
    }
    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU<String, Integer> LRUMap = new LRU<>(4);
        LRUMap.put("key1", 1);
        LRUMap.put("key2", 2);
        LRUMap.put("key3", 3);
        LRUMap.print();
        System.out.println();
        LRUMap.get("key1");
        LRUMap.put("key4", 4);
        LRUMap.print();
        LRUMap.get("key1");
        LRUMap.print();
    }
}