package com.whty.model;

import java.util.List;

/**
 * 学校基础信息DTO
 * @author zhangkl
 * @time 2017-2018
 */

public class TestRedisDTO implements java.io.Serializable{

	public TestRedisDTO() {
		super();
	}

	/** 主键Id **/
	private String  id;
	/** 学校名称 **/
	private String	name;
	/** 学校层次  **/
	private Integer	age;
	/** 学校类别  **/
	private String	intrsting;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIntrsting() {
		return intrsting;
	}
	public void setIntrsting(String intrsting) {
		this.intrsting = intrsting;
	}
	







}
