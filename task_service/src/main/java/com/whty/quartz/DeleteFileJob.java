package com.whty.quartz;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.whty.util.DateUtil;

/**
 * 
 * @author tzl
 * 定期删除服务器上的excel文件
 */
public class DeleteFileJob {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("#{propertyConfigurer['EXCEL_FILE_PATH']}")
	private String excelFilePath;
	
	

	public void run() {

		/*WebApplicationContext webApplicationContext = ContextLoader
				.getCurrentWebApplicationContext();*/
		//webApplicationContext.getApplicationName();
		String pathString = excelFilePath;

		File file = new File(pathString);
		File[] tempList = file.listFiles();

		System.out.println("该目录下对象个数：" + tempList.length);
		System.out.println("上个月：" + DateUtil.getAheadMonth());

		for (int i = 0; i < tempList.length; i++) {
			/*
			 * 如果是文件且标志为上个月的就删除
			 */
			if (tempList[i].isFile() && tempList[i].exists()) {
				String fileNameString = tempList[i].getName();
				String yearAndMonthString = DateUtil.getAheadMonth();

				if (fileNameString.contains(yearAndMonthString)) {
					System.out.println("删除文件：" + fileNameString);
					tempList[i].delete();
				}

			}
			/*
			 * 如果是文件夹就不删除
			 */
			if (tempList[i].isDirectory()) { 
				System.out.println("文件夹：" +tempList[i].getName()); 
				}
		}
	}

}
