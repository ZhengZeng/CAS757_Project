package edu.mcm.cas757.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
		int timestamp = (int) (System.currentTimeMillis() / 1000);
		System.out.println("存进数据库的内容�?");
		System.out.println(timestamp);

		System.out.println("=======================");
		System.out.println("将从数据库读取的整型timestamp转换成日期类型：");
		long time = (long) timestamp * 1000;
		Date date = new Date(time);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(date));
		System.out.println("=======================");
		Date date1 = new Date(System.currentTimeMillis());
		System.out.println(sdf1.format(date1));
	}
}