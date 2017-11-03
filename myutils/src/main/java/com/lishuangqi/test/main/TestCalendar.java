package com.lishuangqi.test.main;

import java.util.*;

/**
 * Created by michael on 2017/10/26.
 */
public class TestCalendar {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH)+1);

        System.out.println(cal.getTimeInMillis());
        Date now = new Date();
        System.out.println(now.getTime());
    }


}
