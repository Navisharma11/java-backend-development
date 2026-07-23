package com.navi.main;

import com.navi.main.config.JavaConfiguration;
import com.navi.main.service.Greetings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaunchApp1
{
    public static void main(String[] args)
    {
        //BeanFactory
        //ApplicationContext

        ApplicationContext container = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        Greetings greet = container.getBean(Greetings.class);

        System.out.println(greet.generateGreetings("Navi Sharma"));

    }
}
