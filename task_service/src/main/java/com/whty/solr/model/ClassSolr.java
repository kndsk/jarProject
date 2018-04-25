package com.whty.solr.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * solr的class实体
 * 
 * @author ly
 *
 */
@SolrDocument(solrCoreName = "class")
public class ClassSolr implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 班级ID
	 */
	@Id
	@Field
	private String classid;

	/**
	 * 班级名称
	 */
	@Field
	private String classname;

	/**
	 * 班级成员数
	 */
	@Field
	private String membercount;

	/**
	 * 班级设立时间
	 */
	@Field
	private String foundtime;

	/**
	 * 机构名称
	 */
	@Field
	private String orgname;

	/**
	 * 省份代码
	 */
	@Field
	private String provincecode;

	/**
	 * 市代码
	 */
	@Field
	private String areacode;

	/**
	 * 区/县代码 
	 */
	@Field
	private String citycode;

	/**
	 * 访问次数：此字段由门户更新，AAM不处理
	 */
	@Field
	private Integer total;

	/**
	 * 标示图片
	 */
	@Field
	private String flagpic;

	/**
	 * 班级类型0：普通班1：实验班
	 */
	@Field
	private String classcate;

	/**
	 * 年级
	 */
	@Field
	private String grade;

	/**
	 * 所属学校的ID
	 */
	@Field
	private String orgaid;

	/**
	 * 班级的详细名称，是学校名称与班级名称的拼接
	 */
	@Field
	private String orgclassname;

	/**
	 * 职教学制 1:一年 2:二年 3:三年 4:四年 5:五年
	 */
	@Field
	private String systme;

	/**
	 * 元数据表中的专业ID 
	 */
	@Field
	private String courseId;

	/**
	 * 高职的专业大类ID，中职的专业类ID
	 */
	@Field
	private String bigCourseId;

	/**
	 * 高职的专业小类ID，中职可为空 
	 */
	@Field
	private String smallCourseId;

	/**
	 * 元数据表中的专业名称 
	 */
	@Field
	private String courseName;

	/**
	 * 与bigCourseId含义类似 
	 */
	@Field
	private String bigCourseName;

	/**
	 * 与smallCourseId含义类似
	 */
	@Field
	private String smallCourseName;

	/**
	 * 前七天访问量 
	 */
	@Field
	private Integer weekNumber;

	/**
	 * 总访问量
	 */
	@Field
	private Integer totalNumber;

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getMembercount() {
		return membercount;
	}

	public void setMembercount(String membercount) {
		this.membercount = membercount;
	}

	public String getFoundtime() {
		return foundtime;
	}

	public void setFoundtime(String foundtime) {
		this.foundtime = foundtime;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getProvincecode() {
		return provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getFlagpic() {
		return flagpic;
	}

	public void setFlagpic(String flagpic) {
		this.flagpic = flagpic;
	}

	public String getClasscate() {
		return classcate;
	}

	public void setClasscate(String classcate) {
		this.classcate = classcate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getOrgaid() {
		return orgaid;
	}

	public void setOrgaid(String orgaid) {
		this.orgaid = orgaid;
	}

	public String getOrgclassname() {
		return orgclassname;
	}

	public void setOrgclassname(String orgclassname) {
		this.orgclassname = orgclassname;
	}

	public String getSystme() {
		return systme;
	}

	public void setSystme(String systme) {
		this.systme = systme;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getBigCourseId() {
		return bigCourseId;
	}

	public void setBigCourseId(String bigCourseId) {
		this.bigCourseId = bigCourseId;
	}

	public String getSmallCourseId() {
		return smallCourseId;
	}

	public void setSmallCourseId(String smallCourseId) {
		this.smallCourseId = smallCourseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getBigCourseName() {
		return bigCourseName;
	}

	public void setBigCourseName(String bigCourseName) {
		this.bigCourseName = bigCourseName;
	}

	public String getSmallCourseName() {
		return smallCourseName;
	}

	public void setSmallCourseName(String smallCourseName) {
		this.smallCourseName = smallCourseName;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	@Override
	public String toString() {
		return "ClassSolr [classid=" + classid + ", classname=" + classname
				+ ", membercount=" + membercount + ", foundtime=" + foundtime
				+ ", orgname=" + orgname + ", provincecode=" + provincecode
				+ ", areacode=" + areacode + ", citycode=" + citycode
				+ ", total=" + total + ", flagpic=" + flagpic + ", classcate="
				+ classcate + ", grade=" + grade + ", orgaid=" + orgaid
				+ ", orgclassname=" + orgclassname + ", systme=" + systme
				+ ", courseId=" + courseId + ", bigCourseId=" + bigCourseId
				+ ", smallCourseId=" + smallCourseId + ", courseName="
				+ courseName + ", bigCourseName=" + bigCourseName
				+ ", smallCourseName=" + smallCourseName + ", weekNumber="
				+ weekNumber + ", totalNumber=" + totalNumber + "]";
	}
	
	

}
