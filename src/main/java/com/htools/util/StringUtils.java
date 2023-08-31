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

    public String removeDuplicates(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
