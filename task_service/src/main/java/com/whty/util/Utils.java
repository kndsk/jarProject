package com.whty.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whty.common.SysConfig;

 


public class Utils {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Utils.class);
	
	/**
	 * 判断Map是否为空
	 * @param map
	 * @return
	 */
	public static  boolean mapIsEmpty(Map<?,?> map){
		if(null==map || map.size() <= 0){
			return true ;
		}
		return false;
	}
	
	
	/**
	 * 验证手机号码是否正确
	 * @param mobileNum
	 * @return
	 */
	public static boolean checkMobileNum(String mobileNum){
		boolean flag = false ;
		try{
			String regExp = "^((13[5-9]{1})|(15[0-2]{1})|(15[7-9]{1})|(18[7-8]{1})|(14[7]{1})|13[4]{1})+\\d{8}$" ;
			if(mobileNum.matches(regExp)){
				flag = true ;
			}
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return flag ;
	}
	
	
	
	/**
	 * 产生随机数
	 * @param length
	 * @return
	 */
	public static String getStringOfRandomLetter(int length) {
		if (length <= 0)
			return null;
		char[] NUM_LETTER = { '0', '1', '2', '3', '4', '5', '6', '7', '8','9'};
		StringBuffer sbRandom = new StringBuffer();
		char[] character = NUM_LETTER;
		for (int i = 0; i < length; i++) {
			sbRandom.append(character[new Random().nextInt(character.length)]);
		}
		return sbRandom.toString();
	}
 
	/**
	 * 每小时文件写入路径
	 * @param date
	 * @return
	 */
	public static String getHHFileName(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		return getServerPath()+getLogDir(date)+sdf.format(date)+".json";
	}
	

	/**
	 * 获取每天的文件路径
	 * @param day
	 * @return
	 */
	public static String getDDFileName(String day){
		String sep = File.separator;
		String [] dayStrs = day.split("-");
		logger.info("文件路径="+getServerPath()+sep+dayStrs[0]+sep+dayStrs[1]+sep+dayStrs[2]+sep);
		return getServerPath()+sep+dayStrs[0]+sep+dayStrs[1]+sep+dayStrs[2]+sep;
	}
	
	public static String getDDFileName1(Date date){
		String ddFilePath =getServerPath()+getLogDir(date);
		logger.info("文件路径="+ddFilePath);
		return ddFilePath;
	}
	
 
	/**
	 * 获取服务器日志存储路径
	 * @return
	 */
	private static String getServerPath(){
		String logPath = SysConfig.getStrValue("path");
		return logPath;
	}
	
	/**
	 * 根据日期获取存放路径
	 * @param date
	 * @return
	 */
	private static String getLogDir(Date date){
		String sep = File.separator;
		SimpleDateFormat sdf = new SimpleDateFormat(sep+"yyyy"+sep+"MM"+sep+"dd"+sep);
		return sdf.format(date);
	}
 

	/**
	 * 创建目录
	 * @param date
	 */
	public static void  mkDirs(Date date){
		File dir = new File(getServerPath()+getLogDir(date));
		if(!dir.exists()) dir.mkdirs();
	}
	
	public static  List<File> getTextFile(String path) {
		File parentFile = new File(path);
		File[] childrenFile = parentFile.listFiles();
		ArrayList<File> txtFile = new ArrayList<File>();
		if (childrenFile != null && childrenFile.length > 0) {
			for (int i = 0; i < childrenFile.length; i++) {
				if (childrenFile[i].getName().endsWith(".json"))
					txtFile.add(childrenFile[i]);
			}
		}
		return txtFile;
	}
	

	
	
 
	
}
