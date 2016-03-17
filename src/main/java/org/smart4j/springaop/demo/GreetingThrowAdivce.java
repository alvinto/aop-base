package org.smart4j.springaop.demo;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Spring AOP 抛出增强
 * Created by alvin on 2016/3/17.
 */
@Component
public class GreetingThrowAdivce implements ThrowsAdvice{
    public void afterThrowing(Method method,Object[] objects,Object target,Exception e){
        System.out.println("----Throw Exception----");
        System.out.println("target class:"+target.getClass().getSimpleName());
        System.out.println("method name:"+method.getName());
        System.out.println("exception message:"+e.getMessage());
        System.out.println("------------------------");
    }
}
