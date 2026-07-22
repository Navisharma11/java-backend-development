package com.navi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Telusko
{
//    @Autowired
//    @Qualifier("java")
    private ICourse course;

//    @Autowired
//    public Telusko(@Qualifier("java") ICourse course)
//    {
//        super();
//        System.out.println("Constructor Injection");
//        this.course=course;
//    }

    public Telusko()
    {
        super();
        System.out.println("Telusko Bean Created");
    }

    @Autowired
    @Qualifier("springBoot")
    public void setCourse(ICourse course) { //ICourse course = new Java();
        System.out.println("Setter Injection");
        this.course = course;
    }

    public Boolean buyTheCourse(double amount)
    {
        return course.getTheCourse(amount);
    }

}
