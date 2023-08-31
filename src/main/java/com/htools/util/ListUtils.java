package com.htools.util;

import cn.hutool.core.collection.ListUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hq
 * @date 2023/8/31
 */
public class ListUtils {

    public static <T> void upset(List<T> list) {
        Collections.shuffle(list);
    }

    public static <T> String join(String delimiter,List<T> list) {
        return list.stream().map(String::valueOf).collect(Collectors.joining(delimiter));
    }
}
