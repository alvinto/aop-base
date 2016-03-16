package org.smart4j.staticproxy;

/**
 * Created by alvin on 2016/3/16.
 */
public class HelloImpl implements Hello{

    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }

    public void talk(String name){
        System.out.println("Talk! " + name);
    }
}
