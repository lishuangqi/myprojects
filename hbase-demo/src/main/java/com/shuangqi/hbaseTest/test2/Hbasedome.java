package com.shuangqi.hbaseTest.test2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.List;


public class Hbasedome implements HBaseDemoInterface{


    static Configuration conf =null;
    private static final String ZKconnect="10.1.251.52:2181";
    static{
        conf=HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", ZKconnect);
    }
//  static String tableName="student";
//  static String[] family={"lie01","lie02"};


    public static void main(String[] args) {
        Hbasedome a =new Hbasedome();
        String tableName="student11";
        String[] family={"lie01","lie02"};
        try {
            HTableDescriptor htds =new HTableDescriptor(tableName);
            for(int z=0;z<family.length;z++){
                HColumnDescriptor h=new HColumnDescriptor(family[z]);
                htds.addFamily(h);
            }
//          a.descTable("table03");
//          a.createTable(tableName, htds);
//          a.descTable("table03");
//          a.getAllTables();
//          a.createTable(tableName,family);
//          a.getResult("table03", "usr001");
//          a.dropTable("user1");
//          a.getAllTables();
//          a.putData("table03", "usr005", "liezu01", "name", "liu");
//          a.getResult("table03", "usr001");
//          a.getResultScann("table03");
//          a.getResultScann("table03","");

            Result result = a.getResult("table03", "usr001");
            System.out.println(result.toString());
            List<Cell> cells = result.listCells();
            for (int i = 0; i < cells.size(); i++) {
                Cell cell = cells.get(i);
                System.out.println(cell.toString());
                //          printCell(cell);
            }

//          List<KeyValue> list = result.list();
//          for (int i = 0; i < list.size(); i++) {
//              KeyValue kv = list.get(i);
//              printKeyValye(kv);
//          }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public static void printKeyValye(KeyValue kv) {
        System.out.println(Bytes.toString(kv.getRow()) + "\t" + Bytes.toString(kv.getFamily()) + "\t" + Bytes.toString(kv.getQualifier()) + "\t" + Bytes.toString(kv.getValue()) + "\t" + kv.getTimestamp());
    }
    public static void printCell(Cell cell) {
        System.out.println(Bytes.toString(cell.getRow()) + "\t" + Bytes.toString(cell.getFamily()) + "\t" + Bytes.toString(cell.getQualifier()) + "\t" + Bytes.toString(cell.getValue()) + "\t" + cell.getTimestamp());
    }
    //创建表
    @Override
    public void createTable(String tableName, String[] family) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        HTableDescriptor desc =new HTableDescriptor(tableName);

        for(int i=0;i<family.length;i++){
            desc.addFamily(new HColumnDescriptor(family[i]));
            System.out.println("11111111111"+family[i]);
        }
        if(admin.tableExists(tableName)){
            System.out.println("表已经存在，别瞎输行吗");
//          System.exit(0);
        }else{
            admin.createTable(desc);
            System.out.println("表创建成功");
        }
    }

