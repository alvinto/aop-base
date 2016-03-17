package org.smart4j.springaop.demo;

import org.aopalliance.intercept.MethodInvocation;
import org.smart4j.springaop.Apology;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * 引入
 * GreetingImpl不直接实现Apology，而在程序运行时动态实现它
 * Created by alvin on 2016/3/17.
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry ! " + name);
    }
}
