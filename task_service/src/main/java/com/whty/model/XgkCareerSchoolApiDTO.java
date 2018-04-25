package com.whty.model;

import java.util.List;

/**
 * 学校基础信息DTO
 * @author zhangkl
 * @time 2017-2018
 */

public class XgkCareerSchoolApiDTO implements java.io.Serializable{

	public XgkCareerSchoolApiDTO() {
		super();
//		keySubjectCount  = 0;
//		masterPointCount  = 0;
//		doctorPointCount  = 0;
	}

	/** 主键Id **/
	private String  id;
	/** 学校名称 **/
	private String	schoolName;
	/** 学校层次  **/
	private String	schoolLevel;
	/** 学校类别  **/
	private String	schoolCategory;
	/** 隶属组织  **/
	private String	subordinateOrganization;
	/** 所属省份  **/
	private String	locatedProvince;
	/** 所属市  **/
	private String	locatedCity;
	/** 学校地址 **/
	private String	schoolAddress;
	/** 电话  **/
	private String	schoolTel;
	/** 学校网址 **/
	private String	schoolUrl;
	/** 招生网址 **/
	private String	admissionsUrl;
	/** 学校简介 **/
	private String	schoolIntroduction;
	/** 校徽路径  **/
	private String	schoolBadgePath;

	/** 重点学科数量  **/
	private Integer	keySubjectCount;
	/** 硕士点数  **/
	private Integer	masterPointCount;
	/** 博士点数  **/
	private Integer	doctorPointCount;

	/** 学校排序 **/
	private Integer	schoolOrderNum;
	/** 省份排序 **/
	private Integer	provinceOrderNum;
	/** 学校层次排序 **/
	private Integer	levelOrderNum;
	/** 学校类别排序 **/
	private Integer	categoryOrderNum;

	/**属性名称**/
	private String propertyName;
	/** 生成日期 **/
	private String	scrq;

