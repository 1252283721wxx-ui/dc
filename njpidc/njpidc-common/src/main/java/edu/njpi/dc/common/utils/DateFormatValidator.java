package edu.njpi.dc.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式验证工具类
 * 支持多种日期格式: yyyy-MM-dd HH:mm:ss, yyyy-MM-dd, yyyy-MM等
 */
public class DateFormatValidator {
    
    /**
     * 支持的日期格式
     */
    private static final String[] DATE_FORMATS = {
        "yyyy-MM-dd HH:mm:ss",
        "yyyy-MM-dd",
        "yyyy-MM",
        "yyyy"
    };
    
    /**
     * 验证并解析日期字符串
     * @param dateStr 日期字符串
     * @return 解析后的Date对象,解析失败返回null
     */
    public static Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        
        dateStr = dateStr.trim();
        
        for (String format : DATE_FORMATS) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false); // 严格模式
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                // 继续尝试下一个格式
            }
        }
        
        return null;
    }
    
    /**
     * 验证日期格式是否正确
     * @param dateStr 日期字符串
     * @return true-格式正确, false-格式错误
     */
    public static boolean isValidDate(String dateStr) {
        return parseDate(dateStr) != null;
    }
    
    /**
     * 格式化日期为指定格式
     * @param date 日期对象
     * @param format 目标格式
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
