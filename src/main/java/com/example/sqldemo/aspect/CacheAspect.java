package com.example.sqldemo.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Brandon.
 * @date 2019/4/6.
 * @time 15:26.
 */

@Aspect
@Component
@Order(1)
public class CacheAspect {
    Gson gson = new Gson();
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Pointcut("execution(public * com.example.sqldemo.controller.*.*(..))")
    public void cache(){}
    @Around("cache()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj;
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String xh = request.getParameter("xh");
        if(stringRedisTemplate.opsForValue().get("xh") != null){
            return gson.fromJson(stringRedisTemplate.opsForValue().get("xh"),Object.class);
        }else{
            obj = proceedingJoinPoint.proceed();
        }
        return obj;
    }
    @AfterReturning(value = "cache()",returning = "object")
    public void afterReturning(JoinPoint joinPoint,Object object){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        stringRedisTemplate.opsForValue().set(request.getParameter("xh"),gson.toJson(object));
        stringRedisTemplate.expire(request.getParameter("xh"),2, TimeUnit.MINUTES);
    }
}
