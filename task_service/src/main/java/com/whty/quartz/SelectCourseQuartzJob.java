package com.whty.quartz;

import java.util.LinkedHashMap;

import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whty.service.XgkSchoolCourseInfoService;

/**
 * 定时扒取数据
 */
public class SelectCourseQuartzJob {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Autowired
	    private XgkSchoolCourseInfoService xgkSchoolCourseInfoService;
	    public void run() throws JobExecutionException{
	        try {
	            LinkedHashMap<String,Object> resultMap= xgkSchoolCourseInfoService.grabbingDataService();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
