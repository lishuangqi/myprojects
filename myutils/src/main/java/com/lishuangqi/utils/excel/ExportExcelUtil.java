package com.lishuangqi.utils.excel;

import org.apache.poi.hssf.usermodel.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExportExcelUtil {
    private final static DateFormat YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
    private final static DateFormat HHMMSS = new SimpleDateFormat("HH:mm:ss");
    private static final DateFormat YYYYMMDDHHMM = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private static final DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateFormat YYYYMMDD2 = new SimpleDateFormat("yyyy-MM-dd");


    public static HSSFWorkbook export(String nameFull, String[] arrName, String[] arrField, List list) {
//		String[] excelHeader = { "Sno", "Name", "Age" };
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(nameFull);
        sheet.setDefaultColumnWidth(100 * 256);
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < arrName.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(arrName[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, 7 * 2 * 256);
//			sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            Map obj = (Map) list.get(i);
            for(int j = 0; j < arrField.length; j++){
                Object param = obj.get(arrField[j]);
                System.out.println(param);
                if (param instanceof Integer) {
                    int value = ((Integer) param).intValue();
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof String) {
                    String value = (String) param;
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof Double) {
                    double value = ((Double) param).doubleValue();
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof Float) {
                    float value = ((Float) param).floatValue();
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof Long) {
                    long value = ((Long) param).longValue();
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof Boolean) {
                    boolean value = ((Boolean) param).booleanValue();
                    row.createCell(j).setCellValue(value);
                } else if (param instanceof Date) {
                    Date value = (Date) param;
                    row.createCell(j).setCellValue(value);
                }

            }
        }
        return wb;
    }

    public static HSSFWorkbook export1(String nameFull, String[] arrName, String[] arrField, List<Map<String,Object>> list) {
//		String[] excelHeader = { "Sno", "Name", "Age" };
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(nameFull);
        sheet.setDefaultColumnWidth(100 * 256);
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCellStyle rightStyle = wb.createCellStyle();
        rightStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        for (int i = 0; i < arrName.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(arrName[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, 7 * 2 * 256);
//			sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            Map obj = (Map) list.get(i);
            for(int j = 0; j < arrField.length; j++){
                Object param = obj.get(arrField[j]);
                HSSFCell cell = row.createCell(j);
                if (param instanceof Integer) {
                    int value = ((Integer) param).intValue();
                    cell.setCellValue(value);
                } else if (param instanceof String) {
                    String value = (String) param;
                    cell.setCellValue(value);
                } else if (param instanceof Long) {
                    Long value = (Long) param;
                    cell.setCellValue(value);
                    cell.setCellStyle(rightStyle);
                }
                else if (param instanceof Double) {
                    double value = ((Double) param).doubleValue();
                    cell.setCellValue(value);
                } else if (param instanceof Float) {
                    float value = ((Float) param).floatValue();
                    cell.setCellValue(value);
                } else if (param instanceof Long) {
                    long value = ((Long) param).longValue();
                    cell.setCellValue(value);
                } else if (param instanceof Boolean) {
                    boolean value = ((Boolean) param).booleanValue();
                    cell.setCellValue(value);
                } else if (param instanceof Date) {
                    Date value = (Date) param;
                    cell.setCellValue(YYYYMMDD2.format(value));
                    cell.setCellStyle(style);
                }  else if (param instanceof Number) {
                    long value = ((Number)param).longValue();
                    cell.setCellValue(value);
                    cell.setCellStyle(rightStyle);
                } else {
                    String value = String.valueOf(param);
                    cell.setCellValue(value);
                    cell.setCellStyle(rightStyle);
                }
            }
        }
        return wb;
    }

    public static void main(String[] args) {
        String filename = "测试";
        String[] arrName = {"省份", "人数"};
        String[] arrMethod = {"province", "num"};
//        List<Map<String, Object>> maps = SqlCons.queryWithParams(SqlCons.sqlProvince);
        List<Map> mapLists =new ArrayList<Map>();
        Map map = new HashMap();
        map.put("province", "aaa");
        map.put("num", 12);
        mapLists.add(map);
        Map map1 = new HashMap();
        map1.put("province", "bbbb");
        map1.put("num", 222);
        mapLists.add(map1);
        export(filename, arrName, arrMethod, mapLists);

//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf-8");
//        try {
//            response.setHeader("Content-Disposition", "filename="+ new String((nameFull+".xls").getBytes("gb2312"), "iso8859-1"));
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }//设置文件头编码方式和文件名

//		response.setHeader("Content-disposition", "attachment;filename=111.xls");
//        OutputStream ouputStream = null;
//        try {
//            ouputStream = response.getOutputStream();
//            wb.write(ouputStream);
//            ouputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                ouputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
