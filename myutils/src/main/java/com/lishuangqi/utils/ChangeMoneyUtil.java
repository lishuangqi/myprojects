package com.lishuangqi.utils;

import java.text.DecimalFormat;

/**
 * @Title: ChangeMoneyUtil.java
 * @Package: com.lishuangqi.util
 * @Description: TODO
 * @author: lishuangqi
 * @date: 2017年5月24日 下午2:44:14
 * @version: V1.0
 */
public class ChangeMoneyUtil {

	public static String changeFenToYuan(int fen){
		DecimalFormat def = new DecimalFormat("0.00");//格式化小数   
        String s = def.format((float)fen/100);
        return s;
	}
	
	public static int changeYuanToFen(double yuan){
		return Integer.valueOf((int) (yuan*100));
	}
	
}
