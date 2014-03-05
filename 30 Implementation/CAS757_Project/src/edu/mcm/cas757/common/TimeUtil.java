package edu.mcm.cas757.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类名：TimeUtil.java 类描述：时间处理工具
 * 
 * @author wader 创建时间�?011-12-02 11:03
 */
public class TimeUtil {
	public final static String FORMAT_DATE = "yyyy-MM-dd";
	public final static String FORMAT_TIME = "hh:mm";
	public final static String FORMAT_DATE_TIME = "yyyy-MM-dd hh:mm";
	public final static String FORMAT_MONTH_DAY_TIME = "MM月dd�?hh:mm";
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private static final int YEAR = 365 * 24 * 60 * 60;// �?
	private static final int MONTH = 30 * 24 * 60 * 60;// �?
	private static final int DAY = 24 * 60 * 60;// �?
	private static final int HOUR = 60 * 60;// 小时
	private static final int MINUTE = 60;// 分钟

	/**
	 * 根据时间戳获取描述�?时间，如3分钟前，1天前
	 * 
	 * @param timestamp
	 *            时间�?单位为毫�?
	 * @return 时间字符�?
	 */
	public static String getDescriptionTimeFromTimestamp(long timestamp) {
		long currentTime = System.currentTimeMillis();
		long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒�?
//		System.out.println("timeGap: " + timeGap);
		String timeStr = null;
		if (timeGap > YEAR) {
			timeStr = timeGap / YEAR + "年前";
		} else if (timeGap > MONTH) {
			timeStr = timeGap / MONTH + "个月�?";
		} else if (timeGap > DAY) {// 1天以�?
			timeStr = timeGap / DAY + "天前";
		} else if (timeGap > HOUR) {// 1小时-24小时
			timeStr = timeGap / HOUR + "小时�?";
		} else if (timeGap > MINUTE) {// 1分钟-59分钟
			timeStr = timeGap / MINUTE + "分钟�?";
		} else {// 1秒钟-59秒钟
			timeStr = "刚刚";
		}
		return timeStr;
	}

	/**
	 * 根据时间戳获取指定格式的时间，如2011-11-30 08:40
	 * 
	 * @param timestamp
	 *            时间�?单位为毫�?
	 * @param format
	 *            指定格式 如果为null或空串则使用默认格式"yyyy-MM-dd HH:MM"
	 * @return
	 */
	public static String getFormatTimeFromTimestamp(long timestamp, String format) {
		if (format == null || format.trim().equals("")) {
			sdf.applyPattern(FORMAT_DATE);
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			int year = Integer.valueOf(sdf.format(new Date(timestamp)).substring(0, 4));
			System.out.println("currentYear: " + currentYear);
			System.out.println("year: " + year);
			if (currentYear == year) {// 如果为今年则不显示年�?
				sdf.applyPattern(FORMAT_MONTH_DAY_TIME);
			} else {
				sdf.applyPattern(FORMAT_DATE_TIME);
			}
		} else {
			sdf.applyPattern(format);
		}
		Date date = new Date(timestamp);
		return sdf.format(date);
	}

	/**
	 * 根据时间戳获取时间字符串，并根据指定的时间分割数partionSeconds来自动判断返回描述�?时间还是指定格式的时�?
	 * 
	 * @param timestamp
	 *            时间�?单位是毫�?
	 * @param partionSeconds
	 *            时间分割线，当现在时间与指定的时间戳的秒数差大于这个分割线时则返回指定格式时间，否则返回描述性时�?
	 * @param format
	 * @return
	 */
	public static String getMixTimeFromTimestamp(long timestamp, long partionSeconds, String format) {
		long currentTime = System.currentTimeMillis();
		long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒�?
		if (timeGap <= partionSeconds) {
			return getDescriptionTimeFromTimestamp(timestamp);
		} else {
			return getFormatTimeFromTimestamp(timestamp, format);
		}
	}

	/**
	 * 获取当前日期的指定格式的字符�?
	 * 
	 * @param format
	 *            指定的日期时间格式，若为null�?"则使用指定的格式"yyyy-MM-dd HH:MM"
	 * @return
	 */
	public static String getCurrentTime(String format) {
		if (format == null || format.trim().equals("")) {
			sdf.applyPattern(FORMAT_DATE_TIME);
		} else {
			sdf.applyPattern(format);
		}
		return sdf.format(new Date());
	}

	/**
	 * 将日期字符串以指定格式转换为Date
	 * 
	 * @param time
	 *            日期字符�?
	 * @param format
	 *            指定的日期格式，若为null�?"则使用指定的格式"yyyy-MM-dd HH:MM"
	 * @return
	 */
	public static Date getTimeFromString(String timeStr, String format) {
		if (format == null || format.trim().equals("")) {
			sdf.applyPattern(FORMAT_DATE_TIME);
		} else {
			sdf.applyPattern(format);
		}
		try {
			return sdf.parse(timeStr);
		} catch (ParseException e) {
			return new Date();
		}
	}

	/**
	 * 将Date以指定格式转换为日期时间字符�?
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            指定的日期时间格式，若为null�?"则使用指定的格式"yyyy-MM-dd HH:MM"
	 * @return
	 */
	public static String getStringFromTime(Date time, String format) {
		if (format == null || format.trim().equals("")) {
			sdf.applyPattern(FORMAT_DATE_TIME);
		} else {
			sdf.applyPattern(format);
		}
		return sdf.format(time);
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String timeStr = "2010-11-30 10:12:23";
		try {
			Date date = sdf.parse(timeStr);

			System.out.println("\nTimeUtil.getDescriptionTimeFromTimestamp(date.getTime())");
			System.out.println(TimeUtil.getDescriptionTimeFromTimestamp(date.getTime()));
			System.out.println("\nTimeUtil.getDescriptionTimeFromTimestamp(new Date().getTime())");
			System.out.println(TimeUtil.getDescriptionTimeFromTimestamp(new Date().getTime()));

			System.out.println("\nTimeUtil.getFormatTimeFromTimestamp(date.getTime(), \"yyyy年MM月dd日\")");
			System.out.println(TimeUtil.getFormatTimeFromTimestamp(date.getTime(), "yyyy年MM月dd�?"));
			System.out.println("\nTimeUtil.getFormatTimeFromTimestamp(date.getTime(), null)");
			System.out.println(TimeUtil.getFormatTimeFromTimestamp(date.getTime(), null));
			System.out.println("\nTimeUtil.getFormatTimeFromTimestamp(new Date().getTime(), null)");
			System.out.println(TimeUtil.getFormatTimeFromTimestamp(new Date().getTime(), null));

			System.out.println("\nTimeUtil.getMixTimeFromTimestamp(date.getTime(), 3 * 24 * 60 * 60, \"yyyy年MM月dd�?hh:mm\")");
			System.out.println(TimeUtil.getMixTimeFromTimestamp(date.getTime(), 3 * 24 * 60 * 60, "yyyy年MM月dd�?hh:mm"));
			System.out.println("\nTimeUtil.getMixTimeFromTimestamp(date.getTime(), 24 * 60 * 60, null)");
			System.out.println(TimeUtil.getMixTimeFromTimestamp(date.getTime(), 24 * 60 * 60, null));
			System.out.println("\nTimeUtil.getMixTimeFromTimestamp(new Date().getTime(), 3 * 24 * 60 * 60, \"yyyy年MM月dd�?hh:mm\")");
			System.out.println(TimeUtil.getMixTimeFromTimestamp(new Date().getTime(), 3 * 24 * 60 * 60, "yyyy年MM月dd�?hh:mm"));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}