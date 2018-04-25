package com.whty.service;



public interface LogService {
	
	// 构造函数初始化queue
	public Boolean initLogService() throws Exception ;

	// 线程循环调用文件队列处理方法
	public void syncReadFileFromQueue() throws InterruptedException ;
	
}
