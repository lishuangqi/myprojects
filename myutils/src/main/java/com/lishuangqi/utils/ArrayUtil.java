package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */

import org.apache.commons.lang.ArrayUtils;

import java.util.LinkedList;


public class ArrayUtil extends ArrayUtils {
    public ArrayUtil() {
    }

    public static boolean contains(String[] arr, String s) {
        if(arr != null) {
            for(int i = 0; i < arr.length; ++i) {
                if(s.equals(arr[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int getCount(int[] c) {
        int count = 0;
        if(c != null) {
            for(int i = 0; i < c.length; ++i) {
                count += c[i];
            }
        }

        return count;
    }

    public static String[] removeElemetByEqual(String[] sourceArray, String removeElement) {
        if(sourceArray != null && removeElement != null) {
            LinkedList list = new LinkedList();

            for(int newStrArray = 0; newStrArray < sourceArray.length; ++newStrArray) {
                if(!sourceArray[newStrArray].contentEquals(removeElement)) {
                    list.add(sourceArray[newStrArray]);
                }
            }

            String[] var4 = new String[0];
            return (String[])list.toArray(var4);
        } else {
            return null;
        }
    }

    public static String[] removeElemetByContain(String[] sourceArray, String removeElement) {
        if(sourceArray != null && removeElement != null) {
            System.out.println("removeElement   " + removeElement);
            LinkedList list = new LinkedList();

            for(int newStrArray = 0; newStrArray < sourceArray.length; ++newStrArray) {
                if(!sourceArray[newStrArray].contains(removeElement)) {
                    list.add(sourceArray[newStrArray]);
                }
            }

            String[] var4 = new String[0];
            return (String[])list.toArray(var4);
        } else {
            return null;
        }
    }
}

