package com.lishuangqi.test.tree;

import java.util.Arrays;

/**
 * Created by michael on 2019/4/29.
 */
public class BinarySearchDemo {
    /**
     * 二分查找key值对应的下标
     * @param source 输入的源数组 ，请保证为一个有序数组
     * @param key 需要查找的值
     * @return 正数为查找到的坐标，-1表示没有查到
     */
    public static int binarySearch(int[] source, int key) {
        int low = 0;
        int high = source.length - 1;
        while (low <= high) {
            //使用位移运算法高效地获取折中下标，这里不考虑符号，所以使用>>>
            //>>> 表示无符号右移
            //>>  表示右移，如果该数为正，则高位补0，若为负数，则高位补1
            int mid = ( low + high ) >>> 1;
            System.out.println("mid:"+mid);
            int midVal = source[mid];
            if (midVal < key ) {
                low = mid + 1;
            } else if ( midVal > key ) {
                high = mid - 1;
            }  else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = new int[]{12,213,232,343,123,-1,123,232424,1253,56,456,234,-2342};
        //保证数组为有序数组
        Arrays.sort(source);
        //打印排序后的数组元素
        System.out.print("Sorted Source : ");
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
        System.out.println(binarySearch(source, 56));
    }
}
