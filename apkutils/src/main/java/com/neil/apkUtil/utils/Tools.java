package com.neil.apkUtil.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Tools {
	//时间格式
	public static String pattern_yyyymmdd = "yyyy-MM-dd";
	public static String yyyymmddHHmmss = "yyyyMMddHHmmss";
	public static String formatyyyyMMddhhmmss = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null || obj.equals("") || obj.equals("null") || obj.equals("undefined")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断集合是否为空
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		if (null == list || list.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 随机生成1-num的数
	 */
	public static int randomIntNum(int num){
		java.util.Random random=new java.util.Random();
		int result=random.nextInt(num);
		return result+1;
	}
	/**
	 * 获取UUID
	 * @return
	 */
	public static String UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * @方法名：contains
	 * @功能说明：字符串包含
	 * @param container
	 * @param regex
	 * @return
	 */
	public static boolean contains(String container, String regex) {
		if (container.contains(regex)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * MD5加密
	 * @param source
	 * @return
	 */
	public static String toMD5(byte[] source) {    	
    	try{
    		MessageDigest md = MessageDigest.getInstance("MD5");
    	    md.update(source);    	    
    	    StringBuffer buf=new StringBuffer();    	    
    	    for(byte b:md.digest())
    	    	buf.append(String.format("%02x", b&0xff) );    	     
    	    return buf.toString();
    	}catch( Exception e ){
    		e.printStackTrace(); return null;
    	}  
    }
	
	/**
	 * 转化时间格式pattern_yyyymmdd
	 * @param date
	 * @return
	 */
	public static String formatyyyyMMdd(Date date) {
		if(date==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern_yyyymmdd);
		return sdf.format(date);
	}
	
	/**
	 * yyyymmddHHmmss
	 */
	
	public static String formatyyyymmddHHmmss(Date date) {
		if(date==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(yyyymmddHHmmss);
		return sdf.format(date);
	}
	/**
	 * 转化时间格式formatyyyyMMddhhmmss
	 * @param date
	 * @return
	 */
	public static String formatyyyyMMddhhmmss(Date date) {
		if(date==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatyyyyMMddhhmmss);
		return sdf.format(date);
	}
	
	public static String getTimeStamp() {// 2012-06-28 16:27:22
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	
    
	/**
	 * 判断是否为空  并且返回null
	 * @param obj
	 * @return
	 */
	public static   String  toString(Object obj){
		if(obj==null){
			return null;
		}else{
			return obj.toString().trim();
		}
	}
	
	/**
	 * 身份证中间四位显示成*
	 * @param obj
	 * @return
	 */
    public static String  subMoilePhone(String moilePhone){
    	return moilePhone.substring(0,3) + "****" + moilePhone.substring(7, moilePhone.length());
    }
}
