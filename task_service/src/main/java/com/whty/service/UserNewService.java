package com.whty.service;

import com.whty.common.SynTypeEnum;

public interface UserNewService {
	public void  SyncData(String day);
	
	public void  SyncData(String day,SynTypeEnum synType);
	
}
