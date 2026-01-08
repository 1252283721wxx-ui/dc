package edu.njpi.dc.domain.enums;

/**
 * 项目种类枚举
 */
public enum ProjectTypeEnum {
    
    SCHOLARSHIP("奖学金", "奖学金"),
    FINANCIAL_AID("助学金", "助学金"),
    HARDSHIP_SUBSIDY("困难补助", "困难补助"),
    WORK_STUDY("勤工俭学", "勤工俭学"),
    STUDENT_LOAN("助学贷款", "助学贷款"),
    TUITION_WAIVER("减免学杂费", "减免学杂费");
    
    private final String code;
    private final String desc;
    
    ProjectTypeEnum(String code, String desc) {
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
     * 根据code获取枚举
     */
    public static ProjectTypeEnum fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        for (ProjectTypeEnum type : ProjectTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
