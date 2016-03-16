package org.smart4j.staticproxy;

/**
 * 静态代理
 * Created by alvin on 2016/3/16.
 */
public class HelloProxy implements Hello {
    private HelloImpl hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}
