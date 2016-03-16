package org.smart4j;

import org.smart4j.cglib.CGLibDynamicProxy;
import org.smart4j.cglib.CGLibProxy;
import org.smart4j.dynamic.DynamicProxy;
import org.smart4j.staticproxy.Hello;
import org.smart4j.staticproxy.HelloImpl;
import org.smart4j.staticproxy.HelloProxy;

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
    }
}
