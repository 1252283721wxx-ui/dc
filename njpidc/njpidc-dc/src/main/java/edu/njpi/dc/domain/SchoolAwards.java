package edu.njpi.dc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 学校获奖（荣誉）情况对象 dc_school_awards
 *
 * @author njpidc
 * @date 2025-12-12
 */
public class SchoolAwards extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 项目(荣誉)名称(全称)
     */
    @Excel(name = "项目(荣誉)名称(全称)")
    private String projectName;

    /**
     * 类别
     */
    @Excel(name = "类别")
    private String category;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private String level;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private String grade;

    /**
     * 授奖单位（全称）
     */
    @Excel(name = "授奖单位", readConverterExp = "全=称")
    private String awardUnit;

    /**
     * 获奖(授予)日期（年月，格式yyyy-MM）
     */
    @Excel(name = "获奖(授予)日期", readConverterExp = "年=月，格式yyyy-MM")
    private String awardDate;

    /**
     * 完成人（多位用英文逗号分隔）
     */
    @Excel(name = "完成人", readConverterExp = "多=位用英文逗号分隔")
    private String participants;

    /**
     * 填报人
     */
    @Excel(name = "填报人")
    private String reporterName;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在 1=代表删除")
    private String delFlag;


    /**
     * 审核状态
     */
    @Excel(name = "审核状态")
    private String reviewStatus;


    /**
     * 关联的dm_review_item表id
     */
    private Long itemId;

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAwardUnit() {
        return awardUnit;
    }

    public void setAwardUnit(String awardUnit) {
        this.awardUnit = awardUnit;
    }

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("projectName", getProjectName())
                .append("category", getCategory())
                .append("level", getLevel())
                .append("grade", getGrade())
                .append("awardUnit", getAwardUnit())
                .append("awardDate", getAwardDate())
                .append("participants", getParticipants())
                .append("remark", getRemark())
                .append("reporterName", getReporterName())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
