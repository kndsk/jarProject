package com.whty.model;

import java.util.Date;

/**
 * 日志明细的实体类
 * 
 * @author jlq 2015-11-19
 */

public class LogDetail implements java.io.Serializable {

	private static final long serialVersionUID = -1484291999705211314L;

	
	private Long id;

	
	private String accountName;
	
	private String loginType;
	
	private String ipAddress;

	private String operationCode;

	private String operationDes;
	
	private String userRole;
	
	private String operationTime;
	
	private String sysAreaCode;

	private Date createTime;
	private Date doneTime;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationDes() {
		return operationDes;
	}

	public void setOperationDes(String operationDes) {
		this.operationDes = operationDes;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getSysAreaCode() {
		return sysAreaCode;
	}

	public void setSysAreaCode(String sysAreaCode) {
		this.sysAreaCode = sysAreaCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
