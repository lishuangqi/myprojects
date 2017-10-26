package com.lishuangqi.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 包含常用工具方法
 * 
 * @author lishuangqi
 * @version 1.0 2013-2-26
 */
public class Utils {

	public final static FastDateFormat FAST_DATE_FORMAT = FastDateFormat
			.getInstance("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat datePattern = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 数组的Join方法
	 * 
	 * @param obj
	 * @param sep
	 * @return
	 */
	public static String join(Object[] obj, String sep) {
		if (obj == null)
			return null;

		int length = obj.length;
		if (length == 0)
			return "";
		StringBuilder sb = new StringBuilder().append(obj[0]);

		for (int i = 1; i < length; i++) {
			sb.append(sep).append(obj[i]);
		}

		return sb.toString();
	}

	/**
	 * 把字符串转换成double 如果一次返回defValue
	 * 
	 * @param value
	 * @param defValue
	 * @return
	 */
	public static double stringToDouble(String value, double defValue) {

		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return defValue;
		}

	}

	/**
	 * 字符串转换为long
	 * 
	 * @param val
	 * @param defVal
	 *            如果转换失败给定的默认值
	 * @return
	 */
	public static long parseLong(String val, long defVal) {
		try {
			return Long.parseLong(val);
		} catch (Exception e) {
			return defVal;
		}
	}

