package com.jjjl.util;

import java.text.DecimalFormat;

/**
 * 格式化float默认保留三位小数
 * 
 * @author Administrator
 * 
 */
public class NumberFormat {

	private static DecimalFormat defaultFormat = new DecimalFormat("0.000");

	public NumberFormat() {
		
	}

	/**
	 * 以默认模式格式化float
	 * 
	 * @param value
	 * @return String
	 */
	public static String format(float value) {
		return defaultFormat.format(value);
	}

	/**
	 * 以指定模式格式化float
	 * 
	 * @param value
	 * @param pattern
	 * @return String
	 */
	public static String format(float value, String pattern) {
		DecimalFormat formatter = new DecimalFormat(pattern);
		return formatter.format(value);
	}
	
	/**
	 * 以默认格式格式化double
	 * 
	 * @param double value
	 * @return String
	 */
	public static String format(double value) {
		return defaultFormat.format(value);
	}

	/**
	 * 以指定的格式格式化double
	 * 
	 * @param value
	 * @param pattern
	 * @return String
	 */
	public static String format(double value, String pattern) {
		DecimalFormat formatter = new DecimalFormat(pattern);
		return formatter.format(value);
	}
	
	/**
	 * 以指定格式将字符串解析为int
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static int parseInt(String text, String pattern) throws Exception {
		DecimalFormat formatter = new DecimalFormat(pattern);
		return formatter.parse(text).intValue();
	}
	
	/**
	 * 以指定格式将字符串解析为double
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static double parseDouble(String text, String pattern) throws Exception {
		DecimalFormat formatter = new DecimalFormat(pattern);
		return formatter.parse(text).doubleValue();
	}
}
