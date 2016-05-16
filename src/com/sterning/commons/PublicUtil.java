package com.sterning.commons;

import java.sql.Timestamp;
import java.util.Date;

public class PublicUtil {

	/*
	 * 将获取的日期时间数据转换成数据库的数据
	 */
	public static String getStrNowDate() {
		Date date = new Date();
		String nowtime = new Timestamp(date.getTime()).toString();
		nowtime = nowtime.substring(0, 10);
		String nowYear = nowtime.substring(0, 4);
		String nowMouth = nowtime.substring(5, 7);
		String nowDay = nowtime.substring(8, 10);
		String nowdate = nowYear + nowMouth + nowDay;
		return nowdate;

	}

	public static String getNowDate() {
		Date date = new Date();
		String nowtime = new Timestamp(date.getTime()).toString();
		nowtime = nowtime.substring(0, 10);
		return nowtime;
	}

}
