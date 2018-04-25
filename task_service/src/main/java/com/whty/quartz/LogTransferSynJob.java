package com.whty.quartz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whty.service.LogService;
import com.whty.util.DateUtil;

/**
 * 定时执行日志数据入库 
 */
public class LogTransferSynJob {

	private static final Logger logger = LoggerFactory
			.getLogger(LogTransferSynJob.class);

	@Autowired
	private LogService logService;

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public void run() {
		Date date = new Date();
		Date last = DateUtil.addHour(date, -1);
		try {
			if(logService.initLogService()){
				logger.info("数据入库开始");
				logService.syncReadFileFromQueue();
			}else{
				logger.info("任务结束");
			}
			
		}catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}

	}

}
