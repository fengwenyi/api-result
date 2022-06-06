package com.fengwenyi.api.result;

/**
 * 字符串工具类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.5.2
 */
public class StringUtils {

    /**
     * 字符串判空
     * @param str 待判断的字符串
     * @return 判断结果
     */
    public static boolean isBlank(String str) {
        if (null == str) {
            return true;
        }
        if (str.isEmpty()) {
            return true;
        }
        if ("".equals(str.trim())) {
            return true;
        }
        if ("null".equalsIgnoreCase(str.trim())) {
            return true;
        }
        int strLen = str.length();
        char c;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(c = str.charAt(i)) && c != '\u0000') {
                return false;
            }
        }
        return true;
    }

}
