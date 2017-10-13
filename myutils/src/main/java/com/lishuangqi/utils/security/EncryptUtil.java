package com.lishuangqi.utils.security;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class EncryptUtil {
	public static String getLmmcode(String signKey, Map<String, Object> args){
		if(args.isEmpty() || args == null){
			return null;
		}
		args.remove("sign");
		args.remove("contacts");
		args.remove("travellerList");
		Map<String, Object> result = new TreeMap<String, Object>(args);
		StringBuffer code = new StringBuffer();
		for(Entry<String, Object> entry : result.entrySet()){
			code.append(entry.getValue());
		}
		String md5 = Md5.getMD5(code.toString().getBytes());
		md5 += signKey;
		md5 = Md5.getMD5(md5.getBytes());
		return md5;
	}
	
}
