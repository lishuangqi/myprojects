package com.lishuangqi.utils.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tools
{
  private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6",
    "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  public static String md5Str(String data)
  {
      byte[] dat = new byte[0];
      try {
          dat = data.getBytes("UTF-8");
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
      return md5Str(dat, 0, dat.length);
  }

  public static String md5Str(byte[] data, int offset, int length)
  {
    try
    {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(data, offset, length);
      return byteArrayToHexString(md5.digest());
    }
    catch (NoSuchAlgorithmException ex)
    {
      ex.printStackTrace();
    }
    return null;
  }

  public static String byteArrayToHexString(byte[] b)
  {
    String result = "";
    for (int i = 0; i < b.length; i++) {
      result = result + byteToHexString(b[i]);
    }
    return result;
  }

  public static String byteToHexString(byte b)
  {
    int n = b;
    if (n < 0) {
      n += 256;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  public static void main(String[] args) {
    System.out.println(md5Str("ASIAINFOdjy_sys~api_tr-bd#@sc·181!1506481080362"));
  }
}
