package com.whty.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// 注意这里的注解哦，简单看看mongodb的文档就知道这个是文档集合
@Document(collection = "edu_post")
public class Post {
	@Id
	private String _id;
	
	@Field("id")
	private String id;

	private String userid;

	private String username;

	private Integer paperid;
	
	private Integer age;
	
	//聚合操作中返回的total
	private Integer total;
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public Integer getPaperid() {
		return paperid;
	}

	public void setPaperid(Integer paperid) {
		this.paperid = paperid;
	}

	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Post [_id=" + _id + ", id=" + id + ", userid=" + userid
				+ ", paperid=" + paperid+", username="+username+", age="+age+", total="+total
				 + "]";
	}

 
	
	

}