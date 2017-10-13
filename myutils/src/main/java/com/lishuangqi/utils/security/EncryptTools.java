package com.lishuangqi.utils.security;

public class EncryptTools
{
  private static String CHARSET = "UTF-8";
  
  public static String deCode(String str)
  {
    byte[] in = (byte[])null;
    int output_length = 0;
    byte[] out_src = (byte[])null;
    byte[] tmp_2 = (byte[])null;
    if ((str == null) || ("".equals(str))) {
      return "";
    }
    try
    {
      int tmp_str1 = 0;
      int tmp_str2 = 0;
      int input_index = 0;
      int output_index = 0;
      
      int str_length = str.getBytes(CHARSET).length;
      
      in = new byte[str_length * 2 > 512 ? str.length() * 2 : 'Ȁ'];
      
      System.arraycopy(str.getBytes(CHARSET), 0, in, 0, str_length);
      while (input_index < str.length())
      {
        byte check = in[(input_index + 4)];
        int check_i = 2;
        for (int i = 0; i < 4; i++)
        {
          int x = 0;
          x = check;
          x &= check_i;
          if (x == check_i) {
            in[(i + input_index)] = 0;
          }
          check_i *= 2;
        }
        tmp_str1 = byteToInt2(in, input_index);
        
        int mod_value = 0;
        int x = 1;
        tmp_str2 = 0;
        while (tmp_str1 > 0)
        {
          mod_value = tmp_str1 % 16;
          tmp_str1 /= 16;
          tmp_str2 += x * mod_value;
          x *= 8;
        }
        tmp_2 = intToBytes2(tmp_str2);
        in[output_index] = tmp_2[0];
        in[(output_index + 1)] = tmp_2[1];
        in[(output_index + 2)] = tmp_2[2];
        tmp_2 = (byte[])null;
        input_index += 5;
        output_index += 3;
      }
      output_length = output_index;
      if (tmp_str2 <= 65535) {
        if (tmp_str2 <= 255) {
          output_length -= 2;
        } else {
          output_length--;
        }
      }
      out_src = new byte[output_length];
      System.arraycopy(in, 0, out_src, 0, output_length);
      return new String(out_src, CHARSET);
    }
    catch (Exception e)
    {
      return "";
    }
    finally
    {
      tmp_2 = (byte[])null;
      in = (byte[])null;
    }
  }
  
  private static String enCode(String str)
  {
    byte[] in = (byte[])null;
    byte[] out = (byte[])null;
    byte[] out_src = (byte[])null;
    int output_length = 0;
    if ((str == null) || ("".equals(str))) {
      return "";
    }
    try
    {
      int tmp_str1 = 0;
      int tmp_str2 = 0;
      int input_index = 0;
      int output_index = 0;
      in = new byte[str.length() > 3 ? str.length() * 10 : 'È'];
      out = new byte[str.length() > 3 ? str.length() * 10 : 'È'];
      while (input_index < str.length())
      {
        if (str.length() - input_index < 3) {
          System.arraycopy(str.getBytes(CHARSET), 0, in, 0, str
            .getBytes(CHARSET).length);
        } else {
          System.arraycopy(str.getBytes(CHARSET), 0, in, 0, str
            .getBytes(CHARSET).length);
        }
        tmp_str1 = byteToInt2(in, input_index);
        
        int mod_value = 0;
        int x = 1;
        tmp_str2 = 0;
        while (tmp_str1 > 0)
        {
          mod_value = tmp_str1 % 8;
          tmp_str1 /= 8;
          tmp_str2 += x * mod_value;
          x *= 16;
        }
        byte[] tmp_2 = intToBytes2(tmp_str2);
        out[output_index] = tmp_2[0];
        out[(output_index + 1)] = tmp_2[1];
        out[(output_index + 2)] = tmp_2[2];
        out[(output_index + 3)] = tmp_2[3];
        
        byte check = 1;
        int check_i = 2;
        for (int i = 0; i < 4; i++)
        {
          if (out[(output_index + i)] == 0)
          {
            out[(output_index + i)] = 32;
            check = (byte)(check | check_i);
          }
          check_i *= 2;
        }
        out[(output_index + 4)] = check;
        
        input_index += 3;
        output_index += 5;
      }
      output_length = output_index;
      
      out_src = new byte[output_length];
      System.arraycopy(out, 0, out_src, 0, output_length);
      return new String(out_src, CHARSET);
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static byte[] intToBytes2(int n)
  {
    byte[] b = new byte[4];
    for (int i = 0; i < 4; i++) {
      b[(3 - i)] = ((byte)(n >> 24 - i * 8));
    }
    return b;
  }
  
  private static int byteToInt2(byte[] b, int offset)
  {
    int ch4 = b[offset] & 0xFF;
    int ch3 = b[(offset + 1)] & 0xFF;
    int ch2 = b[(offset + 2)] & 0xFF;
    int ch1 = b[(offset + 3)] & 0xFF;
    if ((ch1 | ch2 | ch3 | ch4) < 0) {
      return -1;
    }
    return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
  }
}
