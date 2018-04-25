package com.whty.solr.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * solr的org实体
 * @author ly
 *
 */
@SolrDocument(solrCoreName = "org")
public class OrgSolr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构编号
	 */
	@Id
	@Field
	private String orgaid;
	
	/**
	 * 机构名称
	 */
	@Field
	private String organame;
	
	/**
	 * 机构类别 
	 */
	@Field
	private String orgacage;
	
	/**
	 * 省份编码
	 */
	@Field
	private String provincecode;
	
	/**
	 * 所属地域/市
	 */
	@Field
	private String areacode;
	
	/**
	 * 所在区 
	 */
	@Field
	private String citycode;
	
	/**
	 * 机构名称首字母
	 */
	@Field
	private String headletter;
	
	/**
	 * 机构类型，1：学校，2：机构 
	 */
	@Field
	private String type;
		
	/**
	 * 访问次数：此字段由门户更新，AAM不处理
	 */
	@Field
	private Integer total;		
		
	/**
	 * 机构分类：1：国家，2：区域，3：市，4：县/区
	 */
	@Field
	private String orgatype;
	
	/**
	 * 机构图片
	 */
	@Field
	private String orgapic;
	
	/**
	 * 平台编码
	 */
	@Field
	private Integer platformcode;
	
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

	public String getOrgaid() {
		return orgaid;
	}

	public void setOrgaid(String orgaid) {
		this.orgaid = orgaid;
	}

	public String getOrganame() {
		return organame;
	}

	public void setOrganame(String organame) {
		this.organame = organame;
	}

	public String getOrgacage() {
		return orgacage;
	}

	public void setOrgacage(String orgacage) {
		this.orgacage = orgacage;
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

	public String getHeadletter() {
		return headletter;
	}

	public void setHeadletter(String headletter) {
		this.headletter = headletter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getOrgatype() {
		return orgatype;
	}

	public void setOrgatype(String orgatype) {
		this.orgatype = orgatype;
	}

	public String getOrgapic() {
		return orgapic;
	}

	public void setOrgapic(String orgapic) {
		this.orgapic = orgapic;
	}

	public Integer getPlatformcode() {
		return platformcode;
	}

	public void setPlatformcode(Integer platformcode) {
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
		return "OrgSolr [orgaid=" + orgaid + ", organame=" + organame
				+ ", orgacage=" + orgacage + ", provincecode=" + provincecode
				+ ", areacode=" + areacode + ", citycode=" + citycode
				+ ", headletter=" + headletter + ", type=" + type + ", total="
				+ total + ", orgatype=" + orgatype + ", orgapic=" + orgapic
				+ ", platformcode=" + platformcode + ", addNumber=" + addNumber
				+ ", weekNumber=" + weekNumber + ", totalNumber=" + totalNumber
				+ ", addRes=" + addRes + ", totalRes=" + totalRes + "]";
	}
 
}
