package com.shuangqi.hbaseTest.test2;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

/**
 * Created by michael on 2018/7/16.
 */
public interface HBaseDemoInterface {
    //创建表
    void createTable(String tableName, String[] family) throws Exception;

    //创建表
    void createTable(String tableName, HTableDescriptor htds) throws Exception;

    void descTable(String tableName) throws Exception;

    //// 这种方式是替换该表tableName的所有列簇
    void modifyTable(String tableName) throws Exception;

    void getAllTables() throws Exception;

    //更新数据  插入数据
    void putData(String tableName, String rowKey, String familyName, String columnName, String value)
            throws Exception;

    //为表添加数据
    void addData(String tableName, String rowKey, String[] column1, String[] value1, String[] column2,
                 String[] value2) throws Exception;

    //根据rowkey 查询
    Result getResult(String tableName, String rowKey) throws Exception;

    //查询指定的某列
    Result getResult(String tableName, String rowKey, String familyName, String columnName) throws Exception;

    //遍历查询表
    ResultScanner getResultScann(String tableName) throws Exception;

    ResultScanner getResultScann(String tableName, Scan scan) throws Exception;

    //查询表中的某一列
    Result getResultByColumn(String tableName, String rowKey, String familyName, String columnName)
            throws Exception;

    //查询某列数据的某个版本
    Result getResultByVersion(String tableName, String rowKey, String familyName, String columnName,
                              int versions) throws Exception;

    //删除指定某列
    void deleteColumn(String tableName, String rowKey, String falilyName, String columnName) throws Exception;

    //删除指定的某个rowkey
    void deleteColumn(String tableName, String rowKey) throws Exception;

    //让该表失效
    void disableTable(String tableName) throws Exception;

    void dropTable(String tableName) throws Exception;
}
