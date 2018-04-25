package com.whty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whty.dao.ActivityMemberDao;
import com.whty.model.ActivityMember;
import com.whty.service.ActivityMemberService;

/**
 * 账号设置实现类
 */
@Service
public class ActivityMemberServiceImpl extends BaseServiceImpl implements ActivityMemberService {

	 @Resource
	  ActivityMemberDao activityMemberDao;
	 
	

	@Override
	public void batchSave(List<ActivityMember> list) {
		activityMemberDao.batchSave(list);
		
	}

	@Override
	public List<ActivityMember> findByActId(String activityId) {
		
		return activityMemberDao.findByActId(activityId);
	}


}
