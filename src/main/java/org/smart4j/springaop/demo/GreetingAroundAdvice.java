package org.smart4j.springaop.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 环绕增强类
 * Created by alvin on 2016/3/17.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }
    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}
