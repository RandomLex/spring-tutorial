package com.barzykin.aop;

import com.barzykin.model.Payment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@PropertySource("classpath:currency.properties")
public class CurrencyConvertorAspect {
    @Value("${oneToTen}")
    private int coefficient;

    @Pointcut("@annotation(com.barzykin.aop.OneToTen) ")
    public void convertor() {
        //pointcut
    }

    @AfterReturning(value = "convertor()", returning = "result")
    public void after(List<Payment> result) {
        System.out.println(result);
        for (Payment payment : result) {
            payment.setAmount(payment.getAmount() * coefficient);
        }
    }
}
