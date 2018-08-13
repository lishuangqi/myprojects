package com.shuangqi.hbaseTest;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Title: hbaseTest
 * Description: HBase 相关测试
 * Version:1.0.0
 *
 * @author pancm
 * @date 2017年11月23日
 */
public class HbaseTest {
    public static void main(String[] args) {
//		org.apache.hadoop.hbase.client.ConnectionManager
		test();
//        String tableName1 = "t_student1", tableName2 = "t_student_info1";
//        String[] columnFamily1 = {"st1", "st2"};
//        String[] columnFamily2 = {"stf1", "stf2"};
//        long startTime = System.currentTimeMillis();
////        insterTest(tableName1, columnFamily1[0], "name", "lisi", 1000000L);
////        insterTest(tableName1, columnFamily1[1], "age", "", 1000000L);
//        insterTest(tableName2, columnFamily2[0], "name", "lisi", 1000000L);
//        insterTest(tableName2, columnFamily2[1], "sex", "man", 1000000L);
//        long endTime = System.currentTimeMillis();
//        System.out.println("total插入数据共使用时间为：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 一些测试
     */
    private static void test() {
        String tableName1 = "user_location", tableName2 = "t_student_info1";
        String[] columnFamily1 = {"sti", "stl", "std"};
        String[] columnFamily2 = {"stf1", "stf2"};
        HBaseUtil.creatTable(tableName1, columnFamily1);
//        HBaseUtil.creatTable(tableName2, columnFamily2);

//        HBaseUtil.insert(tableName1, "1001", columnFamily1[0], "userid", "zhangsan");
//        HBaseUtil.insert(tableName1, "1002", columnFamily1[0], "name", "lisi");
//        HBaseUtil.insert(tableName1, "1001", columnFamily1[1], "age", "18");
//        HBaseUtil.insert(tableName1, "1002", columnFamily1[1], "age", "20");
//
//        HBaseUtil.insert(tableName2, "1001", columnFamily2[0], "phone", "123456");
//        HBaseUtil.insert(tableName2, "1002", columnFamily2[0], "phone", "234567");
//        HBaseUtil.insert(tableName2, "1001", columnFamily2[1], "mail", "123@163.com");
//        HBaseUtil.insert(tableName2, "1002", columnFamily2[1], "mail", "234@163.com");
//        //查询该表所有数据
//        HBaseUtil.select(tableName1);
//        //根据表名和行健查询
//        HBaseUtil.select(tableName1, "1001");
//        //根据表名、行健和列族查询
//        HBaseUtil.select(tableName2, "1002", columnFamily2[0]);
//        //根据表名、行健、列族、和列查询
//        HBaseUtil.select(tableName2, "1002", columnFamily2[1], "mail");
//
//        //根据表名和行健查询
//        HBaseUtil.select(tableName1, "1002");
//        //删除数据
//        HBaseUtil.delete(tableName1, "1002", columnFamily1[0]);
//        //根据表名和行健查询
//        HBaseUtil.select(tableName1, "1002");

    }


    /**
     * 批量测试方法
     *
     * @param tableName 表名
     * @param family    列族
     * @param qualifier 列
     * @param value     值
     * @param k         次数
     */
    public static void insterTest(String tableName, String family, String qualifier, String value, long k) {
        List<JSONObject> list = new ArrayList<>();
        for (long i = 1; i <= k; i++) {
            JSONObject json = new JSONObject();
            //行健
            json.put("rowKey", i);
            //列族
            json.put("family", family);
            //列
            json.put("qualifier", qualifier);
            //如果是t_student1 姓名则加上编号
            if ("t_student1".equals(tableName) || "t_student_info1".equals(tableName)) {
                //如果为空，则是年龄
                if ("".equals(value)) {
                    json.put("value", i % 100);
                } else {
                    json.put("value", value + i);
                }
            }
            //如果为空，则是年龄
            else if ("".equals(value)) {
                json.put("value", i);
            }
            //否则就是性别
            else {
                json.put("value", value);
            }

            list.add(json);
            System.out.println("json:" + json);
        }
        long startTime = System.currentTimeMillis();
        HBaseUtil.insertBatch(tableName, list);
        long endTime = System.currentTimeMillis();
        System.out.println("hbaes插入数据共使用时间为：" + (endTime - startTime) + "毫秒");
    }

    public static void main1(String[] args) {
        String jsonStr ="{'id':0,'name':'agnui','age':23, 'like':'吃水果'}";
        JSONObject tmpJson = JSONObject.parseObject(jsonStr);
        Iterator<String> iterator = tmpJson.keySet().iterator();
        List<JSONObject> list = new ArrayList<>();

        String uuid = UUID.randomUUID().toString();
        while (iterator.hasNext()){
            JSONObject json = new JSONObject();
            String key = iterator.next();
            if("id".equals(key)){
                continue;
            }
            //行健
            json.put("rowKey", tmpJson.get("id")==null? uuid :tmpJson.get("id"));
            //列族
            json.put("family", key);
            //列
            json.put("qualifier", key);
            //值
            json.put("value", tmpJson.get(key));

            list.add(json);
            System.out.println("json:" + json);

        }
        System.out.println(list);
    }

}
