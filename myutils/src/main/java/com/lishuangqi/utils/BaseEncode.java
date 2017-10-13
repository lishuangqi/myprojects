package com.lishuangqi.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class BaseEncode {
   public static String getBase64(String str) throws UnsupportedEncodingException 
   {
	   byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));  
//       System.out.println("RESULT: " + new String(encodeBase64));
       return new String(encodeBase64);
   }
   public static void main(String[] args) {
//	try {
//		getBase64("ddddddddddddddd");
//	} catch (UnsupportedEncodingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
}
