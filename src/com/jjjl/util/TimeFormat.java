package com.jjjl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

	private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
	private static final String TIME_FORMAT_STRING = "HH:mm:ss";
	private static final String TIMESTAMP_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	
	
	private static SimpleDateFormat defaultFormat = new SimpleDateFormat(TIMESTAMP_FORMAT_STRING);

	public static void setFormatString(String pattern) {
		defaultFormat.applyPattern(pattern);
	}

	/**
	 * 默认格式化日
	 * 
	 * @param Date date
	 * @return String
	 */
	public static String format(Date date) {
		return defaultFormat.format(date);
	}
	
	/**
	 * 日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return TimeFormat.format(date, DATE_FORMAT_STRING);
	}
	
	/**
	 * 时间格式
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		return TimeFormat.format(date, TIME_FORMAT_STRING);
	}
	
	/**
	 * 时间戳格式化
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTimestamp(Date date) {
		return TimeFormat.format(date, TIMESTAMP_FORMAT_STRING);
	}

	/**
	 * 以指定模式格式化日期
	 * 
	 * @param Date date
	 * @param String pattern
	 * @return String
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	
	/**
	 * 解析日期字符
	 * 
	 * @param String source
	 * @return Date
	 * 
	 * @throws ParseException
	 */
	public static Date parse(String source) throws ParseException {
		return defaultFormat.parse(source);
	}

	/**
	 * 以指定模式解析日
	 * 
	 * @param String source
	 * @param String pattern
	 * @return Date
	 * 
	 * @throws ParseException
	 */
	public static Date parse(String source, String pattern) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(source);
	}
}
