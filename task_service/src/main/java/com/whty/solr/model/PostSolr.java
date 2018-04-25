package com.whty.solr.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * solr的post
 * 
 * @author ly
 *
 */
@SolrDocument(solrCoreName = "post")
public class PostSolr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field
	private String id;

	@Field
	private String userid;

	@Field
	private String userName;

	@Field
	private String organizationid;

	@Field
	private String title;
	
	@Field
	private String content;
	
	@Field
	private String categoryid;
	
	@Field
	private String paperid;
	
	@Field
	private String type;
	
	@Field
	private String external_type;
	
	@Field
	private String tags;
	
	@Field
	private String datetime;
	
	@Field
	private String status;
	
	@Field
	private String comment_status;
	
	@Field
	private Integer comment_count;
	
	@Field
	private Integer view_count;
	
	@Field
	private Integer like_count;
	
	@Field
	private Integer copy_count;
	
	@Field
	private Integer favorite_count;
	
	@Field
	private String updatetime;
	
	@Field
	private String searchtime;
	
	@Field
	private String usertype;
	
	@Field
	private String studyphase;
	
	@Field
	private String majorsubjectid;
	
	@Field
	private String majorsubjectname;
	
	@Field
	private String operate;

	@Field
	private String platformCode;

	@Field
	private String areacode;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExternal_type() {
		return external_type;
	}

	public void setExternal_type(String external_type) {
		this.external_type = external_type;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment_status() {
		return comment_status;
	}

	public void setComment_status(String comment_status) {
		this.comment_status = comment_status;
	}

	public Integer getComment_count() {
		return comment_count;
	}

	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}

	public Integer getView_count() {
		return view_count;
	}

	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}

	public Integer getLike_count() {
		return like_count;
	}

	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}

	public Integer getCopy_count() {
		return copy_count;
	}

	public void setCopy_count(Integer copy_count) {
		this.copy_count = copy_count;
	}

	public Integer getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(Integer favorite_count) {
		this.favorite_count = favorite_count;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getSearchtime() {
		return searchtime;
	}

	public void setSearchtime(String searchtime) {
		this.searchtime = searchtime;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getStudyphase() {
		return studyphase;
	}

	public void setStudyphase(String studyphase) {
		this.studyphase = studyphase;
	}

	public String getMajorsubjectid() {
		return majorsubjectid;
	}

	public void setMajorsubjectid(String majorsubjectid) {
		this.majorsubjectid = majorsubjectid;
	}

	public String getMajorsubjectname() {
		return majorsubjectname;
	}

	public void setMajorsubjectname(String majorsubjectname) {
		this.majorsubjectname = majorsubjectname;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Override
	public String toString() {
		return "PostSolr [id=" + id + ", userid=" + userid + ", userName="
				+ userName + ", organizationid=" + organizationid + ", title="
				+ title + ", content=" + content + ", categoryid=" + categoryid
				+ ", paperid=" + paperid + ", type=" + type
				+ ", external_type=" + external_type + ", tags=" + tags
				+ ", datetime=" + datetime + ", status=" + status
				+ ", comment_status=" + comment_status + ", comment_count="
				+ comment_count + ", view_count=" + view_count
				+ ", like_count=" + like_count + ", copy_count=" + copy_count
				+ ", favorite_count=" + favorite_count + ", updatetime="
				+ updatetime + ", searchtime=" + searchtime + ", usertype="
				+ usertype + ", studyphase=" + studyphase + ", majorsubjectid="
				+ majorsubjectid + ", majorsubjectname=" + majorsubjectname
				+ ", operate=" + operate + ", platformCode=" + platformCode
				+ ", areacode=" + areacode + "]";
	}
	
	

}
