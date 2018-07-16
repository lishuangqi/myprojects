package com.shuangqi.hiveTest;

import java.sql.SQLException;

/**
 * 
* Title: hiveTest
* Description: hive的JDBC测试 
* 参考 官方文档
* https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-BeelineExample 
* Version:1.0.0  
* @author pancm
* @date 2017年12月1日
 */
public class HiveTest {
	
  
    
    public static void main(String[] args) throws SQLException {
    	  String sql1 = "select * from t_student1 where id=1001";
    	  String sql2= "select * from t_student_info1 where id=1001";
    	  String sql3="select * from t_student1 t, t_student_info1 ti where t.id=ti.id and t.id=1001";
    	  long starTime=System.currentTimeMillis(); 
    	  HiveUtil.find(sql1);
    	  HiveUtil.find(sql2);
    	  HiveUtil.find(sql3);
    	  long endTime=System.currentTimeMillis(); 
    	  System.out.println("查询共使用时间为:"+(endTime-starTime)+"毫秒");
	}
    
  
  
 
     
}
