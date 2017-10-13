/**
 * 
 */
package com.lishuangqi.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * @author lishuangqi
 * 通用map排序类
 */
public class ComparatorMap implements Comparator<Map<String,Object>> {
	private String key;
	private int type;
	private boolean isAsc;
	/**
	 * 
	 * @param key 比较字段
	 * @param type 1int2Long
	 * @param isAsc 是否升序
	 */
	public ComparatorMap(String key,int type,boolean isAsc){
		this.key=key;
		this.type=type;
		this.isAsc=isAsc;
	}
	@Override
	public int compare(Map<String,Object> map1,Map<String,Object> map2) {
		String val1=map1.get(key).toString();
		String val2=map2.get(key).toString();
		if(type==1){
			//整型
			Integer i1=Integer.parseInt(val1);
			Integer i2=Integer.parseInt(val2);
			if(isAsc){
				//升序
				return i1.compareTo(i2);
			}else{
				return i2.compareTo(i1);
			}
		}else{
			Long l1 = Long.parseLong(val1);
			Long l2 = Long.parseLong(val2);
			if(isAsc){
				return l1.compareTo(l2);
			}else{
				return l2.compareTo(l1);
			}
		}
	}
}