	/**表外字段**/
	List<String> attrStrList;









	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XgkCareerSchoolApiDTO [");
		if (schoolName != null) {
			builder.append("schoolName=");
			builder.append(schoolName);
			builder.append(", ");
		}
		if (schoolLevel != null) {
			builder.append("schoolLevel=");
			builder.append(schoolLevel);
			builder.append(", ");
		}
		if (schoolCategory != null) {
			builder.append("schoolCategory=");
			builder.append(schoolCategory);
			builder.append(", ");
		}
		if (subordinateOrganization != null) {
			builder.append("subordinateOrganization=");
			builder.append(subordinateOrganization);
			builder.append(", ");
		}
		if (locatedProvince != null) {
			builder.append("locatedProvince=");
			builder.append(locatedProvince);
			builder.append(", ");
		}
		if (locatedCity != null) {
			builder.append("locatedCity=");
			builder.append(locatedCity);
			builder.append(", ");
		}
		if (schoolAddress != null) {
			builder.append("schoolAddress=");
			builder.append(schoolAddress);
			builder.append(", ");
		}
		if (schoolTel != null) {
			builder.append("schoolTel=");
			builder.append(schoolTel);
			builder.append(", ");
		}
		if (schoolUrl != null) {
			builder.append("schoolUrl=");
			builder.append(schoolUrl);
			builder.append(", ");
		}
		if (admissionsUrl != null) {
			builder.append("admissionsUrl=");
			builder.append(admissionsUrl);
			builder.append(", ");
		}
		if (schoolIntroduction != null) {
			builder.append("schoolIntroduction=");
			builder.append(schoolIntroduction);
			builder.append(", ");
		}
		if (schoolBadgePath != null) {
			builder.append("schoolBadgePath=");
			builder.append(schoolBadgePath);
			builder.append(", ");
		}
		if (keySubjectCount != null) {
			builder.append("keySubjectCount=");
			builder.append(keySubjectCount);
			builder.append(", ");
		}
		if (masterPointCount != null) {
			builder.append("masterPointCount=");
			builder.append(masterPointCount);
			builder.append(", ");
		}
		if (doctorPointCount != null) {
			builder.append("doctorPointCount=");
			builder.append(doctorPointCount);
			builder.append(", ");
		}
		if (schoolOrderNum != null) {
			builder.append("schoolOrderNum=");
			builder.append(schoolOrderNum);
			builder.append(", ");
		}
		if (provinceOrderNum != null) {
			builder.append("provinceOrderNum=");
			builder.append(provinceOrderNum);
			builder.append(", ");
		}
		if (levelOrderNum != null) {
			builder.append("levelOrderNum=");
			builder.append(levelOrderNum);
			builder.append(", ");
		}
		if (categoryOrderNum != null) {
			builder.append("categoryOrderNum=");
			builder.append(categoryOrderNum);
			builder.append(", ");
		}
		if (propertyName != null) {
			builder.append("propertyName=");
			builder.append(propertyName);
		}
		builder.append("]");
		return builder.toString();
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionsUrl == null) ? 0 : admissionsUrl.hashCode());
		result = prime * result + ((categoryOrderNum == null) ? 0 : categoryOrderNum.hashCode());
		result = prime * result + ((doctorPointCount == null) ? 0 : doctorPointCount.hashCode());
		result = prime * result + ((keySubjectCount == null) ? 0 : keySubjectCount.hashCode());
		result = prime * result + ((levelOrderNum == null) ? 0 : levelOrderNum.hashCode());
		result = prime * result + ((locatedCity == null) ? 0 : locatedCity.hashCode());
		result = prime * result + ((locatedProvince == null) ? 0 : locatedProvince.hashCode());
		result = prime * result + ((masterPointCount == null) ? 0 : masterPointCount.hashCode());
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
		result = prime * result + ((provinceOrderNum == null) ? 0 : provinceOrderNum.hashCode());
		result = prime * result + ((schoolAddress == null) ? 0 : schoolAddress.hashCode());
		result = prime * result + ((schoolBadgePath == null) ? 0 : schoolBadgePath.hashCode());
		result = prime * result + ((schoolCategory == null) ? 0 : schoolCategory.hashCode());
		result = prime * result + ((schoolIntroduction == null) ? 0 : schoolIntroduction.hashCode());
		result = prime * result + ((schoolLevel == null) ? 0 : schoolLevel.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((schoolOrderNum == null) ? 0 : schoolOrderNum.hashCode());
		result = prime * result + ((schoolTel == null) ? 0 : schoolTel.hashCode());
		result = prime * result + ((schoolUrl == null) ? 0 : schoolUrl.hashCode());
		result = prime * result + ((subordinateOrganization == null) ? 0 : subordinateOrganization.hashCode());
		return result;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof XgkCareerSchoolApiDTO))
			return false;
		XgkCareerSchoolApiDTO other = (XgkCareerSchoolApiDTO) obj;
		if (admissionsUrl == null) {
			if (other.admissionsUrl != null)
				return false;
		} else if (!admissionsUrl.equals(other.admissionsUrl))
			return false;
		if (categoryOrderNum == null) {
			if (other.categoryOrderNum != null)
				return false;
		} else if (!categoryOrderNum.equals(other.categoryOrderNum))
			return false;
		if (doctorPointCount == null) {
			if (other.doctorPointCount != null)
				return false;
		} else if (!doctorPointCount.equals(other.doctorPointCount))
			return false;
		if (keySubjectCount == null) {
			if (other.keySubjectCount != null)
				return false;
		} else if (!keySubjectCount.equals(other.keySubjectCount))
			return false;
		if (levelOrderNum == null) {
			if (other.levelOrderNum != null)
				return false;
		} else if (!levelOrderNum.equals(other.levelOrderNum))
			return false;
		if (locatedCity == null) {
			if (other.locatedCity != null)
				return false;
		} else if (!locatedCity.equals(other.locatedCity))
			return false;
		if (locatedProvince == null) {
			if (other.locatedProvince != null)
				return false;
		} else if (!locatedProvince.equals(other.locatedProvince))
			return false;
		if (masterPointCount == null) {
			if (other.masterPointCount != null)
				return false;
		} else if (!masterPointCount.equals(other.masterPointCount))
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		if (provinceOrderNum == null) {
			if (other.provinceOrderNum != null)
				return false;
		} else if (!provinceOrderNum.equals(other.provinceOrderNum))
			return false;
		if (schoolAddress == null) {
			if (other.schoolAddress != null)
				return false;
		} else if (!schoolAddress.equals(other.schoolAddress))
			return false;
		if (schoolBadgePath == null) {
			if (other.schoolBadgePath != null)
				return false;
		} else if (!schoolBadgePath.equals(other.schoolBadgePath))
			return false;
		if (schoolCategory == null) {
			if (other.schoolCategory != null)
				return false;
		} else if (!schoolCategory.equals(other.schoolCategory))
			return false;
		if (schoolIntroduction == null) {
			if (other.schoolIntroduction != null)
				return false;
		} else if (!schoolIntroduction.equals(other.schoolIntroduction))
			return false;
		if (schoolLevel == null) {
			if (other.schoolLevel != null)
				return false;
		} else if (!schoolLevel.equals(other.schoolLevel))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (schoolOrderNum == null) {
			if (other.schoolOrderNum != null)
				return false;
		} else if (!schoolOrderNum.equals(other.schoolOrderNum))
			return false;
		if (schoolTel == null) {
			if (other.schoolTel != null)
				return false;
		} else if (!schoolTel.equals(other.schoolTel))
			return false;
		if (schoolUrl == null) {
			if (other.schoolUrl != null)
				return false;
		} else if (!schoolUrl.equals(other.schoolUrl))
			return false;
		if (subordinateOrganization == null) {
			if (other.subordinateOrganization != null)
				return false;
		} else if (!subordinateOrganization.equals(other.subordinateOrganization))
			return false;
		return true;
	}





	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolLevel() {
		return schoolLevel;
	}
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	public String getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
	public String getSubordinateOrganization() {
		return subordinateOrganization;
	}
	public void setSubordinateOrganization(String subordinateOrganization) {
		this.subordinateOrganization = subordinateOrganization;
	}
	public String getLocatedProvince() {
		return locatedProvince;
	}
	public void setLocatedProvince(String locatedProvince) {
		this.locatedProvince = locatedProvince;
	}
	public String getLocatedCity() {
		return locatedCity;
	}
	public void setLocatedCity(String locatedCity) {
		this.locatedCity = locatedCity;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getSchoolTel() {
		return schoolTel;
	}
	public void setSchoolTel(String schoolTel) {
		this.schoolTel = schoolTel;
	}
	public String getSchoolUrl() {
		return schoolUrl;
	}
	public void setSchoolUrl(String schoolUrl) {
		this.schoolUrl = schoolUrl;
	}
	public String getAdmissionsUrl() {
		return admissionsUrl;
	}
	public void setAdmissionsUrl(String admissionsUrl) {
		this.admissionsUrl = admissionsUrl;
	}
	public String getSchoolIntroduction() {
		return schoolIntroduction;
	}
	public void setSchoolIntroduction(String schoolIntroduction) {
		this.schoolIntroduction = schoolIntroduction;
	}
	public String getSchoolBadgePath() {
		return schoolBadgePath;
	}
	public void setSchoolBadgePath(String schoolBadgePath) {
		this.schoolBadgePath = schoolBadgePath;
	}

	public Integer getKeySubjectCount() {
		return keySubjectCount;
	}
	public void setKeySubjectCount(Integer keySubjectCount) {
		this.keySubjectCount = keySubjectCount;
	}
	public Integer getMasterPointCount() {
		return masterPointCount;
	}
	public void setMasterPointCount(Integer masterPointCount) {
		this.masterPointCount = masterPointCount;
	}
	public Integer getDoctorPointCount() {
		return doctorPointCount;
	}
	public void setDoctorPointCount(Integer doctorPointCount) {
		this.doctorPointCount = doctorPointCount;
	}

	public Integer getSchoolOrderNum() {
		return schoolOrderNum;
	}
	public void setSchoolOrderNum(Integer schoolOrderNum) {
		this.schoolOrderNum = schoolOrderNum;
	}
	public Integer getProvinceOrderNum() {
		return provinceOrderNum;
	}
	public void setProvinceOrderNum(Integer provinceOrderNum) {
		this.provinceOrderNum = provinceOrderNum;
	}
	public Integer getLevelOrderNum() {
		return levelOrderNum;
	}
	public void setLevelOrderNum(Integer levelOrderNum) {
		this.levelOrderNum = levelOrderNum;
	}
	public Integer getCategoryOrderNum() {
		return categoryOrderNum;
	}
	public void setCategoryOrderNum(Integer categoryOrderNum) {
		this.categoryOrderNum = categoryOrderNum;
	}
	public String getScrq() {
		return scrq;
	}
	public void setScrq(String scrq) {
		this.scrq = scrq;
	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public List<String> getAttrStrList() {
		return attrStrList;
	}

	public void setAttrStrList(List<String> attrStrList) {
		this.attrStrList = attrStrList;
	}


}
