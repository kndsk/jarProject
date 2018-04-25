package com.whty.model;




/**
 * 教研活动参与人类
 * @author 
 */
public class ActivityMember extends BaseModel {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5207670153730622941L;
    /*活动ID*/
    private String activityId;
    /*用户ID*/
    private String userId;
    /*用户姓名*/
    private String realName;
    
    public String getActivityId() {
        return activityId;
    }
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
	
}