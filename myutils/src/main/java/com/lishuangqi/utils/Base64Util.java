package com.lishuangqi.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @Title: Base64Util.java
 * @Package: com.lishuangqi.util
 * @Description: TODO
 * @author: lishuangqi
 * @date: 2017年5月17日 下午3:22:28
 * @version: V1.0
 */
public class Base64Util {

	// 加密  
    public static String getBase64(String str) {  
        /*byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }*/ 
    	String s = null;
        try {
			s = new String(Base64.encodeBase64(str.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return s;  
    }  
  
    // 解密  
    public static String getFromBase64(String s) {  
        /*byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }*/  
    	String result = null; 
    	try {
			result = new String(Base64.decodeBase64(s.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
         
        return result; 
    } 
	
    public static void main(String[] args) throws UnsupportedEncodingException {
    	String str = "dddddddddddd张三";
		System.out.println(getBase64(str));
		System.out.println(new String(Base64.encodeBase64(str.getBytes("UTF-8"))));
		System.out.println(getFromBase64(getBase64(str)));
		System.out.println(new String(Base64.decodeBase64(getBase64(str).getBytes("UTF-8"))));
	}
}
