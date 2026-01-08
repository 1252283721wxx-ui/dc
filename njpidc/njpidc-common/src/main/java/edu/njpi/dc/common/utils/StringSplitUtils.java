package edu.njpi.dc.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串分隔工具类
 * 支持中英文逗号混合分隔
 */
public class StringSplitUtils {
    
    /**
     * 分隔字符串,支持中英文逗号
     * @param input 输入字符串
     * @return 分隔后的列表
     */
    public static List<String> splitByComma(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        // 统一替换中文逗号为英文逗号
        String normalized = input.replace('，', ',');
        
        // 分隔并去除空格
        return Arrays.stream(normalized.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
    
    /**
     * 分隔部门字符串为ID列表
     * @param deptStr 部门字符串,用逗号分隔
     * @return 部门ID列表
     */
    public static List<Long> splitDeptIds(String deptStr) {
        List<String> parts = splitByComma(deptStr);
        List<Long> ids = new ArrayList<>();
        
        for (String part : parts) {
            try {
                ids.add(Long.parseLong(part));
            } catch (NumberFormatException e) {
                // 忽略无法解析的部分
            }
        }
        
        return ids;
    }
    
    /**
     * 将列表合并为字符串,使用中文逗号分隔
     * @param list 字符串列表
     * @return 合并后的字符串
     */
    public static String joinWithChineseComma(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return String.join("，", list);
    }
    
    /**
     * 将列表合并为字符串,使用英文逗号分隔
     * @param list 字符串列表
     * @return 合并后的字符串
     */
    public static String joinWithEnglishComma(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return String.join(",", list);
    }
}