    //创建表
    @Override
    public void createTable(String tableName, HTableDescriptor htds) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        boolean tableExists1 = admin.tableExists(Bytes.toBytes(tableName));
        System.out.println(tableExists1 ? "表已存在" : "表不存在");
        admin.createTable(htds);
        boolean tableExists = admin.tableExists(Bytes.toBytes(tableName));
        System.out.println(tableExists ? "创建表成功" : "创建失败");
    }


    @Override
    public void descTable(String tableName) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        HTable table=new HTable(conf, tableName);
        HTableDescriptor desc =table.getTableDescriptor();
        HColumnDescriptor[] columnFamilies = desc.getColumnFamilies();

        for(HColumnDescriptor t:columnFamilies){
            System.out.println(Bytes.toString(t.getName()));
        }

    }

    //// 这种方式是替换该表tableName的所有列簇
    @Override
    public void modifyTable(String tableName) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        htd.addFamily(new HColumnDescriptor(Bytes.toBytes("cf3")));
        htd.addFamily(new HColumnDescriptor(Bytes.toBytes("cf2")));
        admin.modifyTable(tableName, htd);

        // 删除该表tableName当中的特定的列簇
        // admin.deleteColumn(tableName, "cf3");

        System.out.println("修改成功");

    }

    @Override
    public void getAllTables() throws Exception {
        HBaseAdmin admin =new HBaseAdmin(conf);

        String[] tableNames = admin.getTableNames();
        for(int i=0;i<tableNames.length;i++){
            System.out.println(tableNames[i]);
        }
    }

    //更新数据  插入数据
    @Override
    public void putData(String tableName, String rowKey, String familyName, String columnName, String value)
            throws Exception {
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        Put put=new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(familyName), Bytes.toBytes(columnName), Bytes.toBytes(value));
        htable.put(put);

    }

    //为表添加数据
    @Override
    public void addData(String tableName, String rowKey, String[] column1, String[] value1, String[] column2,
                        String[] value2) throws Exception {

        Put put=new Put(Bytes.toBytes(rowKey));
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        HColumnDescriptor[] columnFamilies = htable.getTableDescriptor().getColumnFamilies();
        for(int i=0;i<=columnFamilies.length;i++){
            String nameAsString = columnFamilies[i].getNameAsString();
            if(nameAsString.equals("lie01")){
                for(int j=0;j<column1.length;j++){
                    put.add(Bytes.toBytes(nameAsString), Bytes.toBytes(column1[j]),Bytes.toBytes(value1[j]));
                }
            }
            if(nameAsString.equals("lie02")){
                for(int j=0;j<column2.length;j++){
                    put.add(Bytes.toBytes(nameAsString), Bytes.toBytes(column2[j]),Bytes.toBytes(value2[j]));
                }
            }

        }
        htable.put(put);
        System.out.println("addData ok!");
    }

    //根据rowkey 查询
    @Override
    public Result getResult(String tableName, String rowKey) throws Exception {
        Get get=new Get(Bytes.toBytes(rowKey));
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        Result result=htable.get(get);
//      for(KeyValue k:result.list()){
//          System.out.println(Bytes.toString(k.getFamily()));
//          System.out.println(Bytes.toString(k.getQualifier()));
//          System.out.println(Bytes.toString(k.getValue()));
//          System.out.println(k.getTimestamp());
//      }
        return result;
    }

    //查询指定的某列
    @Override
    public Result getResult(String tableName, String rowKey, String familyName, String columnName) throws Exception {
        Get get=new Get(Bytes.toBytes(rowKey));
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        get.addColumn(Bytes.toBytes(familyName),Bytes.toBytes(columnName));
        Result result=htable.get(get);
        for(KeyValue k:result.list()){
            System.out.println(Bytes.toString(k.getFamily()));
            System.out.println(Bytes.toString(k.getQualifier()));
            System.out.println(Bytes.toString(k.getValue()));
            System.out.println(k.getTimestamp());
        }
        return result;
    }


    //遍历查询表
    @Override
    public ResultScanner getResultScann(String tableName) throws Exception {

        Scan scan=new Scan();
        ResultScanner rs =null;
        HTable htable=new HTable(conf, tableName);
        try{
            rs=htable.getScanner(scan);
            for(Result r: rs){
                for(KeyValue kv:r.list()){

                    System.out.println(Bytes.toString(kv.getRow()));
                    System.out.println(Bytes.toString(kv.getFamily()));
                    System.out.println(Bytes.toString(kv.getQualifier()));
                    System.out.println(Bytes.toString(kv.getValue()));
                    System.out.println(kv.getTimestamp());
                }
            }
        }finally{
            rs.close();
        }
        return rs;
    }

    @Override
    public ResultScanner getResultScann(String tableName, Scan scan) throws Exception {

        ResultScanner rs =null;
        HTable htable=new HTable(conf, tableName);
        try{
            rs=htable.getScanner(scan);
            for(Result r: rs){
                for(KeyValue kv:r.list()){

                    System.out.println(Bytes.toString(kv.getRow()));
                    System.out.println(Bytes.toString(kv.getFamily()));
                    System.out.println(Bytes.toString(kv.getQualifier()));
                    System.out.println(Bytes.toString(kv.getValue()));
                    System.out.println(kv.getTimestamp());
                }
            }
        }finally{
            rs.close();
        }
        return rs;
    }

    //查询表中的某一列
    @Override
    public Result getResultByColumn(String tableName, String rowKey, String familyName, String columnName)
            throws Exception {


        HTable htable=new HTable(conf, tableName);
        Get get=new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName),Bytes.toBytes(columnName));
        Result result=htable.get(get);
        for(KeyValue kv: result.list()){

            System.out.println(Bytes.toString(kv.getFamily()));
            System.out.println(Bytes.toString(kv.getQualifier()));
            System.out.println(Bytes.toString(kv.getValue()));
            System.out.println(kv.getTimestamp());

        }
        return result;
    }


    //查询某列数据的某个版本
    @Override
    public Result getResultByVersion(String tableName, String rowKey, String familyName, String columnName,
                                     int versions) throws Exception {

        HTable htable=new HTable(conf, tableName);
        Get get =new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        get.setMaxVersions(versions);
        Result result=htable.get(get);

        for(KeyValue kv: result.list()){

            System.out.println(Bytes.toString(kv.getFamily()));
            System.out.println(Bytes.toString(kv.getQualifier()));
            System.out.println(Bytes.toString(kv.getValue()));
            System.out.println(kv.getTimestamp());

        }

        return result;
    }

    //删除指定某列
    @Override
    public void deleteColumn(String tableName, String rowKey, String falilyName, String columnName) throws Exception {

        HTable htable=new HTable(conf, tableName);
//      Delete delete1=new Delete(Bytes.toBytes(rowKey));
        Delete de =new Delete(Bytes.toBytes(rowKey));
        de.deleteColumn(Bytes.toBytes(falilyName), Bytes.toBytes(columnName));
        htable.delete(de);
    }


    //删除指定的某个rowkey
    @Override
    public void deleteColumn(String tableName, String rowKey) throws Exception {
        HTable htable=new HTable(conf, tableName);

        Delete de =new Delete(Bytes.toBytes(rowKey));
        htable.delete(de);

    }

    //让该表失效
    @Override
    public void disableTable(String tableName) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        admin.disableTable(tableName);

    }

    //删除表
    @Override
    public void dropTable(String tableName) throws Exception {

        HBaseAdmin admin=new HBaseAdmin(conf);
        admin.disableTable(tableName);
        admin.deleteTable(tableName);

    }

}