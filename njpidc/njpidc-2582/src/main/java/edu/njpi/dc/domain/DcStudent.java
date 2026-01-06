package edu.njpi.dc.domain;


public class DcStudent {
    private String stuNo;
    private String stuName;
    private String gender;
    private String tel;
    private int grade;
    private String major;

    public DcStudent() {
    }

    public DcStudent(String major, int grade, String tel, String gender, String stuName, String stuNo) {
        this.major = major;
        this.grade = grade;
        this.tel = tel;
        this.gender = gender;
        this.stuName = stuName;
        this.stuNo = stuNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
