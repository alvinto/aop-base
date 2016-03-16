package org.smart4j.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现单利模式
 * Created by alvin on 2016/3/16.
 */
public class CGLibDynamicProxy implements MethodInterceptor {

    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    public static CGLibDynamicProxy getInstance(){
        return instance;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
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
