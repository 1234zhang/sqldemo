package com.example.sqldemo.aspect;

import com.example.sqldemo.entity.Result;
import com.example.sqldemo.handle.ExceptionHandle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Brandon.
 * @date 2019/4/3.
 * @time 10:44.
 */

@Aspect
@Component
@Order(2)
public class ExceptionAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionAspect.class);

    @Autowired
    ExceptionHandle exceptionHandle;
    @Pointcut("execution(public * com.example.sqldemo.controller.*.*(..))")
    public void log(){}
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info("url={}",request.getRequestURI());
        LOGGER.info("method={}",request.getMethod());
        LOGGER.info("id={}",request.getRemoteAddr());
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        LOGGER.info("args={}",joinPoint.getArgs());
    }
    @Around("log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        }catch(Exception e){
            return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else{
            return result;
        }
    }
    @AfterReturning(value = "log()",returning = "object")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}",object.toString());
    }
}