	/**
	 * 将字符串转换成日期格式
	 * 
	 * @param pattern
	 * @param date
	 * @return 转换失败时返回null
	 */
	public static Date stringToDate(String pattern, String date) {
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 字符串转Date
	 * 
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String date) {
		try {
			return datePattern.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer dateStringToInt(String date) {
		return Utils.convertDateToInt(Utils.stringToDate(date));
	}

	/*****
	 * 将毫秒转换成日期格式的字符串
	 * 
	 * @param millis
	 * @return
	 */
	public static String longTodateString(long millis) {
		return FAST_DATE_FORMAT.format(millis);
	}

	/**
	 * 转换首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstUpper(String str) {
		String s = (str.charAt(0) + "").toUpperCase();
		return s + str.substring(1);
	}

	/**
	 * 把时间转换成yyyy-MM-dd HH:mm:ss 格式
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return null;
		}
		return FAST_DATE_FORMAT.format(date);
	}

	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 把时间转换成yyyy年MM月dd日HH时mm分ss秒 格式
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToZhString(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(date);
	}

	/****
	 * 将时间转换成时间戳格式
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToTimeStamp(Date date) {
		if (date != null) {
			return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		}

		return null;
	}

	/******
	 * 将日期格式2013-10-11T10:28:50.442382转换成日期对应毫秒数字符串
	 * 
	 * @return
	 */
	public static String stringtodate(String date) {
		if (date == null || date.length() == 0) {
			return null;
		}
		String pattern = "\\d{4}-\\d{2}-\\d{2}[a-zA-Z\\s]+\\d{2}:\\d{2}:\\d{2}.\\d*";
		StringBuffer sbf = new StringBuffer();
		if (date.matches(pattern)) {
			for (String s : StringUtils.substringBefore(date, ".").split(
					"[a-zA-Z\\s]+")) {
				sbf.append(s + " ");
			}
			return String.valueOf(stringToDate("yyyy-MM-dd hh:mm:ss",
					sbf.toString().trim()).getTime());
		} else {
			return date;
		}
	}

	/**
	 * 格式化mac地址按没两位分割
	 * 
	 * @param mac
	 *            需要格式化的mac地址
	 * @param sep
	 *            分隔符 ":"或者" "等
	 * @return
	 */
	public static String formatMac(String mac, String sep) {
		if (StringUtil.isEmpty(mac)) {
			return "";
		}

		mac = mac.replaceAll("[^a-zA-Z0-9]", "");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < mac.length(); i += 2) {
			sb.append(mac.substring(i, i + 2) + sep);
		}

		return sb.substring(0, sb.length() - sep.length());

	}

	/**
	 * 返回异常的字符串
	 * 
	 * @param e
	 * @return
	 */
	public static String exceptionToString(Exception e) {
		String str = "";
		if (e != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			str = sw.toString();
			pw.close();
			try {
				sw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return str;
	}

	/**
	 * 如果字符串为空则返回def否则返回str
	 * 
	 * @param str
	 * @param def
	 * @return
	 */
	public static String nullToDefault(String str, String def) {
		return StringUtil.isEmpty(str) ? def : str;
	}

	/**
	 * 将毫秒数换算成x天x时x分x秒x毫秒
	 * 
	 * @param ms
	 * @return
	 */
	public static String millisToTime(long ms) {
		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		long milliSecond = ms - day * dd - hour * hh - minute * mi - second
				* ss;

		StringBuffer sb = new StringBuffer("");
		if (day != 0l) {
			sb.append(day + "天");
		}
		if (hour != 0l) {
			sb.append(hour + "小时");
		}
		if (minute != 0l) {
			sb.append(minute + "分");
		}

		if (milliSecond != 0l) {
			sb.append(second + "." + milliSecond + "秒");
		} else {
			sb.append(second + "秒");
		}
		return sb.toString();
	}

	/**
	 * 字符串trim操作
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return str != null ? str.trim() : null;
	}

	/**
	 * 字符串trim操作
	 * 
	 * @param str
	 * @return
	 */

	/******
	 * base64解码 返回解码后的字符串
	 * 
	 * @param str
	 *            base64编码后的字符串
	 * @return
	 */
	public static String decodeBase64(String str) {
		if (str == null || str.length() == 0) {
			return "";
		} else {
			Base64 base64 = new Base64();
			try {
				byte[] debytes = base64.decode(str);
				return new String(debytes);
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	public static String sqlParaFormat(String str) {
		return str != null ? str.replaceAll("'", "''") : null;
	}

	public static String covertToUTF8(String str) {
		if (str == null) {
			return str;
		}
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}

	public static String covertToGBK(String str) {
		if (str == null) {
			return str;
		}
		try {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}

	public static Integer convertDateToInt(Date date) {
		return (int) (date.getTime() / 1000);
	}

	public static String convertDoubleToMoneyStr(Double db) {
		return convertDoubleToMoneyStr(db, 2);
	}
	public static String convertDoubleToMoneyStr(Double db, Integer precision) {
		String tmp = "00";
		int len = tmp.length();
		if (len < precision) {
			for (int i = 0; i < precision - len; i++) {
				tmp += "0";
			}
		}
		NumberFormat formater = new DecimalFormat("##0." + tmp);
		return formater.format(db);
	}
	public static String convertLongToMoneyStr(Long l) {
		return convertLongToMoneyStr(l, 2);
	}

	public static String convertLongToMoneyStr(Long l, Integer precision) {
		if (l < 100 && l > -100) {
			return convertDoubleToMoneyStr(convertLongToMoney(l, precision),
					precision);
		} else {
			String lStr = l.toString();
			int len = lStr.length();
			if (len < precision) {
				for (int i = 0; i < precision + 1 - len; i++) {
					lStr = "0" + lStr;
				}
			}
			return lStr.substring(0, lStr.length() - precision) + "."
					+ lStr.substring(lStr.length() - precision);
		}
	}
	public static Long convertMoneyStrToLong(String str) {
		str = str.replace(".", "");
		return Long.parseLong(str);
	}
	public static Integer convertMoneyStrToInt(String str) {
		str = str.replace(".", "");
		return Integer.parseInt(str);
	}

	public static String quotedStr(String source) {
		return "'" + source + "'";
	}

	public static Double convertLongToMoney(Long l) {
		return convertLongToMoney(l, 2);
	}

	public static Double convertLongToMoney(Long l, Integer precision) {
		String tmp = "00";
		int len = tmp.length();
		if (len < precision) {
			for (int i = 0; i < precision - len; i++) {
				tmp += "0";
			}
		}
		return new Double(l) / Integer.parseInt(1 + tmp);
	}

	public static Long convertMoneyToLong(Double d) {
		return (long) (d * 100);
	}

	public static Double convertIntToMoney(Integer i) {
		return new Double(i) / 100;
	}

	public static Date convertIntToDate(Integer time) {
		return new Date((long) time * 1000);
	}

	public static String convertIntToDateStr(Integer time) {
		Date date = convertIntToDate(time);
		return datePattern.format(date);
	}

	public static String convertIntToMoneyStr(Integer i) {
		return Utils.convertDoubleToMoneyStr(Utils.convertIntToMoney(i));
	}

	public static String StringFilter(String str) {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		// "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"
		String regEx = "[`~!@#$%^&*()=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——|\\\\{}【】]";
		try {
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("").trim();
		} catch (Exception e) {
			return str;
		}
	}

	/**
	 * 取得本日零点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateZero(Date date) {
		Date datez = Utils.stringToDate(DateUtil.dateToString("yyyy-MM-dd",
				date) + " 00:00:00");
		return datez;
	}

	/**
	 * 取得本日23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateTwoThree(Date date) {
		Date datez = Utils.stringToDate(DateUtil.dateToString("yyyy-MM-dd",
				date) + " 23:59:59");
		return datez;
	}

	public static String generateStrByList(List<Integer> list) {
		if (list.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * 将request参数转成Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		Enumeration<?> pNames = request.getParameterNames();
		Map<String, String> pm = new HashMap<String, String>();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			pm.put(name, request.getParameter(name));
		}
		return pm;
	}

	/**
	 * 将java实体转为Map
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getEntityMap(Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<?> clazz = obj.getClass();
		// 获取字段
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			Method method = clazz.getMethod("get"
					+ StringUtils.capitalize(name));
			Object value = method.invoke(obj);
			map.put(name, value);
		}
		return map;
	}
	
	public static Integer convertMoneyToInt(String m){
		BigDecimal bd = new BigDecimal(m);
		return bd.multiply(new BigDecimal("100")).intValue();
	}

	public static Object invokeService(Class<?> clazz, String method,
			Map<String, Object> paramMap) throws Exception {
		Method m = clazz.getDeclaredMethod(method, Map.class);
		return m.invoke(clazz.newInstance(), paramMap);
	}

	public static Object invokeService(String className, String method,
			Map<String, Object> paramMap) throws Exception {
		Class<?> clazz = Class.forName(className);
		return invokeService(clazz, method, paramMap);
	}

	public static Object invokeService(Object obj, String method,
			Map<String, Object> paramMap) throws Exception {
		Class<?> clazz = obj.getClass();
		Method m = clazz.getDeclaredMethod(method, Map.class);
		return m.invoke(obj, paramMap);
	}
}
