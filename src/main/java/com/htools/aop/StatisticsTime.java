package com.htools.aop;

import java.lang.annotation.*;

/**
 * @author hq
 * @date 2023/8/14
 */
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StatisticsTime {

}