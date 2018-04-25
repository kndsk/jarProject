package com.whty.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whty.model.ActivityMember;


/**
 * 教研活动成员Dao
 */

public interface ActivityMemberDao {
    /**
     * 批量插入文件
     * @param list
     */
    void batchSave(List<ActivityMember> list);


    List<ActivityMember> findByActId(@Param("activityId")String activityId);



}
