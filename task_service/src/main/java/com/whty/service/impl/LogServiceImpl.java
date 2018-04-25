package com.whty.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.whty.Thread.LogTransfer.SynLogRunnable;
import com.whty.common.SysConfig;
import com.whty.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	private static final Logger logger = LoggerFactory
			.getLogger(LogServiceImpl.class);

	// 文件队列
	private BlockingQueue<File> queueFile = null;

	// 日志解析线程数
	private int LogFileTreadNum = 1;

	// 源文件列表
	private List<File> files = null;

	// 目标文件根目录地址
	public static String targetFileName = null;
	
	// 出错文件根目录地址
	public static String targetFileName_Failture = null;
	// 源文件根目录地址
	public static String sourceFileName = null;
	//源文件临时目录名
	public static String tempFileName = null;
	public static String id = "id";
	public static String tableName = "ST_OPERATELOGDETAIL_DM";
	public static String logintableName = "ST_LOGINLOGDETAIL_DM";
	
	// 构造函数初始化queue
	public Boolean initLogService() throws Exception {
		logger.info("初始化开始");
		killAllCurrentThread();
		this.files = initFiles();
		if(files==null){
			logger.info("没有文件需要处理");
			return false;
		}
		if(files.size()==0){
			logger.info("没有文件需要处理");
			return false;
		}
		queueFile = new ArrayBlockingQueue<File>(files.size());
		this.addfileToQueue(files);
		if(queueFile.size()==0){
		logger.info("没有文件需要处理,有部分文件文件名不合法！请检查各组上传文件夹");
		return false;
		}
		logger.info("获取文件总数"+queueFile.size());
		return true;
	}

	// 初始化文件列表
	private  List<File> initFiles() throws Exception {
		String filePath = null;
		filePath = SysConfig.getStrValue("logTransfer.filePatch");
		sourceFileName = filePath;
		tempFileName =  SysConfig.getStrValue("logTransfer.tempFileName");
		targetFileName  = SysConfig.getStrValue("logTransfer.targetFileName_Success");
		targetFileName_Failture = SysConfig.getStrValue("logTransfer.targetFileName_Failture");
		
		LogFileTreadNum = Integer.parseInt(SysConfig.getStrValue("logTransfer.TreadNum"));
		if (filePath == null || filePath == "") {
			throw new Exception("初始化失败！文件路径异常,请确认路径配置");
		}
		 //取得根目录路径  
	       String rootPath=getClass().getResource("/").getFile().toString(); 
		 List<File> fileList = new ArrayList<File>();
		return readFile(filePath,fileList);
	}
	 public  List<File> readFile(String dirPath, List<File> fileList) {  
		
         // 建立当前目录中文件的File对象  
         File file = new File(dirPath);  
         //当前目录名
         String currFileName = file.getName();
         // 取得代表目录中所有文件的File对象数组  
         File[] list = file.listFiles(); 
         if(list==null){
        	 return fileList;
         }
         // 遍历file数组  
         for (int i = 0; i < list.length; i++) {
        	 
                 if (list[i].isDirectory()) {  
                         // 递归子目录  
                         readFile(list[i].getPath(),fileList);  
                 } else { 
                	 //temp文件夹下的日志不取
                	 if(!currFileName.equals(tempFileName)){
                		 fileList.add(list[i]);
                	 }
                	
                 }  
         } 
         return fileList;
 }  
	// 线程循环调用文件队列处理方法
	public void syncReadFileFromQueue() throws InterruptedException {
		int queueSize = queueFile.size();
		for (int i = 0; i < LogFileTreadNum; i++) {
			Thread thread = 
			new Thread(new SynLogRunnable(queueFile));
			thread.setName("operateTread"+i);
			thread.start();
			Thread.sleep(1000);
			logger.info( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"==>线程"+thread.getName()+"启动=================>>");
		}

	}

	private void killAllCurrentThread() {
		Thread thread = Thread.currentThread();
		ThreadGroup tg = thread.getThreadGroup();
		

	}

	private void addfileToQueue(List<File> files) throws InterruptedException {
		for (int i = 0; i < files.size(); i++) {
			if (checkFileName(files.get(i))) {
				queueFile.put(files.get(i));
			}
		}
	}

	private Boolean checkFileName(File file) {
		String fileName = file.getName();
		String sysCode = fileName.split("_")[0];
		if(sysCode==null ||sysCode == ""){
			return false;
		}else{
			for (SysCode sCode : SysCode.values()){
				if(sysCode.equals(sCode.toString())){
					logger.info(sCode.toString());
					return true;
				}
			}
			return false;
		}
	}
	   public static enum SysCode{
		   SYS("1"), PORTAL("2"), STUDIO("3"), SME("4"), AAM("5"), RES("6"), OPEN("7"),LOGINPORTAL("8"),SYSLOGIN("9");
	   
	   
	        private final String value;

	        SysCode(String value) {
	            this.value = value;
	        }
	        
	        public String getValue() {
	            return value;
	        }
	    }

}
