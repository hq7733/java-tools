package com.htools.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hq
 * @date 2023/8/14
 */

@Component
@Aspect
public class ExecutionTime {

    private final Logger logger = LoggerFactory.getLogger(ExecutionTime.class);

    @Around("@annotation(com.htools.aop.StatisticsTime)")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method: {}, executed in {}ms", joinPoint.getSignature().getName(), (endTime - startTime));
        return result;
    }
}
