package edu.njpi.dc.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 1.4.2_校外教师基本情况对象 dc_external_teacher_info
 * 
 * @author njpidc
 * @date 2025-12-10
 */
public class DcExternalTeacherInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 院系部名称 */
    @Excel(name = "院系部名称")
    private String departmentName;

    /** 编（工）号 */
    @Excel(name = "编", readConverterExp = "工=")
    private String staffNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalStatus;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 学位 */
    @Excel(name = "学位")
    private String degree;

    /** 职务 */
    @Excel(name = "职务")
    private String position;

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String staffType;

    /** 工作单位名称(全称) */
    @Excel(name = "工作单位名称(全称)")
    private String workUnit;

    /** 参加工作日期（年月） */
    @Excel(name = "参加工作日期", readConverterExp = "年=月")
    private String workStartDate;

    /** 人才项目级别 */
    @Excel(name = "人才项目级别")
    private String talentLevel;

    /** 人才项目称号 */
    @Excel(name = "人才项目称号")
    private String talentTitle;

    /** 签约情况 */
    @Excel(name = "签约情况")
    private String signStatus;

    /** 职务等级 */
    @Excel(name = "职务等级")
    private String professionalRank;

    /** 专业技术职务名称(最高) */
    @Excel(name = "专业技术职务名称(最高)")
    private String professionalTitle;

    /** 发证单位（全称） */
    @Excel(name = "发证单位", readConverterExp = "全=称")
    private String professionalCertOrg;

    /** 获取日期（年月） */
    @Excel(name = "获取日期", readConverterExp = "年=月")
    private String professionalCertDate;

    /** 证书等级 */
    @Excel(name = "证书等级")
    private String certLevel;

    /** 证书名称(最高) */
    @Excel(name = "证书名称(最高)")
    private String certName;

    /** 发证单位（全称） */
    @Excel(name = "发证单位", readConverterExp = "全=称")
    private String certOrg;

    /** 获取日期（年月） */
    @Excel(name = "获取日期", readConverterExp = "年=月")
    private String certDate;

    /** 是否有行政所属专业 */
    @Excel(name = "是否有行政所属专业")
    private String hasAdminMajor;

    /** 行政所属专业名称 */
    @Excel(name = "行政所属专业名称")
    private String adminMajorName;

    /** 行政所属专业代码 */
    @Excel(name = "行政所属专业代码")
    private String adminMajorCode;

    /** 行政所属专业层次 */
    @Excel(name = "行政所属专业层次")
    private String adminMajorLevel;

    /** 行政所属专业大类 */
    @Excel(name = "行政所属专业大类")
    private String adminMajorCategory;

    /** 是否专业带头人 */
    @Excel(name = "是否专业带头人")
    private String isMajorLeader;

    /** 是，担任年限 */
    @Excel(name = "是，担任年限")
    private Long leaderYears;

    /** 填报人 */
    @Excel(name = "填报人")
    private String reporterName;

    /** 状态（0待提交 1待部门审核 2待系统审核 3审核通过 4已退回） */
    @Excel(name = "状态", readConverterExp = "0=待提交,1=待部门审核,2=待系统审核,3=审核通过,4=已退回")
    private String status;

    /** 当前审核级别（1部门级 2系统级 3已完成） */
    @Excel(name = "当前审核级别", readConverterExp = "1=部门级,2=系统级,3=已完成")
    private Long currentLevel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }

    public void setStaffNo(String staffNo) 
    {
        this.staffNo = staffNo;
    }

    public String getStaffNo() 
    {
        return staffNo;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public void setPoliticalStatus(String politicalStatus) 
    {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatus() 
    {
        return politicalStatus;
    }

    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }

    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }

    public void setDegree(String degree) 
    {
        this.degree = degree;
    }

    public String getDegree() 
    {
        return degree;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setStaffType(String staffType) 
    {
        this.staffType = staffType;
    }

    public String getStaffType() 
    {
        return staffType;
    }

    public void setWorkUnit(String workUnit) 
    {
        this.workUnit = workUnit;
    }

    public String getWorkUnit() 
    {
        return workUnit;
    }

    public void setWorkStartDate(String workStartDate) 
    {
        this.workStartDate = workStartDate;
    }

    public String getWorkStartDate() 
    {
        return workStartDate;
    }

    public void setTalentLevel(String talentLevel) 
    {
        this.talentLevel = talentLevel;
    }

    public String getTalentLevel() 
    {
        return talentLevel;
    }

    public void setTalentTitle(String talentTitle) 
    {
        this.talentTitle = talentTitle;
    }

    public String getTalentTitle() 
    {
        return talentTitle;
    }

    public void setSignStatus(String signStatus) 
    {
        this.signStatus = signStatus;
    }

    public String getSignStatus() 
    {
        return signStatus;
    }

    public void setProfessionalRank(String professionalRank) 
    {
        this.professionalRank = professionalRank;
    }

    public String getProfessionalRank() 
    {
        return professionalRank;
    }

    public void setProfessionalTitle(String professionalTitle) 
    {
        this.professionalTitle = professionalTitle;
    }

    public String getProfessionalTitle() 
    {
        return professionalTitle;
    }

    public void setProfessionalCertOrg(String professionalCertOrg) 
    {
        this.professionalCertOrg = professionalCertOrg;
    }

    public String getProfessionalCertOrg() 
    {
        return professionalCertOrg;
    }

    public void setProfessionalCertDate(String professionalCertDate) 
    {
        this.professionalCertDate = professionalCertDate;
    }

    public String getProfessionalCertDate() 
    {
        return professionalCertDate;
    }

    public void setCertLevel(String certLevel) 
    {
        this.certLevel = certLevel;
    }

    public String getCertLevel() 
    {
        return certLevel;
    }

    public void setCertName(String certName) 
    {
        this.certName = certName;
    }

    public String getCertName() 
    {
        return certName;
    }

    public void setCertOrg(String certOrg) 
    {
        this.certOrg = certOrg;
    }

    public String getCertOrg() 
    {
        return certOrg;
    }

    public void setCertDate(String certDate) 
    {
        this.certDate = certDate;
    }

    public String getCertDate() 
    {
        return certDate;
    }

    public void setHasAdminMajor(String hasAdminMajor) 
    {
        this.hasAdminMajor = hasAdminMajor;
    }

    public String getHasAdminMajor() 
    {
        return hasAdminMajor;
    }

    public void setAdminMajorName(String adminMajorName) 
    {
        this.adminMajorName = adminMajorName;
    }

    public String getAdminMajorName() 
    {
        return adminMajorName;
    }

    public void setAdminMajorCode(String adminMajorCode) 
    {
        this.adminMajorCode = adminMajorCode;
    }

    public String getAdminMajorCode() 
    {
        return adminMajorCode;
    }

    public void setAdminMajorLevel(String adminMajorLevel) 
    {
        this.adminMajorLevel = adminMajorLevel;
    }

    public String getAdminMajorLevel() 
    {
        return adminMajorLevel;
    }

    public void setAdminMajorCategory(String adminMajorCategory) 
    {
        this.adminMajorCategory = adminMajorCategory;
    }

    public String getAdminMajorCategory() 
    {
        return adminMajorCategory;
    }

    public void setIsMajorLeader(String isMajorLeader) 
    {
        this.isMajorLeader = isMajorLeader;
    }

    public String getIsMajorLeader() 
    {
        return isMajorLeader;
    }

    public void setLeaderYears(Long leaderYears) 
    {
        this.leaderYears = leaderYears;
    }

    public Long getLeaderYears() 
    {
        return leaderYears;
    }

    public void setReporterName(String reporterName) 
    {
        this.reporterName = reporterName;
    }

    public String getReporterName() 
    {
        return reporterName;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setCurrentLevel(Long currentLevel) 
    {
        this.currentLevel = currentLevel;
    }

    public Long getCurrentLevel() 
    {
        return currentLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("departmentName", getDepartmentName())
            .append("staffNo", getStaffNo())
            .append("name", getName())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("politicalStatus", getPoliticalStatus())
            .append("nation", getNation())
            .append("education", getEducation())
            .append("degree", getDegree())
            .append("position", getPosition())
            .append("staffType", getStaffType())
            .append("workUnit", getWorkUnit())
            .append("workStartDate", getWorkStartDate())
            .append("talentLevel", getTalentLevel())
            .append("talentTitle", getTalentTitle())
            .append("signStatus", getSignStatus())
            .append("professionalRank", getProfessionalRank())
            .append("professionalTitle", getProfessionalTitle())
            .append("professionalCertOrg", getProfessionalCertOrg())
            .append("professionalCertDate", getProfessionalCertDate())
            .append("certLevel", getCertLevel())
            .append("certName", getCertName())
            .append("certOrg", getCertOrg())
            .append("certDate", getCertDate())
            .append("hasAdminMajor", getHasAdminMajor())
            .append("adminMajorName", getAdminMajorName())
            .append("adminMajorCode", getAdminMajorCode())
            .append("adminMajorLevel", getAdminMajorLevel())
            .append("adminMajorCategory", getAdminMajorCategory())
            .append("isMajorLeader", getIsMajorLeader())
            .append("leaderYears", getLeaderYears())
            .append("reporterName", getReporterName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("currentLevel", getCurrentLevel())
            .append("remark", getRemark())
            .toString();
    }
}
