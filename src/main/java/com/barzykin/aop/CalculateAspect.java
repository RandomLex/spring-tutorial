package com.barzykin.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculateAspect {

    @Pointcut("execution(String com.barzykin.controllers.*.*(..)))")
    public void controller() {
        //pointcut
    }

    @Before("controller()")
    public void before(JoinPoint jp) {
        System.out.println("Before Started: " + jp.getSignature().getDeclaringTypeName() +
                " " + jp.getSignature().getName());
    }

    @After("controller()")
    public void after() {
        System.out.println("After calcController is finished");
    }

    @Around("controller()")
    @SneakyThrows
    public Object around(ProceedingJoinPoint jp) {
        System.out.println("Around started");
        int arg1 = (int) (jp.getArgs()[0]);
        jp.getArgs()[0] = arg1 * 10;
        Object proceed = jp.proceed() + "!";
        System.out.println("Around Finished");
        return proceed;
    }
}
