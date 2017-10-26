package com.lishuangqi.test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by michael on 2017/10/26.
 */
public class TestString {
    public static void main(String[] args){

        System.out.println("请输入一行字符：");

//        Scanner scan = new Scanner(System.in);
//
//        String str = scan.nextLine();
//
//        scan.close();
        String str = "dfa ad afd  32234 .()";
        countChar(str);
        count(str);

    }

    //统计输入的字符

    private static void count(String str){

        List<String> list = new ArrayList<String>();

        char[] array_Char = str.toCharArray();

        for(char c:array_Char) {

            list.add(String.valueOf(c));//将字符作为字符串添加到list表中
        }

        Collections.sort(list);//排序

        for(String s:list){

            int begin = list.indexOf(s);

            int end = list.lastIndexOf(s);

            //索引结束统计字符数

            if(list.get(end)==s) {

                System.out.println("字符‘" + s + "’有" + (end - begin + 1) + "个");
            }

        }

    }

    private static void countChar(String str){
        char[] array_Char = str.toCharArray();
        int zimu =0;
        int blank = 0;
        int num = 0;
        int other = 0;
        for(char tmp: array_Char){
//            System.out.println((int) tmp);
            int tmp1 = tmp;
            if((tmp1>=65 && tmp1 <=90) ||(tmp1>=97 && tmp1 <=122)){
                zimu++;
            }else if(tmp1>=48 && tmp1 <=57){
                num++;
            }else if(tmp1==32){
                blank++;
            }else{
                other++;
            }
        }
        System.out.println("空格：" + blank);
        System.out.println("数字：" + num);
        System.out.println("字母：" + zimu);
        System.out.println("other：" + other);
    }
}
