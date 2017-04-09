package com.albert.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/***
	 * 将字符串转换成日期，如果格式不合法，返回NULL
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertStringToDate(String date) {
		Date rd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		try {
			rd = sdf.parse(date);
		} catch (ParseException e) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				rd = sdf1.parse(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				rd = null;
			}
		}
		return rd;
	}

	/***
	 * 将字符串转换成日期，如果格式不合法，返回NULL
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertDate(String date) {
		Date rd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		try {
			rd = sdf.parse(date);
		} catch (ParseException e) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				rd = sdf1.parse(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				rd = null;
			}
		}
		return rd;
	}

	/***
	 * 将日期去掉小时，格式化为yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String beginDate = sdf.format(date);
		String beginFormatDate = beginDate + " 00:00:00";
		try {
			date = sdf1.parse(beginFormatDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getTrDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String trDate = null;
		try {
			trDate = sdf1.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trDate;
	}

	/***
	 * 将日期格式的字符串转换成日期格式并格式化为yyyy-mm-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginDate(String date) {
		return getBeginDate(convertStringToDate(date));
	}

	/***
	 * 将日期格式的对象转换成日期类型，并格式化成yyyy-mm-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginDate(Object date) {
		String value = date.toString();
		return getBeginDate(convertStringToDate(value));
	}

	/***
	 * 将日期格式化为yyyy-MM-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String beginDate = sdf.format(date);
		String beginFormatDate = beginDate + " 23:59:59";
		try {
			date = sdf1.parse(beginFormatDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/***
	 * 将日期型的字符串转换成日期格式并格式化为yyyy-mm-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDate(String date) {
		return getEndDate(convertStringToDate(date));
	}

	/***
	 * 将日期型的对象转换成日期格式并格式化为yyyy-mm-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDate(Object date) {
		String value = date.toString();
		return getEndDate(convertStringToDate(value));
	}

	public static Date convertStringToDate2(String date) {
		Date rd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// try {
		// rd = sdf.parse(date);
		// } catch (ParseException e) {
		// SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		// try {
		// rd = sdf1.parse(date);
		// } catch (ParseException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// rd=null;
		// }
		// }
		// return rd;
		try {
			rd = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rd;
	}

	/**
	 * 转化成需要的格式
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 * @throws ParseException
	 */
	public static Date simpleDateForDate(Date date, String dateFormat)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.parse(sdf.format(date));
	}

}