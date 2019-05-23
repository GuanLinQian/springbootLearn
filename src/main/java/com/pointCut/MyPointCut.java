package com.pointCut;

import com.github.pagehelper.PageInfo;
import com.redis.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;


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

    String key=getkey(proceedingJoinPoint);
    if(!redisUtil.hasKey(key)){
            System.out.println("------------设置每页数据-----");
          Object  object= proceedingJoinPoint.proceed();
         redisUtil.set(key,object,20);
    }


return redisUtil.get(key);
}


public  String getkey(ProceedingJoinPoint proceedingJoinPoint){
    Object []args= proceedingJoinPoint.getArgs();
    String methodName=proceedingJoinPoint.getSignature().getName();

return  methodName+"_"+args[0]+"_"+args[1];
}
}

