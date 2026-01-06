package edu.njpi.dc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 学生列表对象 dc_student
 * 
 * @author Yuu
 * @date 2025-10-24
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String stuName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 手机号 */
    @Excel(name = "手机号")
    private String tel;

    /** 年级 */
    @Excel(name = "年级")
    private Long grade;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    public void setStuNo(String stuNo) 
    {
        this.stuNo = stuNo;
    }

    public String getStuNo() 
    {
        return stuNo;
    }

    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }

    public void setGrade(Long grade) 
    {
        this.grade = grade;
    }

    public Long getGrade() 
    {
        return grade;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuNo", getStuNo())
            .append("stuName", getStuName())
            .append("gender", getGender())
            .append("tel", getTel())
            .append("grade", getGrade())
            .append("major", getMajor())
            .toString();
    }
}
