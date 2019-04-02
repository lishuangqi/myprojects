package com.lishuangqi.utils.excel;

import com.lishuangqi.utils.UuidUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ImportExcelUtil {


    /**
     * 拼装单个obj
     *
     * @param
     * @param row
     * @return
     * @throws Exception
     */
    private static List<String> dataObj( Integer startCellNum, Integer length, Row row) throws Exception {
//        Class<?> rowClazz= obj.getClass();        
//        Field[] fields = FieldUtils.getAllFields(rowClazz);    
//        if (fields == null || fields.length < 1) {    
//            return null;    
//        }    
//            
//        //容器    
//        Map<String, Object> map = new HashMap<String, Object>();    
        List<String> list = new ArrayList<>();
        //注意excel表格字段顺序要和obj字段顺序对齐 （如果有多余字段请另作特殊下标对应处理）    
        for (int j = startCellNum; j < length; j++) {
            Cell cell = row.getCell(j);
            if(cell == null){
                list.add("");
            }else{
                list.add(getValue(row.getCell(j)));

            }//        	map.put(fields[j].getName(), getVal(row.getCell(j)));
        }
        return list;
    }



    public static List<List<String>> importExcel(MultipartFile file, Integer startRowNum, Integer startCellNum, Integer length) throws Exception {

        //装载流    
        InputStream fs = file.getInputStream();
        //POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
        Workbook hw = new WorkbookFactory().create(fs);
//        HSSFWorkbook hw= new HSSFWorkbook(fs);    


        Sheet sheet = hw.getSheetAt(0);

        //容器    
        List<List<String>> ret = new ArrayList<List<String>>();
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
//        System.out.println("总行数："+(sheet.getLastRowNum()+1));
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {
            Row r = sheet.getRow(i);
            if(r == null){
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                continue;
            }
            flag = false;
            for(Cell c:r){
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){
                    flag = true;
                    break;
                }
            }
            if(flag){
                i++;
                continue;
            }
            else{//如果是空白行（即可能没有数据，但是有一定格式）
                if(i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉
                    sheet.removeRow(r);
                else//如果还没到最后一行，则数据往上移一行
                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
            }
        }
//        System.out.println("去除空白行后总行数："+(sheet.getLastRowNum()+1));

        //遍历行
        for (int i = startRowNum; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int lastCellIndex = row.getLastCellNum();
            //装载obj
            if(lastCellIndex>0) {
                ret.add(dataObj( startCellNum, length, row));
            }
        }
        return ret;
    }

//    public static List<List<String>> importIrregularExcel(MultipartFile file, Integer startRowNum, Integer startCellNum, Integer length) throws Exception {
//
//        //装载流
//        InputStream fs = file.getInputStream();
//        //POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
//        Workbook hw = new WorkbookFactory().create(fs);
////        HSSFWorkbook hw= new HSSFWorkbook(fs);
//
//
//        Sheet sheet = hw.getSheetAt(0);
//
//        //容器
//        List<List<String>> ret = new ArrayList<List<String>>();
//        CellReference cellReference = new CellReference("A4");
//        boolean flag = false;
////        System.out.println("总行数："+(sheet.getLastRowNum()+1));
//        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {
//            Row r = sheet.getRow(i);
//            if(r == null){
//                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
//                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
//                continue;
//            }
//            flag = false;
//            for(Cell c:r){
//                if(c.getCellType() != Cell.CELL_TYPE_BLANK){
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag){
//                i++;
//                continue;
//            }
//            else{//如果是空白行（即可能没有数据，但是有一定格式）
//                if(i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉
//                    sheet.removeRow(r);
//                else//如果还没到最后一行，则数据往上移一行
//                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
//            }
//        }
////        System.out.println("去除空白行后总行数："+(sheet.getLastRowNum()+1));
//
//        //遍历行
//        for (int i = startRowNum; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            int lastCellIndex = row.getLastCellNum();
//            //装载obj
//            if(lastCellIndex>0) {
//                List<String> list = new ArrayList<>();
//                for (int j = startCellNum; j < length; j++) {
//                    if(row.getCell(0)!=null ){
//
//                    }
//                    Cell cell = row.getCell(j);
//                    if(cell!=null){
//                        list.add(getValue(row.getCell(j)));
//                    }
//                }
//            }
//        }
//        return ret;
//    }



    /**
     * 根据不同情况获取Java类型值
     */
    private static String getValue(Cell cell) {
        //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df = new DecimalFormat("#.#########");
        String value = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                //如果为时间格式的内容
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    value = String.valueOf(sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())));
                    break;
                } else {
                    value = String.valueOf(df.format(cell.getNumericCellValue()));
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                value = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA: //公式类型
                // cell.getCellFormula();
                try {
                    value = String.valueOf(df.format(cell.getNumericCellValue()));
                } catch (IllegalStateException e) {
                    value = String.valueOf(cell.getRichStringCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_BLANK: // 空值
                value = "";
                break;
            case HSSFCell.CELL_TYPE_ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }

//        switch (cell.getCellTypeEnum()) {
//            case STRING:
//                value = cell.getRichStringCellValue().getString();
//                break;
//            case NUMERIC:
//                if("General".equals(cell.getCellStyle().getDataFormatString())){
//                    value = df.format(cell.getNumericCellValue());
//                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
//                    value = sdf.format(cell.getDateCellValue());
//                }else{
//                    value = df.format(cell.getNumericCellValue());
//                }
//                break;
//            case BOOLEAN:
//                value = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case BLANK:
//                value = "";
//                break;
//            default:
//                value = cell.toString();
//                break;
//        }
        return value;
    }

    //反射注入值
    public static Object setObjectVal(Object obj, List<Object> valList, List<Map<String, String>> argList, boolean isNeedId) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ParseException {
        Class<?> clazz = obj.getClass();
        Method method = null;

        int i = 0;
        for (Map<String, String> map : argList) {
            for (String key : map.keySet()) {
                Object val = valList.get(i);
                switch (map.get(key)) {
                    case "Integer":
                        method = clazz.getMethod(key, Integer.class);
                        Integer intval = Double.valueOf((String) val).intValue();
                        val = intval;
                        method.invoke(obj, intval);
                        continue;

                    case "String":
                        method = clazz.getMethod(key, String.class);
                        method.invoke(obj, (String) val);
                        continue;

                    case "Date":
                        method = clazz.getMethod(key, Date.class);
                        //EXCEL里的的日期可能是字符串，也可能是一个数字（值为1900年1月1日到现在的天数）
                        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                        if (pattern.matcher((String) val).matches()) {//如果是数字
                            Date date = HSSFDateUtil.getJavaDate(Double.parseDouble((String) val));
                            date = format.parse(format.format(date));
                            val = date;
                            method.invoke(obj, date);
                        } else {
                            Date date = format.parse((String) val);
                            val = date;
                            method.invoke(obj, date);
                        }
                        continue;

                    case "Double":
                        method = clazz.getMethod(key, Double.class);
                        Double dou = Double.valueOf((String) val);
                        val = dou;
                        method.invoke(obj, dou);
                        continue;

                    case "Long":
                        method = clazz.getMethod(key, Long.class);
                        Long lon = Double.valueOf((String) val).longValue();
                        val = lon;
                        method.invoke(obj, lon);
                        continue;
                }
            }
            i++;
        }
        if (isNeedId) {
            method = clazz.getMethod("setId", String.class);
            method.invoke(obj, UuidUtil.uuidStr());
        }
        method = clazz.getMethod("insert");
        method.invoke(obj);
        return obj;
        // Java 反射机制 - 调用某个类的方法2.  
        // age -> 22. name -> 小明  
    }

//    public static void excleInsertToDataBase(MultipartFile file, Object obj,
//                                             List<Map<String, String>> argList, String[] argMethodName, String[] argMethodType, boolean isNeedId) {
//        try {
//            List<List<Object>> list = new ArrayList<>();
//            Map<String, String> map = new HashMap<>();
//            for (int i = 0; i < argMethodName.length; i++) {
//                map.put(argMethodName[i], argMethodType[i]);
//                argList.add(map);
//                map = new HashMap<>();
//            }
//            list = ImportExcelUtil.importExcel(file, argMethodName.length);
//            for (List<Object> valList : list) {
//                obj = obj.getClass().newInstance();
//                ImportExcelUtil.setObjectVal(obj, valList, argList, isNeedId);
//            }
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}