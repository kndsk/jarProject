package com.whty.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.whty.dao.ActivityMemberDao;
import com.whty.model.ActivityMember;
import com.whty.service.ActivityMemberService;
import com.whty.util.IdGen;

/**
 * 单元测试
 * @author Administrator
 *
 */
public class TestMysql extends BaseTest{
   
	 @Resource
	 private ActivityMemberService activityMemberService;
	
	
	@Test
	public void testFindById() {
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
