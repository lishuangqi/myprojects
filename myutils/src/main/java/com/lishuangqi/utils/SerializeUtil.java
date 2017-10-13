package com.lishuangqi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtil {
	
       private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);
       
	   public static void close(Closeable closeable) {  
	        if (closeable != null) {  
	            try {  
	                closeable.close();  
	            } catch (Exception e) {  
	            	logger.info("Unable to close %s", closeable, e); 
	            }  
	        }  
	    } 
	   
	   public static byte[] serializeS(Serializable s) {  
           if (s == null) {  
               throw new NullPointerException("Can't serialize null");  
           }  
           byte[] rv=null;  
           ByteArrayOutputStream bos = null;  
           ObjectOutputStream os = null;  
           try {  
               bos = new ByteArrayOutputStream();  
               os = new ObjectOutputStream(bos);  
               os.writeObject(s);  
               os.writeObject(null);  
               os.close();  
               bos.close();  
               rv = bos.toByteArray();  
           } catch (IOException e) {  
               throw new IllegalArgumentException("Non-serializable object", e);  
           } finally {  
               close(os);  
               close(bos);  
           }  
           return rv;  
       }  
	    
	   public static Serializable deserializeS(byte[] in) {  
           Serializable s = null;  
           ByteArrayInputStream bis = null;  
           ObjectInputStream is = null;  
           try {  
                if(in != null) {  
                   bis=new ByteArrayInputStream(in);  
                   is=new ObjectInputStream(bis);  
                   s = (Serializable) is.readObject();
                   is.close();  
                   bis.close();
                 }  
           } catch (IOException e) {  
               logger.warn("Caught IOException decoding %d bytes of data",  
                       in == null ? 0 : in.length, e);  
           } catch (ClassNotFoundException e) {  
               logger.warn("Caught CNFE decoding %d bytes of data",  
                       in == null ? 0 : in.length, e);  
           } finally {  
                close(is);  
                close(bis);  
           }  
           return s;  
       }  
	  
       public static byte[] serialize(List<? extends Serializable> value) {  
            if (value == null) {  
                throw new NullPointerException("Can't serialize null");  
            }  
            byte[] rv=null;  
            ByteArrayOutputStream bos = null;  
            ObjectOutputStream os = null;  
            try {  
                bos = new ByteArrayOutputStream();  
                os = new ObjectOutputStream(bos);  
                for(Serializable s : value){  
                    os.writeObject(s);  
                }  
                os.writeObject(null);  
                os.close();  
                bos.close();  
                rv = bos.toByteArray();  
            } catch (IOException e) {  
                throw new IllegalArgumentException("Non-serializable object", e);  
            } finally {  
                close(os);  
                close(bos);  
            }  
            return rv;  
       }  
  
       public static List<? extends Serializable> deserialize(byte[] in) {  
            List<Serializable> list = new ArrayList<Serializable>();  
            ByteArrayInputStream bis = null;  
            ObjectInputStream is = null;  
            try {  
                if(in != null) {  
                    bis=new ByteArrayInputStream(in);  
                    is=new ObjectInputStream(bis);  
                    while (true) {  
                        Serializable s = (Serializable) is.readObject();  
                        if(s == null){  
                            break;  
                        }else{  
                            list.add(s);  
                        }  
                    }  
                    is.close();  
                    bis.close();  
                }  
            } catch (IOException e) {  
                logger.warn("Caught IOException decoding %d bytes of data",  
                        in == null ? 0 : in.length, e);  
            } catch (ClassNotFoundException e) {  
                logger.warn("Caught CNFE decoding %d bytes of data",  
                        in == null ? 0 : in.length, e);  
            } finally {  
                 close(is);  
                 close(bis);  
            }  
            return list;  
      }  
}
