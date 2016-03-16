package org.smart4j.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * jdk代理  不能代理没有任何接口的类
 * Created by alvin on 2016/3/16.
 */
public class DynamicProxy implements InvocationHandler{
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public  <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
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
