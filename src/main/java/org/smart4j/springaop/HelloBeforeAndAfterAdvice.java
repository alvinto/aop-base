package org.smart4j.springaop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by alvin on 2016/3/16.
 */
public class HelloBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("before");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("after");
    }
}
