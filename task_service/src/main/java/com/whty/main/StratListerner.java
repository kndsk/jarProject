package com.whty.main;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StratListerner {
	private static final Logger logger = LoggerFactory
			.getLogger(StratListerner.class);
	private static final String log4jPath = "/log4j.properties";
	public static 	ApplicationContext applicationContext ;
	
	
	
//jar工程没有web.xml，不能再web.xml中启动log4j,通过此方法初始化
	public void initLog4j() throws Exception {
		Properties pro = new Properties();
		InputStream is = getClass().getResourceAsStream(log4jPath);
		pro.load(is);
		PropertyConfigurator.configure(pro);
	}

 
	public static void start(String... args) {
		try {
			new StratListerner().initLog4j();
			 applicationContext = new ClassPathXmlApplicationContext(
					 new String[] { "classpath*:spring/applicationContext*.xml",
								"classpath*:hibernate/applicationContext*.xml",
								"classpath*:quartz/applicationContext*.xml",
								//浙江日志
							/*	"classpath*:quartz/applicationContext-quartz-zj.xml",*/
								"classpath*:solr/applicationContext*.xml" });
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("初始化服务失败");
		}
	}
}
