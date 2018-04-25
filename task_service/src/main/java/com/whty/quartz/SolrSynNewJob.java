package com.whty.quartz;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whty.service.UserNewService;
import com.whty.util.DateUtil;
 
/**
 * 定时推送solr数据
 */
public class SolrSynNewJob {
	private  final Logger logger = LoggerFactory
			.getLogger(this.getClass());

    
    @Autowired
    private UserNewService     userService;
    
  
	
	public void run() {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Date last = DateUtil.addDay(new Date(), -1);
		final String yesterday = DateUtil.format("yyyyMMdd", last);

		logger.error("开始同步"+yesterday+"的数据");
		
   
    	
       pool.execute(new Runnable() {
    		
    		public void run() {
    			logger.error("开始同步");
    			userService.SyncData(yesterday);
    			logger.error("结束同步");
    		}
    		
    	});

	}
}
