package com.pointCut;

import com.redis.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 时间:18:30
 * 作者：Maibenben
 **/
@Aspect
@Component
public class MyPointCut {
    @Autowired
    private RedisUtil redisUtil;
@Pointcut("execution(* com.service.*.get*(..))")
    public void pointCut1(){

}
@Around("pointCut1()")
    public Object test(ProceedingJoinPoint proceedingJoinPoint)throws  Throwable{
    String methodName=proceedingJoinPoint.getSignature().getName();
    if(!redisUtil.hasKey(methodName)){
            System.out.println("------------设置list-----");
            List<Object> list = (List<Object>) proceedingJoinPoint.proceed();
            redisUtil.lSet(methodName,list,10);
    }

return redisUtil.lGet(methodName,0,-1);
}
}
