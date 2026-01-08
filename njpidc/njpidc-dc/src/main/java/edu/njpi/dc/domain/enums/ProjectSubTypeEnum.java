package edu.njpi.dc.domain.enums;

/**
 * 项目子类枚举
 */
public enum ProjectSubTypeEnum {
    
    // 奖学金类
    NATIONAL_SCHOLARSHIP("国家奖学金", "国家奖学金"),
    NATIONAL_励志_SCHOLARSHIP("国家励志奖学金", "国家励志奖学金"),
    PROVINCIAL_SCHOLARSHIP("省奖学金", "省奖学金"),
    SCHOOL_SCHOLARSHIP("学校奖学金", "学校奖学金"),
    ENTERPRISE_SCHOLARSHIP("企业奖学金", "企业奖学金"),
    
    // 助学金类
    NATIONAL_GRANT("国家助学金", "国家助学金"),
    ENTERPRISE_GRANT("企业助学金", "企业助学金"),
    
    // 贷款类
    SOURCE_LOAN("生源地贷款", "生源地贷款"),
    LOVE_LOAN("爱心奖贷", "爱心奖贷"),
    
    // 补助类
    SPECIAL_SUBSIDY("特困补助", "特困补助"),
    MEAL_SUBSIDY("伙食补助", "伙食补助"),
    WORK_STUDY_PROGRAM("勤工俭学", "勤工俭学"),
    TUITION_REDUCTION("减免学杂费", "减免学杂费");
    
    private final String code;
    private final String desc;
    
    ProjectSubTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getDesc() {
        return desc;
    }
    
    /**
     * 判断是否需要选择企业
     */
    public boolean needsEnterprise() {
        return this == ENTERPRISE_SCHOLARSHIP || this == ENTERPRISE_GRANT;
    }
    
    /**
     * 根据code获取枚举
     */
    public static ProjectSubTypeEnum fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        for (ProjectSubTypeEnum type : ProjectSubTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
