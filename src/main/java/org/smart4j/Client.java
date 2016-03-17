package org.smart4j;

import org.smart4j.cglib.CGLibDynamicProxy;
import org.smart4j.cglib.CGLibProxy;
import org.smart4j.dynamic.DynamicProxy;
import org.smart4j.springaop.Apology;
import org.smart4j.springaop.Greeting;
import org.smart4j.springaop.demo.GreetingImpl;
import org.smart4j.staticproxy.Hello;
import org.smart4j.staticproxy.HelloImpl;
import org.smart4j.staticproxy.HelloProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Created by alvin on 2016/3/16.
 */
public class Client {
    public static void main(String[] args) {
        Hello hello = new HelloProxy();
        hello.say("Jay");

        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello hello1 = dynamicProxy.getProxy();
        hello1.say("tom");
//        HelloImpl helloImpl = (HelloImpl)hello1;
//        helloImpl.talk("tom");

        CGLibProxy cgLibProxy = new CGLibProxy();
        HelloImpl hello2 = cgLibProxy.getProxy(HelloImpl.class);
        hello2.say("cglib");
        hello2.talk("cglib");

        HelloImpl hello3 = CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        hello3.say("singleton");

        String basePath = System.getProperty("user.dir");
        System.out.println(basePath);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(basePath+"\\src\\applicationContext.xml");
        Greeting greeting = (Greeting) applicationContext.getBean("greetingProxy");
        greeting.say("spring aop");//调用代理的方法


        Greeting greeting1 = (Greeting) applicationContext.getBean("greetingIntroProxy");
        greeting1.say("Jack");
        //将目标类强制向上转型为Apology接口（这是引入增强给我们带来的特性，也就是 接口动态实现 功能）
        Apology apology = (Apology) greeting1;
        apology.saySorry("Introduction");

        //配置切面 只对指定方法拦截
        GreetingImpl greeting3 = (GreetingImpl) applicationContext.getBean("greetingAdvisorProxy");
        greeting3.say("Jack");
        greeting3.goodMorning("Jack");
        greeting3.goodNight("Jack");
    }
}
