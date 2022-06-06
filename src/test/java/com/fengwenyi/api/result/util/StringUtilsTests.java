package com.fengwenyi.api.result.util;

import com.fengwenyi.api.result.StringUtils;
import org.junit.Test;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-28
 */
public class StringUtilsTests {

    @Test
    public void testIsBlank() {
        System.out.println("===================== test isBlank =====================");
        System.out.println("null is " + StringUtils.isBlank(null));
        System.out.println("\"\" is " + StringUtils.isBlank(""));
        System.out.println("\" \" is " + StringUtils.isBlank(" "));
        System.out.println("\"null\" is " + StringUtils.isBlank("null"));
        System.out.println("\" null \" is " + StringUtils.isBlank(" null "));
        System.out.println("\\u0000 is " + StringUtils.isBlank("\u0000"));
    }

}
