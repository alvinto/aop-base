package org.smart4j.springaop.demo;

import org.smart4j.springaop.Greeting;
import org.springframework.stereotype.Component;

/**
 * Created by alvin on 2016/3/16.
 */
@Component
public class GreetingImpl implements Greeting{
    @Override
    public void say(String name) {
        System.out.println("greeting = [" + name + "]");
//        throw new RuntimeException("Error");
    }

    public void goodMorning(String name){
        System.out.println("good morning " + name + "!");
    }

    public void goodNight(String name){
        System.out.println("good night " + name + "!");
    }
}
