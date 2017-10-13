package com.lishuangqi.utils.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DesUtil for 同程 SameWay
 * @Title: DesUtil.java
 * @Package: com.lishuangqi.util
 * @Description: TODO
 * @author: lishuangqi
 * @date: 2017年5月17日 下午2:51:24
 * @version: V1.0
 */
public class DesUtil {
	
	/** */
	private static final String DES = "DES";
	
	/**
     * Description 根据键值进行加密
     * @param data 
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
	public static String encrypt(String data, String key) throws Exception {
        /*byte[] bt = encrypt(data.getBytes("UTF-8"), key.getBytes("UTF-8"));
        String strs = new BASE64Encoder().encode(bt);
        return strs;*/
        //System.out.println("新方式加密：" + new String(Base64.encodeBase64(bt)));
		byte[] bt = encrypt(data.getBytes("UTF-8"), key.getBytes("UTF-8"));
        String strs = new String(Base64.encodeBase64(bt));
		return strs;
    }
    
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception,
            Exception {
        if (data == null)
            return null;
        /*BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes("UTF-8"));
        return new String(bt, "UTF-8");*/
        byte[] dataByte = Base64.decodeBase64(data.getBytes("UTF-8"));
        byte[] btRs = decrypt(dataByte,key.getBytes("UTF-8"));
        //System.out.println("新方式解密：" + new String(btRs, "UTF-8"));
        return new String(btRs, "UTF-8");
    }
    
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(/*"DES/CBC/PKCS5Padding"*/DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }
    
    public static void main(String[] args) {
		String orderCreateString = "{"
	        +"\"orderSerialId\": \"sz571717851651800001\", "
	        +"\"productNo\": \"S10T6\", "
	        +"\"sceneryNo\":\"\","
	        +"\"payType\": 1, "
	        +"\"tickets\": 2, "
	        +"\"price\": 100, "
	        +"\"contractPrice\":100,"
	        +"\"isEvent\":-1,"
	        +"\"eventId\":\"\","
	        +"\"bookName\": \"景区测试1\", "
	        +"\"bookMobile\": \"10086\", "
	        +"\"idCard\": \"322222222222222222\", "
	        +"\"travelDate\": \"2017-06-10\", "
	        +" \"visitPerson\": ["
	        +"{"
	        +"\"name\": \"景区测试1\", "
	        +"\"mobile\": \"10086\", "
	        +"\"idCard\": \"322222222222222222\""
	        +"}, "
	        +"{"
	        +"\"name\": \"景区测试2\", "
	        +"\"mobile\": \"10087\", "
	        +"\"idCard\": \"322222222222222221\""
	        +"}"
	        +"]"
	        +"}";
		String orderRefundString = "{"
			+"\"orderSerialId\": \"sz571717851651800001\", "
			+"\"partnerOrderId\": \"XS00620170605000007\", "
			+"\"reason\": \"行程取消\", "
			+"\"tickets\": 2"
			+"}";
		String key = "TFD9BEOK";
		String enStr = "";
		try {
			enStr = encrypt(orderRefundString, key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.println("old加密："+enStr);
		String deStr = "";
		try {
			deStr = decrypt(enStr, key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("old解密："+deStr);
		/*try {
			System.out.println(decrypt("VYSQuFzkcr7qeKqZNu5LZdCH9P98vOGIEHMFGIMA", key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
