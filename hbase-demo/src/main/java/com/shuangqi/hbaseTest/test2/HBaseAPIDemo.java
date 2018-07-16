package com.shuangqi.hbaseTest.test2;

/**
 * Created by michael on 2018/7/16.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBaseAPIDemo implements HBaseDemoInterface {

    private static final String ROWKEY = "p001";
    private static final String ROWKEY2 = "p002";
    private static final String FAMILY1 = "cf1";
    private static final String FAMILY2 = "cf2";
    private static final String KEY = "name";
    private static final String VALUE = "huangbo";

    private static final String TABLE_NAME = "person";
    private static final String[] COLUMN_FAMILY = new String[] { FAMILY1, FAMILY2 };

    static Configuration conf = null;
    static HBaseAdmin admin = null;
    static HTable table = null;

    static {
        try {
            conf = HBaseConfiguration.create();
            conf.set("hbase.zookeeper.quorum", "10.1.251.52:2181");
            admin = new HBaseAdmin(conf);
            table = new HTable(conf, TABLE_NAME);

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("报错");
        }
    }

    public static void main(String[] args) throws Exception {
        HBaseAPIDemo hbase = new HBaseAPIDemo();

        // 测试创建表
        hbase.createTable(TABLE_NAME, COLUMN_FAMILY);

        // 测试创建表
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
        for (int i = 0; i < COLUMN_FAMILY.length; i++) {
            HColumnDescriptor cf1 = new HColumnDescriptor(COLUMN_FAMILY[i]);
            htd.addFamily(cf1);
        }
        hbase.createTable(TABLE_NAME, htd);

        // 查看表属性
        hbase.descTable(TABLE_NAME);

        // 查询所有的表
        hbase.getAllTables();

        // 测试修改表
        hbase.modifyTable(TABLE_NAME);

        // 插入数据
        hbase.putData(TABLE_NAME, ROWKEY, FAMILY1, KEY, VALUE);

        // 测试插入一堆数据
        String[] column1 = new String[] { "name1", "age", "province" };
        String[] value1 = new String[] { "huangbo", "33", "xinjiang" };
        String[] column2 = new String[] { "gender" };
        String[] value2 = new String[] { "male" };
        hbase.addData(TABLE_NAME, ROWKEY2, column1, value1, column2, value2);

        // 通过rowkey查询数据
        Result result = hbase.getResult(TABLE_NAME, ROWKEY2);
        System.out.println(result.toString());
        List<KeyValue> list = result.list();
        for (int i = 0; i < list.size(); i++) {
            KeyValue kv = list.get(i);
            printKeyValye(kv);
        }

        // 通过rowkey, family, province查询数据
        Result result1 = hbase.getResult(TABLE_NAME, ROWKEY2, FAMILY1, "province");
        List<Cell> cells = result1.listCells();
        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            printCell(cell);
        }

        // 扫描全表数据
        ResultScanner resultScann = hbase.getResultScann(TABLE_NAME);
        printResultScanner(resultScann);

        /*Iterator<Result> iterator = resultScann.iterator();
        while(iterator.hasNext()){
            Result next = iterator.next();
        }*/

        // 通过scan扫描全表数据，scan中可以加入一些过滤条件
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes("user"));
        scan.setStopRow(Bytes.toBytes("zk002"));
        scan.setTimeRange(1488252774189l, 1488252774191l);
        ResultScanner resultScann1 = hbase.getResultScann(TABLE_NAME, scan);
        printResultScanner(resultScann1);

        // 两种方式查询最大版本数的hbase数据
        Result resultByVersion = hbase.getResultByVersion(TABLE_NAME, ROWKEY, FAMILY1, "name", 3);
        printResult(resultByVersion);
        System.out.println("-------------------");
        ResultScanner rs = hbase.getResultByVersion(ROWKEY, FAMILY1, "name", 3);
        printResultScanner(rs);

        // 删除表
        hbase.dropTable(TABLE_NAME);
    }

    public static void printResultScanner(ResultScanner resultScann) {
        for (Result result : resultScann) {
            printResult(result);
        }
    }

    public static void printResult(Result result) {
        List<Cell> cells = result.listCells();
        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            printCell(cell);
        }
    }

    public static void printCell(Cell cell) {
        System.out.println(Bytes.toString(cell.getRow()) + "\t" + Bytes.toString(cell.getFamily()) + "\t" + Bytes.toString(cell.getQualifier()) + "\t" + Bytes.toString(cell.getValue()) + "\t" + cell.getTimestamp());
    }

    public static void printKeyValye(KeyValue kv) {
        System.out.println(Bytes.toString(kv.getRow()) + "\t" + Bytes.toString(kv.getFamily()) + "\t" + Bytes.toString(kv.getQualifier()) + "\t" + Bytes.toString(kv.getValue()) + "\t" + kv.getTimestamp());
    }

    // create 'tablename','cf1','cf2'
    @Override
    public void createTable(String tableName, String[] family) throws Exception {
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        for (int i = 0; i < family.length; i++) {
            HColumnDescriptor cf1 = new HColumnDescriptor(family[i]);
            htd.addFamily(cf1);
        }
        admin.createTable(htd);
        boolean tableExists = admin.tableExists(Bytes.toBytes(tableName));
        System.out.println(tableExists ? "创建表成功" : "创建失败");
    }

    @Override
    public void createTable(String tableName, HTableDescriptor htd) throws Exception {
        admin.createTable(htd);
        boolean tableExists = admin.tableExists(Bytes.toBytes(tableName));
        System.out.println(tableExists ? "创建表成功" : "创建失败");
    }

    // desc 'person'
    @Override
    public void descTable(String tableName) throws Exception {
        HTableDescriptor tableDescriptor = table.getTableDescriptor();
        HColumnDescriptor[] columnFamilies = tableDescriptor.getColumnFamilies();
        for (HColumnDescriptor hcd : columnFamilies) {
            // System.out.println(hcd.toString()+"\t");
            System.out.println(Bytes.toString(hcd.getName()));
        }
    }

    @Override
    public void modifyTable(String tableName) throws Exception {
        // 这种方式是替换该表tableName的所有列簇
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        htd.addFamily(new HColumnDescriptor(Bytes.toBytes("cf3")));
        htd.addFamily(new HColumnDescriptor(Bytes.toBytes("cf2")));
        admin.modifyTable(tableName, htd);

        // 删除该表tableName当中的特定的列簇
        // admin.deleteColumn(tableName, "cf3");

        System.out.println("修改成功");
    }

    // list
    @Override
    public void getAllTables() throws Exception {
        TableName[] listTableNames = admin.listTableNames();
        for (TableName tn : listTableNames) {
            System.out.println(tn.toString());
        }
    }

    // put 'tablename','rowkey','familyname:key','value'
    @Override
    public void putData(String tableName, String rowKey, String familyName, String columnName, String value) throws Exception {
        // HTable table = new HTable(conf, tableName);
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(familyName), Bytes.toBytes(columnName), Bytes.toBytes(value));
        table.put(put);
        System.out.println("插入成功");
    }

    /**
     * @param tableName
     *            表名
     * @param rowKey
     *            rowkey
     * @param column1
     *            第一个列簇的key数组
     * @param value1
     *            第一个列簇的value数组，key数组和value数组长度必须一样
     * @param column2
     *            第二列簇的key数组
     * @param value2
     *            第二个列簇的values数组， 同上同理
     * @throws Exception
     */
    @Override
    public void addData(String tableName, String rowKey, String[] column1, String[] value1, String[] column2, String[] value2) throws Exception {
        List<Put> puts = new ArrayList<Put>();

        for (int i = 0; i < column1.length; i++) {
            Put put = new Put(Bytes.toBytes(rowKey));
            put.add(Bytes.toBytes(FAMILY1), Bytes.toBytes(column1[i]), Bytes.toBytes(value1[i]));
            puts.add(put);
        }

        for (int i = 0; i < column2.length; i++) {
            Put put = new Put(Bytes.toBytes(rowKey));
            put.add(Bytes.toBytes(FAMILY2), Bytes.toBytes(column2[i]), Bytes.toBytes(value2[i]));
            puts.add(put);
        }

        table.put(puts);
        System.out.println("插入一堆数据成功");
    }

    // get 'tablename','rowkey'
    @Override
    public Result getResult(String tableName, String rowKey) throws Exception {
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        return result;
    }

    @Override
    public Result getResult(String tableName, String rowKey, String familyName, String columnName) throws Exception {
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        Result result = table.get(get);
        return result;
    }

    @Override
    public ResultScanner getResultScann(String tableName) throws Exception {
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        // ResultScanner scanner = table.getScanner(Bytes.toBytes(FAMILY2));
        // ResultScanner scanner = table.getScanner(Bytes.toBytes(FAMILY1),
        // Bytes.toBytes("name1"));
        return scanner;
    }

    @Override
    public ResultScanner getResultScann(String tableName, Scan scan) throws Exception {
        return table.getScanner(scan);
    }

    @Override
    public Result getResultByColumn(String tableName, String rowKey, String familyName, String columnName) throws Exception {
        return null;
    }

    // get 'person','p001',{COLUMNS => 'cf1:name', VERSIONS => 3}
    @Override
    public Result getResultByVersion(String tableName, String rowKey, String familyName, String columnName, int versions) throws Exception {
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        get.setMaxVersions(versions);
        Result result = table.get(get);
        return result;
    }

    public ResultScanner getResultByVersion(String rowKey, String familyName, String columnName, int versions) throws Exception {
        Scan scan = new Scan(Bytes.toBytes(rowKey), Bytes.toBytes(rowKey));
        scan.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        scan.setMaxVersions(versions);
        ResultScanner scanner = table.getScanner(scan);
        return scanner;
    }

    @Override
    public void deleteColumn(String tableName, String rowKey, String falilyName, String columnName) throws Exception {

    }

    @Override
    public void deleteColumn(String tableName, String rowKey) throws Exception {

    }

    @Override
    public void disableTable(String tableName) throws Exception {
        admin.disableTable(tableName);
    }

    @Override
    public void dropTable(String tableName) throws Exception {
        try {
            admin.deleteTable(tableName);
        } catch (Exception e) {
            // e.printStackTrace();
            disableTable(tableName);
            admin.deleteTable(tableName);
            System.out.println("ssssssss");
        } finally {
            boolean tableExists = admin.tableExists(Bytes.toBytes(tableName));
            System.out.println(tableExists ? "删除失败" : "删除成功");
        }
    }
}