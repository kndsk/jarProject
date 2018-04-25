package com.whty.model;



public class XgkSchoolCourseInfoDto implements java.io.Serializable{

    private String id;
    private String schoolId;
    private String provinceId;
    private String schoolCode;
    private String selectCourse;
    private String profession;
    private String professionChild;
    private String professionArrangement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public String getSelectCourse() {
        return selectCourse;
    }

    public void setSelectCourse(String selectCourse) {
        this.selectCourse = selectCourse;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessionChild() {
        return professionChild;
    }

    public void setProfessionChild(String professionChild) {
        this.professionChild = professionChild;
    }

    public String getProfessionArrangement() {
        return professionArrangement;
    }

    public void setProfessionArrangement(String professionArrangement) {
        this.professionArrangement = professionArrangement;
    }
}
