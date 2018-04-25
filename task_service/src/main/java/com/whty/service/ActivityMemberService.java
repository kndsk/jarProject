package com.whty.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whty.model.ActivityMember;

/**
 * ActivityMemberService
 */
public interface ActivityMemberService {
	
	  /**
     * 批量插入文件
     * @param list
     */
    void batchSave(List<ActivityMember> list);


    List<ActivityMember> findByActId(String activityId);
}
