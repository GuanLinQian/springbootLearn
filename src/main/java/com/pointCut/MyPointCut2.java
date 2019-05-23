package com.pointCut;

import com.redis.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
public class MyPointCut2 {
    @Autowired
    private RedisUtil redisUtil;
@Pointcut("execution(* com.service.*.del*(..))")
    public void pointCut1(){

}
@AfterReturning("pointCut1()")
    public void test(JoinPoint joinPoint){
      //  String dimKey=joinPoint.getSignature().getName();
        redisUtil.dimDel("*Stu*");

}



}

