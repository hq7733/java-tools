package com.htools.util;

/**
 * @author hq
 * @date 2023/8/10
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public boolean notEmpty(String str) {
        return !isEmpty(str);
    }
}
