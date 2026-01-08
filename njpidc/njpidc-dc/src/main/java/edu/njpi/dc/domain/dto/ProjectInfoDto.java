package edu.njpi.dc.domain.dto;

import edu.njpi.dc.common.utils.DateFormatValidator;
import edu.njpi.dc.common.utils.StringSplitUtils;
import edu.njpi.dc.domain.enums.ProjectSubTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * 项目信息DTO
 * 用于接收和验证项目相关数据
 */
public class ProjectInfoDto {
    
    /** 项目名称(全称) */
    private String projectName;
    
    /** 项目种类 */
    private String projectType;
    
    /** 项目子类 */
    private String projectSubType;
    
    /** 是否来源企业 */
    private Boolean fromEnterprise;
    
    /** 来源企业名称 */
    private String enterpriseName;
    
    /** 奖助范围(多部门用逗号分隔) */
    private String awardScope;
    
    /** 奖助金额(万元) */
    private Double awardAmount;
    
    /** 奖助人数 */
    private Integer awardPeople;
    
    /** 填报人 */
    private String reporter;
    
    /** 开始日期(支持多种格式) */
    private String startDate;
    
    /** 结束日期(支持多种格式) */
    private String endDate;
    
    // Getters and Setters
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getProjectType() {
        return projectType;
    }
    
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    
    public String getProjectSubType() {
        return projectSubType;
    }
    
    public void setProjectSubType(String projectSubType) {
        this.projectSubType = projectSubType;
    }
    
    public Boolean getFromEnterprise() {
        return fromEnterprise;
    }
    
    public void setFromEnterprise(Boolean fromEnterprise) {
        this.fromEnterprise = fromEnterprise;
    }
    
    public String getEnterpriseName() {
        return enterpriseName;
    }
    
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    public String getAwardScope() {
        return awardScope;
    }
    
    public void setAwardScope(String awardScope) {
        this.awardScope = awardScope;
    }
    
    public Double getAwardAmount() {
        return awardAmount;
    }
    
    public void setAwardAmount(Double awardAmount) {
        this.awardAmount = awardAmount;
    }
    
    public Integer getAwardPeople() {
        return awardPeople;
    }
    
    public void setAwardPeople(Integer awardPeople) {
        this.awardPeople = awardPeople;
    }
    
    public String getReporter() {
        return reporter;
    }
    
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    /**
     * 验证数据
     * @return 错误信息,无错误返回null
     */
    public String validate() {
        // 验证项目名称
        if (projectName == null || projectName.trim().isEmpty()) {
            return "项目名称不能为空";
        }
        
        // 验证项目种类
        if (projectType == null || projectType.trim().isEmpty()) {
            return "项目种类不能为空";
        }
        
        // 验证项目子类
        if (projectSubType == null || projectSubType.trim().isEmpty()) {
            return "项目子类不能为空";
        }
        
        // 验证企业信息
        ProjectSubTypeEnum subTypeEnum = ProjectSubTypeEnum.fromCode(projectSubType);
        if (subTypeEnum != null && subTypeEnum.needsEnterprise()) {
            if (enterpriseName == null || enterpriseName.trim().isEmpty()) {
                return "项目子类为企业奖学金或企业助学金时,必须选择来源企业";
            }
        }
        
        // 验证日期格式
        if (startDate != null && !startDate.trim().isEmpty()) {
            if (!DateFormatValidator.isValidDate(startDate)) {
                return "开始日期格式不正确,支持格式: yyyy-MM-dd、yyyy-MM、yyyy等";
            }
        }
        
        if (endDate != null && !endDate.trim().isEmpty()) {
            if (!DateFormatValidator.isValidDate(endDate)) {
                return "结束日期格式不正确,支持格式: yyyy-MM-dd、yyyy-MM、yyyy等";
            }
        }
        
        // 验证金额
        if (awardAmount != null && awardAmount < 0) {
            return "奖助金额不能为负数";
        }
        
        // 验证人数
        if (awardPeople != null && awardPeople < 0) {
            return "奖助人数不能为负数";
        }
        
        return null;
    }
    
    /**
     * 获取解析后的开始日期
     */
    public Date getParsedStartDate() {
        return DateFormatValidator.parseDate(startDate);
    }
    
    /**
     * 获取解析后的结束日期
     */
    public Date getParsedEndDate() {
        return DateFormatValidator.parseDate(endDate);
    }
    
    /**
     * 获取分隔后的奖助范围列表
     */
    public List<String> getScopeList() {
        return StringSplitUtils.splitByComma(awardScope);
    }
}
