package com.bw.zhangmeng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @author 作者:zhangmeng
 * @version 创建时间：2019年7月8日 上午10:13:56 
 * 类功能说明 
 */
public class DateUtils {

	
	
	
	/**
	 * 
	 * @param bitrthday
	 * @return
	 */
	public int getAge(Date bitrthday){
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(bitrthday);
		//得到出生的年
		int birthYear=instance.get(Calendar.YEAR);
		int birthMonth=instance.get(Calendar.MONTH);
		int birthDate=instance.get(Calendar.DAY_OF_MONTH);
		
		//获取当前的年月日
		instance.setTime(new Date());
		int currentYear=instance.get(Calendar.YEAR);
		int currentMonth=instance.get(Calendar.MONTH);
		int currentDate=instance.get(Calendar.DAY_OF_MONTH);
		
		
		int age=currentYear-birthYear;
		if (currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate){
			age--;
		}
		return age;
	}
	
	/**
	 * 计算剩余天数
	 *
	 * @param futureDate
	 * @return
	 */
	public int getRemainDays(Date futureDate){
		return (int)(futureDate.getTime()-new Date().getTime())/1000/36000/24;
	}
	
	
	/**
	 * 判断是否为当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr=simpleDateFormat.format(date);
		String todayStr=simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	/**
	 * 判断是否为当月
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr=simpleDateFormat.format(date);
		String todayStr=simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	/**
	 * 个特定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String string = format.format(date);//199809
		String monthStart=string +"01 00:00:00";
		 format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		 return format.parse(monthStart);

	}
	
	
	/**
	 * 个特定时间对象，初始化到该月末的最后一秒 比如2019/11/30 23：59：59
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthEnd(Date date) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();

	}
	
	
	
	
}
