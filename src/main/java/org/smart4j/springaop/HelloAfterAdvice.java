package org.smart4j.springaop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后增强式
 * Created by alvin on 2016/3/16.
 */
public class HelloAfterAdvice implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after");
    }
}
