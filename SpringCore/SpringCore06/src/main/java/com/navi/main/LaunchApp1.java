package com.navi.main;

import com.navi.service.Telusko;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp1
{
    public static void main(String[] args)
    {
        //BeanFactory
        //ApplicationContext

        ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");

        Telusko t = container.getBean(Telusko.class);

        Boolean status = t.buyTheCourse(4545.5);
        if(status)
            System.out.println("Course Enrolled Successfully");
        else
            System.out.println("Failed to enroll for the course");
    }
}
