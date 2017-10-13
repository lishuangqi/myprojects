package com.lishuangqi.utils;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 操作时间工具类
 * 
 * @author liyao
 * 
 *         2014年11月14日 下午3:42:23
 */
public class DateUtil {

	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public final static SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final String CHINESE_DATE_FORAMT_YMD = "yyyy年MM月dd日";
	public static final String CHINAESE_DATETIME_FORMAT_YMDHMS = "yyyy年MM月dd日 HH:mm:ss";
	public static final String CHINAESE_DATETIME_FORMAT_YMDHM = "yyyy年MM月dd日HH时mm分";
	public static final String CHINAESE_WEEK_FORMAT_YW = "xxxx年xx周";
	public static final String CHINAESE_WEEK_FORMAT = "xxxxxx";
	public static final String DEFAULT_DATE_FORMAT_YMD = "yyyy-MM-dd";
	public static final String DEFAULT_DATE_FORMAT_YM = "yyyy-MM";
	public static final String DEFAULT_DATE_FORMAT_MD = "MM-dd";
	public static final String DEFAULT_DATETIME_FORMAT_YMDH = "yyyy-MM-dd HH";
	public static final String DEFAULT_DATETIME_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_DATETIME_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
	public static final String DEFAULT_DATETIME_FORMAT_MDH = "MM-dd HH";
	public static final String NOSYMBOL_DATETIME_FORMAT_YMDHMS = "yyyyMMddHHmmss";
	public static final String NOSYMBOL_DATETIME_FORMAT_YMDH = "yyyyMMddHH";
	public static final String NOSYMBOL_DATETIME_FORMAT_YMD = "yyyyMMdd";
	public static final String NOSYMBOL_TIME_FORMAT_HMS = "HH:mm:ss";
	public static final String SPRIT_DATETIME_FORMAT_YMDHMS = "yyyy/MM/dd HH:mm:ss";
	public static final String SPRIT_DATETIME_FORMAT_YMDHMSS = "yyyy/MM/dd HH:mm:ss.S";
	public static final String SPRIT_DATETIME_FORMAT_YMDHM = "yyyy/MM/dd HH:mm";
	public static final String SPRIT_DATETIME_FORMAT_YMD = "yyyy/MM/dd";
	public static final String SPRIT_DATETIME_FORMAT_YMDH = "YYYY/MM/dd HH";
	public static final String FLASH_DATETIME_FORMAT_YMDH = "yyyy,MM,dd,HH,mm,ss";
	public static final String DATE_FORMAT_HOUR = "HH:00";
	public static final int ONE_SECOND_MILLIOS = 1000;
	public static final int ONE_MINUTE_MILLIONS = 60000;
	public static final int ONE_HOUR_MILLIONS = 3600000;
	public static final int ONE_DAY_MILLIONS = 86400000;

	public DateUtil() {
	}

	public static String formatDateToString(Date date, String format) {
		if(date == null) {
			return "";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.format(date);
		}
	}

