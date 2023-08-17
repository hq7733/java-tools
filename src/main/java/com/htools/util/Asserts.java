package com.htools.util;

import org.springframework.lang.Nullable;

/**
 * @author hq
 * @date 2023/8/17
 */
public class Asserts {
    public static void check(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
