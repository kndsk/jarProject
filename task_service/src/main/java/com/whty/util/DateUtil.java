package com.whty.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	private final static SimpleDateFormat sqlDateFormatYMDS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private final static SimpleDateFormat sqlDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 将Date格式化为指定字符串形式
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static final String format(String pattern, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将日期格式化为'yyyy-MM-dd'
	 * 
	 * @param date
	 * @return
	 */
	public static final String format2Short(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	/**
	 * 得到当前的月份字符串
	 */
	public static String getCurrentMonth() {
		Calendar cald = Calendar.getInstance();
		int month = cald.get(Calendar.MONTH);
		if (month >= 9) {
			return String.valueOf(month + 1);
		} else {
			return "0" + String.valueOf(month + 1);
		}
	}

	/**
	 * 得到当前的年字符串
	 */
	public static int getCurrentIntYear() {
		Calendar cald = Calendar.getInstance();
		int year = cald.get(Calendar.YEAR);
		return year;

	}

	/**
	 * 得到当前的年字符串
	 */
	public static int getCurrentIntMonth() {
		Calendar cald = Calendar.getInstance();
		int month = cald.get(Calendar.MONTH);
		return month + 1;

	}

	public static java.sql.Date getSysDate() {
		Date date = new Date();
		String strDate = sqlDateFormatYMDS.format(date);

		try {
			return new java.sql.Date(sqlDateFormat.parse(strDate).getTime());
		} catch (ParseException e) {

			e.printStackTrace();
			return new java.sql.Date(0);
		}

	}

	/*
	 * yyyy-mm-dd
	 */
	public static String getSqlDayFormatYMDS(java.util.Date date) {
		if (date != null) {
			return sqlDateFormatYMDS.format(date);
		} else {
			return null;
		}
	}

	/**
	 * 将字符串解析为Date型数据, 指定format格式
	 * 
	 * @param dateString
	 *            Date数据的字符串表示
	 * @return 解析得到的Date型数据
	 */
	public final static Date format(String dateString, String format)

	{
		if (null == format || format.equals(""))
			format = "yyyy-MM-dd";
		if (null == dateString || dateString.equals(""))
			return null;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {

			date = formatter.parse(dateString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static java.sql.Date getDateFromStr(String timeStr) {
		try {
			return new java.sql.Date(sqlDateFormat.parse(timeStr).getTime());
		} catch (Exception e) {
			return new java.sql.Date(0);
		}
	}

	/**
	 * 返回时分秒被清空的相对日期
	 * 
	 * @param dateTime
	 * @param day
	 *            , 相对天数，-1前一天，1后一天
	 */
	public static Date getClearToDate(Date dateTime, int day) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.set(Calendar.HOUR_OF_DAY, 0);
		cald.set(Calendar.MINUTE, 0);
		cald.set(Calendar.SECOND, 0);
		cald.set(Calendar.MILLISECOND, 0);
		if (day != 0)
			cald.add(Calendar.DAY_OF_MONTH, day);

		return cald.getTime();
	}

	/**
	 * 返回相对日期
	 */
	public static Date getDate(Date dateTime, int day) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.DAY_OF_MONTH, day);

		return cald.getTime();
	}

	/**
	 * 返回相对日期
	 */
	public static Date getDateByMonth(Date dateTime, int month) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.MONTH, month);

		return cald.getTime();
	}

	/**
	 * 返回相对日期
	 */
	public static Date getDateAddDay(Date dateTime, int day) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.DAY_OF_YEAR, day);
		return cald.getTime();
	}

	/**
	 * 返回相对日期
	 */
	public static Date getDate(String dateStr) {
		int length = dateStr.length();
		int addNum = 2;
		for (int i = 0; i < 7 - length - 2; i++) {
			addNum = addNum * 10;
		}
		String date6Str = addNum + dateStr;
		return getDate(date6Str, "yyyyMM");
	}

	public static Date getDate(String dateStr, String formatter) {
		try {
			SimpleDateFormat sdF = new SimpleDateFormat(formatter);
			return sdF.parse(dateStr);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 获得年份
	 */
	public static int getDateYear(Date dateTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		return cal.get(Calendar.YEAR);
		// return dateTime.getYear() + 1900 ;
	}

	/**
	 * 获得月份 0-11
	 */
	public static int getDateMonth(Date dateTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		return cal.get(Calendar.MONTH);
		// return dateTime.getMonth() ;
	}

	/**
	 * 获得月份 0-11
	 */
	public static int getDateDay(Date dateTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		return cal.get(Calendar.DAY_OF_MONTH);
		// return dateTime.getDate() ;
	}

	/**
	 * month 1-11
	 */
	public static String get3DateStr(int year, int month) {
		String sReturn = "";
		// 获得年的最后一位
		sReturn = String.valueOf(year % 10);
		// 获得月的2位
		sReturn += getMonthStr(month + 1);
		return sReturn;
	}

	/**
	 * month 1-11
	 */
	public static String get3DateStr(Date date) {
		String sReturn = "";
		int year = getDateYear(date);
		int month = getDateMonth(date);
		// 获得年的最后一位
		sReturn = String.valueOf(year % 10);
		// 获得月的2位
		sReturn += getMonthStr(month + 1);
		return sReturn;
	}

	/**
	 * 获得月的日期 month 1-12
	 */
	public static String getMonthStr(int month) {
		if (month < 10) {
			return "0" + month;
		} else {
			return String.valueOf(month);
		}
	}

	/**
	 * 返回相对日期
	 */
	public static Date getDateAddMonth(Date dateTime, int month) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.MONTH, month);
		return cald.getTime();
	}

	/**
	 * 返回时分秒被清空的绝对日期
	 * 
	 * @param year
	 * @param month
	 *            0-11, 0 means Jan,1 means Feb, 2 means March...
	 * @return Date year-month-1 with clean zero hour,minute,second,miliSec
	 */
	public static Date getDate(int year, int month) {
		return getDateTime(year, month, 1);
	}

	/**
	 * 返回相对季度
	 */
	public static String getQuarter(int year, int month) {
		int quarter = month / 3 + 1;
		return year + "" + quarter;
	}

	/**
	 * 返回相对季度
	 */
	public static String getQuarter(Date dateTime) {
		return getQuarter(DateUtil.getDateYear(dateTime),
				DateUtil.getDateMonth(dateTime));
	}

	/**
	 * 返回相对季度
	 */
	public static int getQuarterNum(Date dateTime) {
		return DateUtil.getDateMonth(dateTime) / 3 + 1;
	}

	public static String getQuarter(String quarter, int add) {
		if (quarter.length() == 5) {
			int year = Integer.parseInt(quarter.substring(0, 4));
			int quarter2 = Integer.parseInt(quarter.substring(4));

			int quaterToatal = year * 4 + quarter2 + add;

			int retYear = (quaterToatal - 1) / 4;
			int retQuarter = quaterToatal - retYear * 4;
			return retYear + "" + retQuarter;
		}
		return "";
	}

	public static String getQuarterFormatStr(String quarter) {
		if (quarter.length() == 5) {
			int year = Integer.parseInt(quarter.substring(0, 4));
			int quarter2 = Integer.parseInt(quarter.substring(4));
			return year + "年" + quarter2 + "季度";
		}
		return "";
	}

	public static String getQuarterFormatStr(Date dateTime) {
		int year = DateUtil.getDateYear(dateTime);
		int month = DateUtil.getDateMonth(dateTime);
		return getQuarterFormatStr(DateUtil.getQuarter(year, month));
	}

	public static Date getDateByQuarter(String quarterStr) {
		if (quarterStr.length() == 5) {
			int year = Integer.parseInt(quarterStr.substring(0, 4));
			int quarter = Integer.parseInt(quarterStr.substring(4));
			int month = (quarter - 1) * 3;
			return DateUtil.getDate(year, month);
		}

		return null;
	}

	/**
	 * java.util.Date --> java.sql.Date
	 */
	public static java.sql.Date convertSqlDate(java.util.Date dateTime) {
		if (dateTime == null)
			return null;
		else
			return new java.sql.Date(dateTime.getTime());
	}

	/**
	 * java.sql.Date --> java.util.Date
	 */
	public static java.util.Date convertUtilDate(java.sql.Date dateTime) {
		if (dateTime == null)
			return null;
		else
			return new java.util.Date(dateTime.getTime());
	}

	/**
	 * java.sql.Timestamp --> java.util.Date
	 */
	public static java.util.Date convertUtilDate(java.sql.Timestamp dateTime) {
		if (dateTime == null)
			return null;
		else
			return new Date(dateTime.getTime());
	}

	/**
	 * java.util.Date --> java.sql.Timestamp
	 */
	public static java.sql.Timestamp convertUtilTimestamp(
			java.util.Date dateTime) {
		if (dateTime == null)
			return null;
		else
			return new java.sql.Timestamp(dateTime.getTime());
	}

	/**
	 * 日期转换 parse Date to string type
	 * 
	 * @param dateTime
	 *            Date
	 * @param formatter
	 *            String 日期格式
	 * @return String
	 */
	public static String dateFormat(Date dateTime, String formatter) {
		if (dateTime == null)
			return null;
		SimpleDateFormat sdF = new SimpleDateFormat(formatter);
		return sdF.format(dateTime);
		// return null ;
	}

	/**
	 * 日期转换 yyyy-mm-dd
	 * 
	 * @param dateTime
	 *            Date
	 * @return String
	 */
	public static String dateStardandFormat(Date dateTime) {
		return dateFormat(dateTime, "yyyy-MM-dd");
	}

	/**
	 * 日期转换 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateTime
	 *            Date
	 * @return String
	 */
	public static String dateFullFormat(Date dateTime) {
		return dateFormat(dateTime, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回时分秒被清空的绝对日期
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return Date year-month-date with clean zero hour,minute,second,milisec
	 */
	public static Date getDateTime(int year, int month, int date) {
		Calendar cald = Calendar.getInstance();
		cald.set(year, month, date, 0, 0, 0);
		cald.set(Calendar.MILLISECOND, 0);
		return cald.getTime();
	}

	public static String get3Date_old(String dateStr, int add) {
		if (dateStr.length() == 3) {
			int year = Integer.parseInt(dateStr.substring(0, 1));
			int month = Integer.parseInt(dateStr.substring(1));

			return DateUtil.get3DateStr(2000 + year, month);

		}
		return "";
	}

	public static String get3Date(String dateStr, int add) {
		if (dateStr.length() == 3) {
			int year = Integer.parseInt(dateStr.substring(0, 1));
			int month = Integer.parseInt(dateStr.substring(1));

			Date date1 = DateUtil.getDate(2000 + year, month - 1);

			Date date2 = DateUtil.getDateAddMonth(date1, add);
			return DateUtil.get3DateStr(date2);

		}
		return "";
	}

	public static Date get3Date(String dateStr) {
		if (dateStr.length() == 3) {
			int year = Integer.parseInt(dateStr.substring(0, 1));
			int month = Integer.parseInt(dateStr.substring(1));

			return DateUtil.getDate(2000 + year, month - 1);

		}
		return null;
	}

	/**
	 * Get days for current month
	 * 
	 * @param date
	 *            current date
	 * @return
	 */
	public static int getDaysForCurrentMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		Date nextMonthDate = getDateByMonth(date, 1);

		calendar.set(nextMonthDate.getYear(), nextMonthDate.getMonth(), 1);
		Date nextMonthFirstDate = calendar.getTime();
		Date thisMonthLastDate = getDate(nextMonthFirstDate, -1);

		return getDateDay(thisMonthLastDate);
	}

	/**
	 * 将String类型转换为DATE类型 Symbol Meaning Presentation Example ------ -------
	 * ------------ ------- G era designator (Text) AD y year (Number) 1996 M
	 * month in year (Text & Number) July & 07 d day in month (Number) 10 h hour
	 * in am/pm (1~12) (Number) 12 H hour in day (0~23) (Number) 0 m minute in
	 * hour (Number) 30 s second in minute (Number) 55 S millisecond (Number)
	 * 978 E day in week (Text) Tuesday D day in year (Number) 189 F day of week
	 * in month (Number) 2 (2nd Wed in July) w week in year (Number) 27 W week
	 * in month (Number) 2 a am/pm marker (Text) PM k hour in day (1~24)
	 * (Number) 24 K hour in am/pm (0~11) (Number) 0 z time zone (Text) Pacific
	 * Standard Time ' escape for text (Delimiter) '' single quote (Literal) '
	 * 
	 * @param value
	 *            String type
	 * @param type
	 *            example "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"
	 * @return
	 */
	public static Date DateConvert(Object value, String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		if (value == null)
			return null;
		if (((String) value).trim().length() == 0)
			return null;
		try {
			return df.parse((String) value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到当前日期的上月
	 * 
	 * @return newDate上一年月
	 * @throws null
	 */
	public static String getAheadMonth() {

		int year = getCurrentIntYear();
		int month = getCurrentIntMonth();
		if (month == 1) {
			month = 12;
			year -= 1;
		} else {
			month -= 1;
		}
		String newYear = String.valueOf(year);
		String newMonth = String.valueOf(month);
		return newYear + newMonth;

	}

	/**
	 * 得到当前日期的上月
	 * 
	 * @return newDate上一年月
	 * @throws null
	 */
	public static String[] getAheadMonth(String _year, String _month) {

		int year = Integer.parseInt(_year);
		int month = Integer.parseInt(_month);
		if (month == 1) {
			month = 12;
			year -= 1;
		} else {
			month -= 1;
		}

		return new String[] { year + "", month + "" };

	}

	/**
	 * 在日期上增加数个整月
	 * 
	 * @return Date
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();

	}

	/**
	 * 在日期上增加小时
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addHour(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, n);
		return cal.getTime();

	}

	public static int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public static int compareDate(Date dt1, Date dt2) {
		try {

			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 把时间戳转成时间
	 * @param timestamp
	 * @return String
	 */
	public static String getDateStrFromTimestamp(String timestamp) {
		String d = "";
		if(StringUtils.isNotBlank(timestamp)){
			Date date = new Date(Long.parseLong(timestamp));
			d = format("yyyy-MM-dd HH:mm:ss SSS", date);
		}
		return d;

	}
	
	/**
	 * 把时间戳转成时间
	 * @param timestamp
	 * @return Date
	 */
	public static Date getDateFromTimestamp(String timestamp) {
		Date date = new Date(Long.parseLong(timestamp));
		return date;

	}
	
	
	
	/**
	 * 返回时分秒被清空的相对日期时间戳
	 * 
	 * @param dateTime
	 * @param day
	 * @param digit 时间戳长度
	 *            , 相对天数，-1前一天，1后一天
	 */
	public static String getClearToTimestamp(Date dateTime, int day, int digit) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.set(Calendar.HOUR_OF_DAY, 0);
		cald.set(Calendar.MINUTE, 0);
		cald.set(Calendar.SECOND, 0);
		cald.set(Calendar.MILLISECOND, 0);
		if (day != 0)
			cald.add(Calendar.DAY_OF_MONTH, day);
		
		
		Long time = cald.getTime().getTime();
		String timestamp = time.toString();
 
		if(digit == 10){
			timestamp = timestamp.substring(0, 10);
		}

		return timestamp;
	}

}