package com.lishuangqi.utils.security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DESEncrypt
{
  private static byte[] keybytes = { 99, 104, 101, 110, 103, 100, 117, 115, 
    105, 102, 97, 110, 103 };
  
  public static String encrypt(String value)
  {
    String s = null;
    try
    {
      Cipher cipher = initCipher(1);
      
      byte[] outBytes = cipher.doFinal(value.getBytes());
      
      s = String.valueOf(Hex.encodeHex(outBytes));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  public static String decrypt(String value)
  {
    String s = null;
    try
    {
      Cipher cipher = initCipher(2);
      
      s = new String(cipher.doFinal(Hex.decodeHex(value.toCharArray())));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  private static Cipher initCipher(int mode)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
  {
    Cipher cipher = Cipher.getInstance("DES");
    
    Key key = new SecretKeySpec(keybytes, "DES");
    
    cipher.init(mode, key);
    return cipher;
  }
}
