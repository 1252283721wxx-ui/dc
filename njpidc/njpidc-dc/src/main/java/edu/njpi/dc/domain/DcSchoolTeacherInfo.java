package edu.njpi.dc.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 1.4.1_校内教师基本信息对象 dc_school_teacher_info
 * 
 * @author njpidc
 * @date 2025-12-10
 */
public class DcSchoolTeacherInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 院系部名称 */
    @Excel(name = "院系部名称")
    private String departmentName;

    /** 教工号 */
    @Excel(name = "教工号")
    private String staffNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

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

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String staffType;

    /** 所任职务 */
    @Excel(name = "所任职务")
    private String position;

    /** 专业领域 */
    @Excel(name = "专业领域")
    private String majorField;

    /** 专业特长 */
    @Excel(name = "专业特长")
    private String specialty;

    /** 是否拥有高校教师资格证书 */
    @Excel(name = "是否拥有高校教师资格证书")
    private String hasTeacherCert;

    /** 高校教师资格证书发证单位（全称） */
    @Excel(name = "高校教师资格证书发证单位", readConverterExp = "全=称")
    private String teacherCertOrg;

    /** 高校教师资格证书获取日期（年月） */
    @Excel(name = "高校教师资格证书获取日期", readConverterExp = "年=月")
    private String teacherCertDate;

    /** 职务等级 */
    @Excel(name = "职务等级")
    private String professionalRank;

    /** 专业技术职务名称(最高) */
    @Excel(name = "专业技术职务名称(最高)")
    private String professionalTitle;

    /** 专业技术职务发证单位（全称） */
    @Excel(name = "专业技术职务发证单位", readConverterExp = "全=称")
    private String professionalCertOrg;

    /** 专业技术职务获取日期（年月） */
    @Excel(name = "专业技术职务获取日期", readConverterExp = "年=月")
    private String professionalCertDate;

    /** 证书等级 */
    @Excel(name = "证书等级")
    private String certLevel;

    /** 职业资格证书名称(最高) */
    @Excel(name = "职业资格证书名称(最高)")
    private String certName;

    /** 职业资格证书发证单位（全称） */
    @Excel(name = "职业资格证书发证单位", readConverterExp = "全=称")
    private String certOrg;

    /** 职业资格证书获取日期（年月） */
    @Excel(name = "职业资格证书获取日期", readConverterExp = "年=月")
    private String certDate;

    /** 是否专业教师 */
    @Excel(name = "是否专业教师")
    private String isMajorTeacher;

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

    /** 是否公共课教师 */
    @Excel(name = "是否公共课教师")
    private String isPublicCourseTeacher;

    /** 所任公共课程 */
    @Excel(name = "所任公共课程")
    private String publicCourseName;

    /** 是否为双师型教师 */
    @Excel(name = "是否为双师型教师")
    private String doubleQualification;

    /** 教学名师 */
    @Excel(name = "教学名师")
    private String teachingMaster;

    /** 是否专职思政课教师 */
    @Excel(name = "是否专职思政课教师")
    private String isFulltimeIdeological;

    /** 是否兼职思政课教师 */
    @Excel(name = "是否兼职思政课教师")
    private String isParttimeIdeological;

    /** 是否专职辅导员 */
    @Excel(name = "是否专职辅导员")
    private String isFulltimeCounselor;

    /** 是否兼职辅导员 */
    @Excel(name = "是否兼职辅导员")
    private String isParttimeCounselor;

    /** 是否专职心理健康教师 */
    @Excel(name = "是否专职心理健康教师")
    private String isFulltimePsychology;

    /** 是否兼职心理健康教师 */
    @Excel(name = "是否兼职心理健康教师")
    private String isParttimePsychology;

    /** 是否专业带头人 */
    @Excel(name = "是否专业带头人")
    private String isMajorLeader;

    /** 是，担任年限（年） */
    @Excel(name = "是，担任年限", readConverterExp = "年=")
    private Long majorLeaderYears;

    /** 是否专业（群）负责人 */
    @Excel(name = "是否专业", readConverterExp = "群=")
    private String majorGroupLeader;

    /** 是，年限（年） */
    @Excel(name = "是，年限", readConverterExp = "年=")
    private Long majorGroupLeaderYears;

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

    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
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

    public void setStaffType(String staffType) 
    {
        this.staffType = staffType;
    }

    public String getStaffType() 
    {
        return staffType;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setMajorField(String majorField) 
    {
        this.majorField = majorField;
    }

    public String getMajorField() 
    {
        return majorField;
    }

    public void setSpecialty(String specialty) 
    {
        this.specialty = specialty;
    }

    public String getSpecialty() 
    {
        return specialty;
    }

    public void setHasTeacherCert(String hasTeacherCert) 
    {
        this.hasTeacherCert = hasTeacherCert;
    }

    public String getHasTeacherCert() 
    {
        return hasTeacherCert;
    }

    public void setTeacherCertOrg(String teacherCertOrg) 
    {
        this.teacherCertOrg = teacherCertOrg;
    }

    public String getTeacherCertOrg() 
    {
        return teacherCertOrg;
    }

    public void setTeacherCertDate(String teacherCertDate) 
    {
        this.teacherCertDate = teacherCertDate;
    }

    public String getTeacherCertDate() 
    {
        return teacherCertDate;
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

    public void setIsMajorTeacher(String isMajorTeacher) 
    {
        this.isMajorTeacher = isMajorTeacher;
    }

    public String getIsMajorTeacher() 
    {
        return isMajorTeacher;
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

    public void setIsPublicCourseTeacher(String isPublicCourseTeacher) 
    {
        this.isPublicCourseTeacher = isPublicCourseTeacher;
    }

    public String getIsPublicCourseTeacher() 
    {
        return isPublicCourseTeacher;
    }

    public void setPublicCourseName(String publicCourseName) 
    {
        this.publicCourseName = publicCourseName;
    }

    public String getPublicCourseName() 
    {
        return publicCourseName;
    }

    public void setDoubleQualification(String doubleQualification) 
    {
        this.doubleQualification = doubleQualification;
    }

    public String getDoubleQualification() 
    {
        return doubleQualification;
    }

    public void setTeachingMaster(String teachingMaster) 
    {
        this.teachingMaster = teachingMaster;
    }

    public String getTeachingMaster() 
    {
        return teachingMaster;
    }

    public void setIsFulltimeIdeological(String isFulltimeIdeological) 
    {
        this.isFulltimeIdeological = isFulltimeIdeological;
    }

    public String getIsFulltimeIdeological() 
    {
        return isFulltimeIdeological;
    }

    public void setIsParttimeIdeological(String isParttimeIdeological) 
    {
        this.isParttimeIdeological = isParttimeIdeological;
    }

    public String getIsParttimeIdeological() 
    {
        return isParttimeIdeological;
    }

    public void setIsFulltimeCounselor(String isFulltimeCounselor) 
    {
        this.isFulltimeCounselor = isFulltimeCounselor;
    }

    public String getIsFulltimeCounselor() 
    {
        return isFulltimeCounselor;
    }

    public void setIsParttimeCounselor(String isParttimeCounselor) 
    {
        this.isParttimeCounselor = isParttimeCounselor;
    }

    public String getIsParttimeCounselor() 
    {
        return isParttimeCounselor;
    }

    public void setIsFulltimePsychology(String isFulltimePsychology) 
    {
        this.isFulltimePsychology = isFulltimePsychology;
    }

    public String getIsFulltimePsychology() 
    {
        return isFulltimePsychology;
    }

    public void setIsParttimePsychology(String isParttimePsychology) 
    {
        this.isParttimePsychology = isParttimePsychology;
    }

    public String getIsParttimePsychology() 
    {
        return isParttimePsychology;
    }

    public void setIsMajorLeader(String isMajorLeader) 
    {
        this.isMajorLeader = isMajorLeader;
    }

    public String getIsMajorLeader() 
    {
        return isMajorLeader;
    }

    public void setMajorLeaderYears(Long majorLeaderYears) 
    {
        this.majorLeaderYears = majorLeaderYears;
    }

    public Long getMajorLeaderYears() 
    {
        return majorLeaderYears;
    }

    public void setMajorGroupLeader(String majorGroupLeader) 
    {
        this.majorGroupLeader = majorGroupLeader;
    }

    public String getMajorGroupLeader() 
    {
        return majorGroupLeader;
    }

    public void setMajorGroupLeaderYears(Long majorGroupLeaderYears) 
    {
        this.majorGroupLeaderYears = majorGroupLeaderYears;
    }

    public Long getMajorGroupLeaderYears() 
    {
        return majorGroupLeaderYears;
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
            .append("idNumber", getIdNumber())
            .append("birthday", getBirthday())
            .append("politicalStatus", getPoliticalStatus())
            .append("nation", getNation())
            .append("education", getEducation())
            .append("degree", getDegree())
            .append("staffType", getStaffType())
            .append("position", getPosition())
            .append("majorField", getMajorField())
            .append("specialty", getSpecialty())
            .append("hasTeacherCert", getHasTeacherCert())
            .append("teacherCertOrg", getTeacherCertOrg())
            .append("teacherCertDate", getTeacherCertDate())
            .append("professionalRank", getProfessionalRank())
            .append("professionalTitle", getProfessionalTitle())
            .append("professionalCertOrg", getProfessionalCertOrg())
            .append("professionalCertDate", getProfessionalCertDate())
            .append("certLevel", getCertLevel())
            .append("certName", getCertName())
            .append("certOrg", getCertOrg())
            .append("certDate", getCertDate())
            .append("isMajorTeacher", getIsMajorTeacher())
            .append("adminMajorName", getAdminMajorName())
            .append("adminMajorCode", getAdminMajorCode())
            .append("adminMajorLevel", getAdminMajorLevel())
            .append("adminMajorCategory", getAdminMajorCategory())
            .append("isPublicCourseTeacher", getIsPublicCourseTeacher())
            .append("publicCourseName", getPublicCourseName())
            .append("doubleQualification", getDoubleQualification())
            .append("teachingMaster", getTeachingMaster())
            .append("isFulltimeIdeological", getIsFulltimeIdeological())
            .append("isParttimeIdeological", getIsParttimeIdeological())
            .append("isFulltimeCounselor", getIsFulltimeCounselor())
            .append("isParttimeCounselor", getIsParttimeCounselor())
            .append("isFulltimePsychology", getIsFulltimePsychology())
            .append("isParttimePsychology", getIsParttimePsychology())
            .append("isMajorLeader", getIsMajorLeader())
            .append("majorLeaderYears", getMajorLeaderYears())
            .append("majorGroupLeader", getMajorGroupLeader())
            .append("majorGroupLeaderYears", getMajorGroupLeaderYears())
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
