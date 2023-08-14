package com.htools.util;

import cn.hutool.core.util.StrUtil;

/**
 * @author hq
 * @date 2023/8/10
 */
public class DesensitizationUtils {

    /**
     * 自由的脱敏
     *
     * @param str        待脱敏字符串
     * @param leftStart  左边开始位置
     * @param rightStart 右边开始位置
     * @return 脱敏后的字符串
     */
    public static String free(String str, int leftStart, int rightStart) {
        if (StrUtil.isBlank(str) || leftStart + rightStart > str.length()) {
            return "";
        }
        return hide(str, leftStart, rightStart);
    }

    /**
     * 全部脱敏
     *
     * @param str 待脱敏字符串
     * @return 脱敏后的字符串
     */
    public static String all(String str) {
        if (StrUtil.isBlank(str)) {
            return "";
        }
        return hide(str, 0, 0);
    }

    public static String hide(String str, int leftStart, int rightStart) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }

        int length = str.length();
        String[] split = str.split("");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            if (i >= leftStart && i < length - rightStart) {
                sb.append("*");
            } else {
                sb.append(split[i]);
            }
        }

        return sb.toString();
    }
}
