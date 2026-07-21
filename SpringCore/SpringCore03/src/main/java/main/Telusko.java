package main;

import service.ICourse;

public class Telusko
{
    private ICourse course;

    public Telusko(ICourse course)
    {
        super();
        System.out.println("Constructor Injection");
        this.course=course;
    }

    public Telusko()
    {
        super();
        System.out.println("Telusko Bean Created");
    }

    public void setCourse(ICourse course) { //ICourse course = new Java();
        System.out.println("Setter Injection");
        this.course = course;
    }

    public Boolean buyTheCourse(double amount)
    {
        return course.getTheCourse(amount);
    }

}
