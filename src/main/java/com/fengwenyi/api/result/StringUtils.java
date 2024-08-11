package com.fengwenyi.api.result;

import java.util.Objects;

/**
 * 字符串工具类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2.5.2
 */
class StringUtils {

    /**
     * 字符串判空
     * @param str 待判断的字符串
     * @return 判断结果
     */
    static boolean isBlank(String str) {
        if (Objects.isNull(str)) {
            return true;
        }
        if (str.isEmpty()) {
            return true;
        }
        if (str.trim().isEmpty()) {
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
