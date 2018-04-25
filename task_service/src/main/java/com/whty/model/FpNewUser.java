package com.whty.model;



public class FpNewUser implements java.io.Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5157511108147049668L;

	
	private String opTime;
	
	private String platformCode;
	

	private String custType;
	

	private String custId;
	
	
	private String custName;
	
	
	/**
	 * 空间前七天访问量
	 */
	
	private Integer sevenAccessNums;
	
	/**
	 * 空间总访问量
	 */
 
	private Integer totalAccessNums;
	
	/**
	 * 日访问量
	 */
	
	private Integer addAccessNums;
	
	
	/**
	 * 前七天资源数
	 */
	
	private Integer sevenResNums;
	/**
	 * 总资源数
	 */
	
	private Integer totalResNums;
	
	/**
	 * 日资源数
	 */
	
	private Integer addResNums;

	
	
	
	
	
	public String getOpTime() {
		return opTime;
	}






	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}






	public String getPlatformCode() {
		return platformCode;
	}






	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}






	public String getCustType() {
		return custType;
	}






	public void setCustType(String custType) {
		this.custType = custType;
	}






	public String getCustId() {
		return custId;
	}






	public void setCustId(String custId) {
		this.custId = custId;
	}






	public String getCustName() {
		return custName;
	}






	public void setCustName(String custName) {
		this.custName = custName;
	}






	public Integer getSevenAccessNums() {
		return sevenAccessNums;
	}






	public void setSevenAccessNums(Integer sevenAccessNums) {
		this.sevenAccessNums = sevenAccessNums;
	}






	public Integer getTotalAccessNums() {
		return totalAccessNums;
	}






	public void setTotalAccessNums(Integer totalAccessNums) {
		this.totalAccessNums = totalAccessNums;
	}






	public Integer getAddAccessNums() {
		return addAccessNums;
	}






	public void setAddAccessNums(Integer addAccessNums) {
		this.addAccessNums = addAccessNums;
	}






	public Integer getSevenResNums() {
		return sevenResNums;
	}






	public void setSevenResNums(Integer sevenResNums) {
		this.sevenResNums = sevenResNums;
	}






	public Integer getTotalResNums() {
		return totalResNums;
	}






	public void setTotalResNums(Integer totalResNums) {
		this.totalResNums = totalResNums;
	}






	public Integer getAddResNums() {
		return addResNums;
	}






	public void setAddResNums(Integer addResNums) {
		this.addResNums = addResNums;
	}



	@Override
	public String toString() {
		return "FpUser [opTime=" + opTime + ", platformCode=" + platformCode
				+ ", custId=" + custId
				+ ", custName=" + custName + ", custType=" + custType
				+ ", sevenAccessNums=" + sevenAccessNums
				+ ", totalAccessNums=" + totalAccessNums + ", addAccessNums="
				+ addAccessNums + ", sevenResNums=" + sevenResNums + ", addResNums=" + addResNums
				+ ", totalResNums=" + totalResNums
				+ "]";
	}

	
 
	
}
