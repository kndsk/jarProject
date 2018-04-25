package com.whty.quartz;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whty.model.ActivityMember;
import com.whty.service.ActivityMemberService;
import com.whty.util.IdGen;

/**
 * 批量插入
 * @author Administrator
 *
 */
public class CnzzFlowJob {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ActivityMemberService activityMemberService;
	
	
	public void run() {
	
		List<ActivityMember> list = new ArrayList<ActivityMember>();
		for (int i = 0; i < 10; i++) {
			ActivityMember ac = new ActivityMember();
			ac.setId(IdGen.get());
			ac.setActivityId("1111");
			ac.setRealName("ly");
			ac.setUserId("ly");
	        ac.setCreateUserId("2222");
	        ac.setUpdateUserId("333");
	        list.add(ac);
		}
		
		activityMemberService.batchSave(list);
	}

	

}