	public static String formateToString(String date, String format) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date d = formatter.parse(date);
		return formatDateToString(d, format);
	}

	public static String formatDuration(long time, String format) {
		String result = new String(format);
		int hour = (int)(time / 3600000L);
		int minute = (int)((time - 3600000L) / 60000L);
		int second = (int)((time - 3600000L - (long)(minute * '\uea60')) / 1000L);
		int millisecond = (int)(time % 1000L);
		result = result.replace("hh", String.valueOf(hour));
		result = result.replace("mm", String.valueOf(minute));
		result = result.replace("ss", String.valueOf(second));
		result = result.replace("SSS", String.valueOf(millisecond));
		return result;
	}

	public static java.sql.Date toSqlDate(Date date) {
		return date != null?new java.sql.Date(date.getTime()):null;
	}

	public static Timestamp toTimestamp(Date date) {
		return date != null?new Timestamp(date.getTime()):null;
	}

	public static Date parseDate(String string, String format) {
		Date date = null;

		try {
			if(string != null) {
				SimpleDateFormat ex = new SimpleDateFormat(format);
				date = ex.parse(string);
			}
		} catch (Exception var4) {
			;
		}

		return date;
	}

	public static Date parseDate(String string) {
		String format = "yyyy-MM-dd";
		if(string.matches("\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		if(string.matches("\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}.0")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		if(string.matches("\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}")) {
			format = "yyyy-MM-dd HH:mm";
		}

		return parseDate(string, format);
	}

	public static Date parseStringToDate(String string) {
		Date date = null;
		date = parseDate(string, "yyyy-MM-dd");
		if(date == null) {
			date = parseDate(string, "yyyy-MM-dd HH:mm");
		}

		if(date == null) {
			date = parseDate(string, "yyyy-MM-dd HH:mm:ss");
		}

		if(date == null) {
			date = parseDate(string, "yyyyMMddHHmmss");
		}

		if(date == null) {
			date = parseDate(string, "yyyy/MM/dd HH:mm:ss");
		}

		if(date == null) {
			date = parseDate(string, "yyyy/MM/dd HH:mm");
		}

		if(date == null) {
			date = parseDate(string, "yyyy/MM/dd");
		}

		return date;
	}

	public static int compareDate(String s1, String s2) {
		try {
			Date e = parseDate(s1);
			Date d2 = parseDate(s2);
			return e.compareTo(d2);
		} catch (Exception var4) {
			var4.printStackTrace();
			return -1;
		}
	}

	public static int compareDate(Date d1, Date d2) {
		try {
			return d1.compareTo(d2);
		} catch (Exception var3) {
			return -1;
		}
	}

	public static Calendar getCalendar(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal;
	}

	public static double getDiffInSecond(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		return DecimalUtil.round((double)diff * 1.0D / 1000.0D, 2);
	}

	public static int daysBetween(Date begin, Date end) {
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(begin);
		beginCalendar.set(11, 12);
		beginCalendar.set(12, 0);
		beginCalendar.set(13, 0);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		endCalendar.set(11, 12);
		endCalendar.set(12, 0);
		endCalendar.set(13, 0);
		return (int)((endCalendar.getTimeInMillis() - beginCalendar.getTimeInMillis()) / 86400000L);
	}

	public static int getYear(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(1);
	}

	public static int getMonth(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(2) + 1;
	}

	public static int getDate(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(5);
	}

	public static int getHour(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(11);
	}

	public static int getMinute(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(12);
	}

	public static int getSecond(Date date) {
		Calendar cal = getCalendar(date.getTime());
		return cal.get(13);
	}

	public static String getCurrDateTime(String pattern) {
		Date utilDate = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(utilDate);
	}

	public static Date[] getAreaOfWeek(int year, int week) {
		Date dt1 = null;
		Date dt2 = null;
		Date[] dates = new Date[2];
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(year, 0, 1, 0, 0, 0);
		int maxDay = cal.getActualMaximum(6);

		for(int i = 0; i < maxDay; ++i) {
			if(cal.get(3) == week) {
				if(dt1 == null) {
					dt1 = cal.getTime();
				}

				dt2 = cal.getTime();
			}

			if(cal.get(3) > week) {
				break;
			}

			cal.add(6, 1);
		}

		dates[0] = dt1;
		dates[1] = dt2;
		return dates;
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0?true:year % 100 == 0 && year % 400 == 0;
	}

	public static String getNDayBeforeDateStr(int nday, String pattern) {
		long Current_Time_Millions = System.currentTimeMillis();
		SimpleDateFormat datetimeFormat = new SimpleDateFormat(pattern);
		String nDayBefore = datetimeFormat.format(new Date(Current_Time_Millions - (long)(86400000 * nday)));
		return nDayBefore;
	}

	public static String getNDayBeforeDateStr(int nday) {
		return getNDayBeforeDateStr(nday, "yyyy年MM月dd日 HH:mm:ss");
	}

	public static String getNDayBeforeOnlyDateStr(int nday) {
		return getNDayBeforeDateStr(nday, "yyyy年MM月dd日");
	}

	public static String getAfterDay(String date, int aday, String pattern) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date d = dateFormat.parse(date);
		return dateFormat.format(new Date(d.getTime() + (long)(86400000 * aday)));
	}

	public static String getDayOfWeek(String dateStr) {
		Date date = null;
		Calendar calendar = null;
		String dayOfWeek = "";
		if(dateStr.lastIndexOf(" ") == -1) {
			dateStr = dateStr + " 00:00:00";
		}

		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			date = e.parse(dateStr);
			calendar = Calendar.getInstance();
			calendar.setTime(date);
			switch(calendar.get(7) - 1) {
				case 0:
					dayOfWeek = "星期日";
					break;
				case 1:
					dayOfWeek = "星期一";
					break;
				case 2:
					dayOfWeek = "星期二";
					break;
				case 3:
					dayOfWeek = "星期三";
					break;
				case 4:
					dayOfWeek = "星期四";
					break;
				case 5:
					dayOfWeek = "星期五";
					break;
				case 6:
					dayOfWeek = "星期六";
					break;
				default:
					dayOfWeek = "星期日";
			}
		} catch (ParseException var5) {
			var5.printStackTrace();
		}

		return dayOfWeek;
	}

	public static String getDistanceDate(String date, int monthCount, String pattern) throws Exception {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(parseDate(date, pattern));
		return formatDateToString(getAfterMonth(gc, monthCount), pattern);
	}

	public static String getDistanceDate(String date, int monthCount) throws Exception {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(parseDate(date));
		return formatDateToString(getAfterMonth(gc, monthCount), "yyyy年MM月dd日");
	}

	public static Date getAfterMonth(GregorianCalendar g, int monthNum) {
		GregorianCalendar gc = (GregorianCalendar)g.clone();
		gc.add(2, monthNum);
		return gc.getTime();
	}

	public static int getDateYearDiff(Date dates) {
		if(dates != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dates);
			int yearBirth = cal.get(1);
			Calendar cal2 = Calendar.getInstance();
			int yearNow = cal2.get(1);
			cal2.set(1, yearBirth);
			return cal2.before(cal)?yearNow - yearBirth - 1:yearNow - yearBirth;
		} else {
			return 0;
		}
	}

	public static Date getBeforeYear(int nyear) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1) - nyear;
		cal.set(1, year);
		return cal.getTime();
	}

	public static String getTimeInterval(long messageTime) {
		long interval = (new Date()).getTime() - messageTime;
		long day = interval / 86400000L;
		String time = null;
		if(day >= 0L && day < 1L) {
			int hour = (int)interval / 3600000;
			switch(hour) {
				case 0:
					time = interval / 60000L + "分钟前";
					break;
				case 1:
					time = "一小时前";
					break;
				case 2:
					time = "两小时前";
					break;
				case 3:
					time = "三小时前";
					break;
				case 4:
					time = "四小时前";
					break;
				case 5:
					time = "五小时前";
					break;
				case 6:
					time = "六小时前";
					break;
				case 7:
					time = "七小时前";
					break;
				case 8:
					time = "八小时前";
					break;
				case 9:
					time = "九小时前";
					break;
				case 10:
					time = "十小时前";
					break;
				case 11:
					time = "十一小时前";
					break;
				case 12:
					time = "十二小时前";
					break;
				case 13:
					time = "十三小时前";
					break;
				case 14:
					time = "十四小时前";
					break;
				case 15:
					time = "十五小时前";
					break;
				case 16:
					time = "十六小时前";
					break;
				case 17:
					time = "十七小时前";
					break;
				case 18:
					time = "十八小时前";
					break;
				case 19:
					time = "十九小时前";
					break;
				case 20:
					time = "二十小时前";
					break;
				case 21:
					time = "二一小时前";
					break;
				case 22:
					time = "二十二小时前";
					break;
				case 23:
					time = "二十三小时前";
			}
		} else if(day >= 1L && day < 30L) {
			time = interval / 86400000L + "天前";
		} else if(day >= 30L && day < 60L) {
			time = "一个月前";
		} else if(day >= 60L && day < 90L) {
			time = "二个月前";
		} else if(day >= 90L && day < 120L) {
			time = "三个月前";
		} else if(day >= 120L) {
			time = "更早以前";
		}

		return time;
	}

	public static int getCurrentMonthDay() {
		Calendar a = Calendar.getInstance();
		a.set(5, 1);
		a.roll(5, -1);
		int maxDate = a.get(5);
		return maxDate;
	}

	public static int getDaysByYearMonth(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(1, year);
		a.set(2, month - 1);
		a.set(5, 1);
		a.roll(5, -1);
		int maxDate = a.get(5);
		return maxDate;
	}

	public static String getDayOfWeekByDate(String date) {
		String dayOfweek = "-1";

		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
			Date myDate = e.parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("E");
			String str = formatter.format(myDate);
			dayOfweek = str;
		} catch (Exception var6) {
			System.out.println("错误!");
		}

		return dayOfweek;
	}

	public static List<Date> getDates(int workDayCount) {
		ArrayList dates = new ArrayList();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		for(; dates.size() < workDayCount; cal.add(5, 1)) {
			int day = cal.get(7);
			if(day != 1 && day != 7) {
				dates.add((Date)cal.getTime().clone());
			}
		}

		return dates;
	}

	public static String formatByMillis(long millis, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return formatter.format(calendar.getTime());
	}

	public static Date getDateFromMonthFirstDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(5, c.getActualMinimum(5));
		return c.getTime();
	}

	public static Date getDateFromMonthLastDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(5, c.getActualMaximum(5));
		return c.getTime();
	}

	public static boolean isTimeBetweenTime(Date date, Date beginDate, Date endDate) {
		boolean isBetween = false;
		if(date != null) {
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.setTime(date);
			currentCalendar.set(2014, 1, 1);
			Calendar beginCalendar = Calendar.getInstance();
			beginCalendar.setTime(beginDate);
			beginCalendar.set(2014, 1, 1);
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(endDate);
			endCalendar.set(2014, 1, 1);
			if(currentCalendar.getTime().after(beginCalendar.getTime()) && currentCalendar.getTime().before(endCalendar.getTime())) {
				isBetween = true;
			}
		}

		return isBetween;
	}

	public static boolean before(Date startTime, Date endTime) {
		if(startTime != null && endTime != null) {
			Calendar start_cal = Calendar.getInstance();
			start_cal.setTime(startTime);
			Calendar end_cal = Calendar.getInstance();
			end_cal.setTime(endTime);
			return start_cal.before(end_cal);
		} else {
			return false;
		}
	}

	/**
	 * 和当前时间比较大小
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param date
	 *            -- 需要比较时间
	 * @return -1,0,1
	 * @throws ParseException
	 */
	public static int compareToNow(String pattern, String date)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(format.parse(date));
		ca1.setTime(format.parse(getNowDate(pattern)));
		return ca.compareTo(ca1);
	}

	/**
	 * 两个时间相比较
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param date1
	 * @param date2
	 * @return -1,0,1
	 * @throws ParseException
	 */
	public static int dateCompare(String pattern, String date1, String date2)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(format.parse(date1));
		ca1.setTime(format.parse(date2));
		return ca.compareTo(ca1);
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param minDte
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(String pattern, String minDte,
			String maxDate, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String strDate = "";
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		if ("now".equalsIgnoreCase(date)) {
			strDate = getNowDate(pattern);
		} else {
			strDate = date;
		}
		ca.setTime(format.parse(minDte));
		ca1.setTime(format.parse(strDate));
		int min = ca.compareTo(ca1);
		ca.setTime(format.parse(strDate));
		ca1.setTime(format.parse(maxDate));
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param minDte
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(String pattern, Date minDate,
			Date maxDate, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String strDate = "";
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		if ("now".equalsIgnoreCase(date)) {
			strDate = getNowDate(pattern);
		} else {
			strDate = date;
		}
		ca.setTime(minDate);
		ca1.setTime(format.parse(strDate));
		int min = ca.compareTo(ca1);
		ca.setTime(format.parse(strDate));
		ca1.setTime(maxDate);
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param minDte
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(Date minDate, Date maxDate, Date date)
			throws ParseException {
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(minDate);
		ca1.setTime(date);
		int min = ca.compareTo(ca1);
		ca.setTime(date);
		ca1.setTime(maxDate);
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得当前时间
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @return
	 */
	public static String getNowDate(String pattern) {
		if (StringUtils.isBlank(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}

	/**
	 * 把时间转化为自定义格式
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将时间转为int
	 * 
	 * @param date
	 * @return
	 */
	public static int convertDateToInt(Date date) {
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 把Int转为Date
	 * 
	 * @param time
	 * @return
	 */
	public static Date convertIntToDate(Integer time) {
		return new Date((long) time * 1000);
	}

	/**
	 * 自定义格式把String转为Date类型
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String pattern, String date)
			throws ParseException {

		if (StringUtils.isBlank(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(date);
	}

	/**
	 * 获取相对于当前时间的任意时间
	 * 
	 * @param date
	 * @param interval
	 *            小时
	 * @throws ParseException
	 */
	public static Date getAnyTime(Date date, int interval)
			throws ParseException {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.HOUR_OF_DAY, interval);
		return cl.getTime();

	}

	/**
	 * 对两个时间进行拼接
	 * 
	 * @param date1
	 *            -- 时间1
	 * @param pattern1
	 *            -- 时间1的格式
	 * @param date2
	 *            -- 时间2
	 * @param pattern2
	 *            --时间2的格式
	 * @return date1+date2
	 */
	public static String DateJoin(Date date1, String pattern1, Date date2,
			String pattern2) {
		SimpleDateFormat format1 = new SimpleDateFormat(pattern1);
		SimpleDateFormat format2 = new SimpleDateFormat(pattern2);
		String str = format1.format(date1) + " " + format2.format(date2);
		return str;
	}

	/**
	 * 返回date1到date2之间所有为星期week-1的时间
	 * 
	 * @param date1
	 * @param date2
	 * @param week
	 *            -- 周几（Calendar.WEDNESDAY，TUESDAY...）
	 * @return
	 * @throws ParseException
	 */
	public static List<Date> getDateOfWeek(Date date1, Date date2, int week)
			throws ParseException {
		int day = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
		Calendar cal = Calendar.getInstance();
		List<Date> dates = new ArrayList<Date>();
		for (int i = 0; i < day; i++) {
			Date date = getAnyTime(date1, 24 * i);
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) == week) {
				dates.add(date);
			}
		}
		return dates;
	}

	/**
	 * 获取 firstDate 到 lastDate 之间每个月的 start号和end号
	 * (start,end的范围为1-31，如果某月不足31那么最大为当月的最后一天)
	 * 
	 * @param firstDate
	 * @param lastDate
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static Map<Date, Date> getDateOfMonth(Date firstDate, Date lastDate,
			int start, int end) throws ParseException {
		Map<Date, Date> map = new LinkedHashMap<Date, Date>();
		Calendar cal = Calendar.getInstance();
		Date startDate = null;
		Date endDate = null;
		int min = start >= end ? end : start;
		int max = start >= end ? start : end;
		cal.setTime(firstDate);
		if (min < cal.getActualMinimum(Calendar.DAY_OF_MONTH)) {
			min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		}
		if (max > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		cal.set(Calendar.DAY_OF_MONTH, min);
		startDate = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, max);
		endDate = cal.getTime();
		map.put(startDate, endDate);
		while (true) {
			min = start >= end ? end : start;
			max = start >= end ? start : end;
			cal.set(Calendar.DAY_OF_MONTH,
					cal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1);
			Date temp = cal.getTime();
			cal.setTime(temp);
			if (min < cal.getActualMinimum(Calendar.DAY_OF_MONTH)) {
				min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
			}
			if (max > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			}
			cal.set(Calendar.DAY_OF_MONTH, min);
			startDate = cal.getTime();
			cal.set(Calendar.DAY_OF_MONTH, max);
			endDate = cal.getTime();
			if (compareToScope(firstDate, lastDate, startDate)) {
				map.put(startDate, endDate);
			} else {
				break;
			}
		}
		return map;
	}

	/**
	 * 取得时间，精确到分，秒为0
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getTimeInMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.SECOND, 0);
		return convertDateToInt(c.getTime());
	}

	/**
	 * 把String时间类型转为Integer
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Integer convertStrDateToInt(String pattern, String date)
			throws ParseException {
		if (StringUtils.isBlank(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		Date d = convertStringToDate(pattern, date);
		return convertDateToInt(d);
	}

	/**
	 * 把Integer时间类型转为String
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String convertIntDateToStr(String pattern, Integer date)
			throws ParseException {
		if (pattern == null || "".equals(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		Date d = convertIntToDate(date);
		return dateToString(pattern, d);
	}

	/**
	 * 取得当前时间戳
	 * 
	 * @return
	 */
	public static Integer nowTimestamp() {
		return convertDateToInt(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return
	 */
	public static String nowDateStr() {
		return datePattern.format(new Date());
	}
}
