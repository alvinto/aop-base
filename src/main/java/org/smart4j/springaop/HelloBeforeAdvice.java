package org.smart4j.springaop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前增强式
 * Created by alvin on 2016/3/16.
 */
public class HelloBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}
