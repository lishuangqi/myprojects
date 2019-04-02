package com.lishuangqi.utils.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lishuangqi.utils.UuidUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * excel工具类
 * @author flycloud
 * @date 2019-01-04
 */
public class ExcelUtils {
    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);
    private static final SimpleDateFormat yyyyMMDDHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 导出excel
     * @param fileName 文件名（*.xsl）
     * @param sheetName sheet名
     * @param headers   头部
     * @param columsNames 实体属性名
     * @param dataList   数据列表
     * @param response
     */
    public static void exportExcel(String fileName, String sheetName, String[] headers, String[] columsNames, List<Map<String, Object>> dataList, HttpServletResponse response) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCellStyle headerStyle = wb.createCellStyle();
        XSSFFont headerFont = wb.createFont();    //创建字体样式
        headerFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);    // 字体加粗
        headerFont.setFontName("宋体");    //设置字体类型
        headerFont.setFontHeightInPoints((short) 12);    //设置字体大小
        headerStyle.setFont(headerFont);    //为标题样式设置字体样式
        headerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//设置剧中
        //创建一个样式
        XSSFCellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        XSSFFont bodyFont = wb.createFont();    //创建字体样式
        bodyFont.setFontName("宋体");    //设置字体类型
        bodyFont.setFontHeightInPoints((short) 10);    //设置字体大小
        bodyStyle.setFont(bodyFont);    //为标题样式设置字体样式
        //在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        //在sheet中添加表头第0行
        XSSFRow row = sheet.createRow(0);
        //声明列对象
        XSSFCell cell = null;
        //创建标题行
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(headers[i]);
        }
        //创建内容
        for (int i = 0; i < dataList.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < columsNames.length; j++) {
                Map<String, Object> map = dataList.get(i);
                Object obj = map.get(columsNames[j]);
                String columsValue = StringUtils.EMPTY;
                if(obj instanceof Date){
                    columsValue = yyyyMMDDHHmmss.format(obj);
                }else {
                    columsValue = obj == null ? "" : obj.toString();
                }
                cell = row.createCell(j);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(columsValue);
            }
        }
        // 必须在单元格设值以后进行
        // 设置为根据内容自动调整列宽
        for (int k = 0; k < dataList.size(); k++) {
            sheet.autoSizeColumn(k);
        }
        // 处理中文不能自动调整列宽的问题
        setSizeColumn(sheet, dataList.size());
        setResponseHeader(response, fileName);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            wb.write(out);
            out.close();
            out = null;
            String str = "导出" + fileName + "成功！";
            log.info(str);
        } catch (IOException e) {
            String str = "导出" + fileName + "失败！";
            log.error(str);
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 导入excel
     * @param file 文件名（*.xsl）
     * @param argMethodName 实体属性名
     * @param argMethodType 实体属性类型
     * @param startRowNum 开始行数
     * @param startCellNum 开始列数
     * @param isNeedId 是否添加ID
     */
    public static List<Object> importExcel(MultipartFile file, Object obj,
                                   String[] argMethodName, String[] argMethodType, Integer startRowNum, Integer startCellNum, boolean isNeedId) {
        try {
            List<List<Object>> list = new ArrayList<>();
            List<Map<String, String>> argList = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < argMethodName.length; i++) {
                map.put(argMethodName[i], argMethodType[i]);
                argList.add(map);
                map = new HashMap<>();
            }
            list = excelToList(file, startRowNum, startCellNum, argMethodName.length);
            List<Object> relustList = new ArrayList<>();
            for (List<Object> valList : list) {
                obj = obj.getClass().newInstance();
                Object objectVal = setObjectVal(obj, valList, argList, isNeedId);
                relustList.add(objectVal);
            }
            return  relustList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<List<Object>> excelToList(MultipartFile file, Integer startRowNum, Integer startCellNum, Integer length) throws Exception {

        //装载流
        InputStream fs = file.getInputStream();
        Workbook hw = new WorkbookFactory().create(fs);


        Sheet sheet = hw.getSheetAt(0);

        //容器
        List<List<Object>> ret = new ArrayList<List<Object>>();
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum(); ) {
            Row r = sheet.getRow(i);
            if (r == null) {
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
                continue;
            }
            flag = false;
            for (Cell c : r) {
                if (c.getCellType() != Cell.CELL_TYPE_BLANK) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                i++;
                continue;
            } else {//如果是空白行（即可能没有数据，但是有一定格式）
                if (i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉
                    sheet.removeRow(r);
                else//如果还没到最后一行，则数据往上移一行
                    sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
            }
        }

        //遍历行
        for (int i = startRowNum; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int lastCellIndex = row.getLastCellNum();
            //装载obj
            if (lastCellIndex > 0) {
                ret.add(dataObj(startCellNum, length, row));
            }
        }
        return ret;
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
                        method.invoke(obj, intval);
                        break;
                    case "String":
                        method = clazz.getMethod(key, String.class);
                        method.invoke(obj, (String) val);
                        break;
                    case "Date":
                        method = clazz.getMethod(key, Date.class);
                        Date date = castToDate(val);
                        method.invoke(obj, date);
                        break;
                    case "Double":
                        method = clazz.getMethod(key, Double.class);
                        Double dou = Double.valueOf((String) val);
                        method.invoke(obj, dou);
                        break;
                    case "Long":
                        method = clazz.getMethod(key, Long.class);
                        Long lon = Double.valueOf((String) val).longValue();
                        method.invoke(obj, lon);
                        break;
                    case "BigDecimal":
                        method = clazz.getMethod(key, BigDecimal.class);
                        BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf((String) val));
                        method.invoke(obj, bigDecimal);
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
        if (isNeedId) {
            method = clazz.getMethod("setId", String.class);
            method.invoke(obj, UuidUtil.uuidStr());
        }
//        method = clazzService.getMethod("insert");
//        method.invoke(objService, clazz);
        return obj;
    }

    /**
     * 拼装单个obj
     *
     * @param
     * @param row
     * @return
     * @throws Exception
     */
    private static List<Object> dataObj(Integer startCellNum, Integer length, Row row) throws Exception {

        List<Object> list = new ArrayList<>();
        //注意excel表格字段顺序要和obj字段顺序对齐 （如果有多余字段请另作特殊下标对应处理）
        for (int j = startCellNum; j < length; j++) {
            Cell cell = row.getCell(j);
            if (cell == null) {
                list.add("");
            } else {
                list.add(getValue(row.getCell(j)));

            }
        }
        return list;
    }

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

        return value;
    }

    public static Date castToDate(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Calendar) {
            return ((Calendar) value).getTime();
        } else if (value instanceof Date) {
            return (Date) value;
        } else {
            String strVal = (String) value;
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

            if (StringUtils.isNotEmpty(strVal)) {
                String format = null;
                if (pattern.matcher(strVal).matches()) {//如果是数字
                    if (strVal.length() == 4) {
                        format = "yyyy";
                    } else if (strVal.length() == 6) {
                        format = "yyyyMM";
                    } else if (strVal.length() == 8) {
                        format = "yyyyMMdd";
                    } else if (strVal.length() == 10) {
                        format = "yyyyMMddHH";
                    } else if (strVal.length() == 12) {
                        format = "yyyyMMddHHmm";
                    } else if (strVal.length() == 14) {
                        format = "yyyyMMddHHmmss";
                    } else if (strVal.length() == 17) {
                        format = "yyyyMMddHHmmssSSS";
                    }
                } else {
                    if (strVal.length() == 10) {
                        format = "yyyy-MM-dd";
                    }else if (strVal.length() == 19) {
                        format = JSON.DEFFAULT_DATE_FORMAT;
                    } else if (strVal.length() == 20) {
                        format = "yyyy年MM月dd日 HH:mm:ss";
                    }else {
                        format = JSON.DEFFAULT_DATE_FORMAT;
                    }

                }

                SimpleDateFormat dateFormat = new SimpleDateFormat(format);

                try {
                    return dateFormat.parse(strVal);
                } catch (ParseException var7) {
                    throw new JSONException("can not cast to Date, value : " + strVal);
                }
            }else  {
                return null;
            }
        }
    }
    /**
     * 设置响应头
     * @param response
     * @param fileName
     */
    private static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            fileName = new String(fileName.getBytes(),"ISO8859-1");
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private static void setSizeColumn(XSSFSheet sheet, int size) {
        for (int columnNum = 0; columnNum < size; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(columnNum) != null) {
                    XSSFCell currentCell = currentRow.getCell(columnNum);
                    if (currentCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if(columnWidth > 30) {
                columnWidth = 30;
            }
            if(columnWidth < 10) {
                columnWidth = 10;
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }
}