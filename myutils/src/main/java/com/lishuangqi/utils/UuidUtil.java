package com.lishuangqi.utils;

import java.util.UUID;

/**
 * UUID工具类 获取UUID
 * <p>description：</p>
 * @name：UuidUtil
 * @author：lishuangqi
 * @date：2017年3月14日下午8:23:07
 */
public class UuidUtil {
	/**
	 * <p>description：静态方法 返回去掉“—”的uuid</p>
	 * @author：Administrator
	 * @date：2017年3月14日下午8:23:28
	 */
	public static String uuidStr(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		return str.replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(uuidStr());
	}
}
