package com.whty.solr.model;

import java.io.Serializable;
import java.util.Set;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * solr的user实体
 * 
 * @author ly
 *
 */
@SolrDocument(solrCoreName = "user")
public class UserSolr implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	@Field
	private String personid;

	/**
	 * 姓名
	 */
	@Field
	private String name;

	/**
	 * 性别
	 */
	@Field
	private String gender;

	/**
	 * 用户类型
	 */
	@Field
	private String usertype;

	/**
	 * 所属机构名称
	 */
	@Field
	private String orgname;

	/**
	 * 教授的课程列表
	 */
	@Field
	private Set<String> teacheragelist;

	/**
	 * 教授班级ID
	 */
	@Field
	private String classid;

	/**
	 * 教授班级名称
	 */
	@Field
	private String classname;

	/**
	 * 所属机构ID
	 */
	@Field
	private String orgid;

	/**
	 * 年级
	 */
	@Field
	private String grade;

	/**
	 * 访问次数：此字段由门户更新，AAM不处理
	 */
	@Field
	private Integer total;

	/**
	 * 机构类型
	 */
	@Field
	private String orgacage;

	/**
	 * 岗位职称
	 */
	@Field
	private String jobtitle;

	/**
	 * 头像地址
	 */
	@Field
	private String logoUrl;

	/**
	 * 机构的省代码
	 */
	@Field
	private String provincecode;

	/**
	 * 机构的市代码
	 */
	@Field
	private String areacode;

	/**
	 * 机构的区县代码
	 */
	@Field
	private String citycode;

	/**
	 * 账号
	 */
	@Field
	private String account;

	/**
	 * 教材列表
	 */
	@Field
	private Set<String> teachmateriallist;

	/**
	 * 手机号码
	 */
	@Field
	private String telephone;

	/**
	 * 职教教育阶段，0：中职、1：高职
	 */
	@Field
	private String eduphase;

	/**
	 * 职教专业属性
	 */
	@Field
	private String professionpro;

	/**
	 * 用户所在学段(基教)，0：小学、1：初中、2：高中、3：幼儿园
	 */
	@Field
	private String studyphase;

	/**
	 * 主教学科ID
	 */
	@Field
	private String majorsubjectid;

	/**
	 * 主教学科名称
	 */
	@Field
	private String majorsubjectname;

	/**
	 * 平台编码
	 */
	@Field
	private String platformcode;
	
	/**
	 * 日访问量
	 */
	@Field
	private Integer addNumber;

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
	
	
	/**
	 * 日资源数
	 */
	@Field
	private Integer addRes;
	
	/**
	 * 总的资源数
	 */
	@Field
	private Integer totalRes;
	
	/**
	 * 日期
	 */
	@Field
	private String op_time;


	
	
	
	
	public String getOp_time() {
		return op_time;
	}

	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Set<String> getTeacheragelist() {
		return teacheragelist;
	}

	public void setTeacheragelist(Set<String> teacheragelist) {
		this.teacheragelist = teacheragelist;
	}

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

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getOrgacage() {
		return orgacage;
	}

	public void setOrgacage(String orgacage) {
		this.orgacage = orgacage;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Set<String> getTeachmateriallist() {
		return teachmateriallist;
	}

	public void setTeachmateriallist(Set<String> teachmateriallist) {
		this.teachmateriallist = teachmateriallist;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEduphase() {
		return eduphase;
	}

	public void setEduphase(String eduphase) {
		this.eduphase = eduphase;
	}

	public String getProfessionpro() {
		return professionpro;
	}

	public void setProfessionpro(String professionpro) {
		this.professionpro = professionpro;
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

	public String getPlatformcode() {
		return platformcode;
	}

	public void setPlatformcode(String platformcode) {
		this.platformcode = platformcode;
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
 
	public Integer getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(Integer addNumber) {
		this.addNumber = addNumber;
	}

	public Integer getAddRes() {
		return addRes;
	}

	public void setAddRes(Integer addRes) {
		this.addRes = addRes;
	}

	public Integer getTotalRes() {
		return totalRes;
	}

	public void setTotalRes(Integer totalRes) {
		this.totalRes = totalRes;
	}

	@Override
	public String toString() {
		return "UserSolr [personid=" + personid + ", name=" + name
				+ ", gender=" + gender + ", usertype=" + usertype
				+ ", orgname=" + orgname + ", teacheragelist=" + teacheragelist
				+ ", classid=" + classid + ", classname=" + classname
				+ ", orgid=" + orgid + ", grade=" + grade + ", total=" + total
				+ ", orgacage=" + orgacage + ", jobtitle=" + jobtitle
				+ ", logoUrl=" + logoUrl + ", provincecode=" + provincecode
				+ ", areacode=" + areacode + ", citycode=" + citycode
				+ ", account=" + account + ", teachmateriallist="
				+ teachmateriallist + ", telephone=" + telephone
				+ ", eduphase=" + eduphase + ", professionpro=" + professionpro
				+ ", studyphase=" + studyphase + ", majorsubjectid="
				+ majorsubjectid + ", majorsubjectname=" + majorsubjectname
				+ ", platformcode=" + platformcode + ", addNumber=" + addNumber
				+ ", weekNumber=" + weekNumber + ", totalNumber=" + totalNumber
				+ ", addRes=" + addRes + ", totalRes=" + totalRes + "]";
	}

	

}
