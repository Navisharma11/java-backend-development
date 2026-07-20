package main;

//class Alpha
//{
//    public void alpha()
//    {
//        //statements
//        //logic
//    }
//}
//
//class Beta //extends Alpha
//{
//    public void beta()
//    {

import service.Java;
import service.SpringBoot;
import service.Telusko;

////        Alpha a = new Alpha();
////        a.alpha();
////        alpha();
//    }
//}


public class LaunchApp
{
    public static void main(String[] args)
    {
        //Constructor Injecction
        Telusko t = new Telusko(new Java()); // target class

//        Java java = new Java();

//        t.setCourse(new Java());

        //setter injection
          t.setCourse(new SpringBoot()); // Dependency Injection --> Injecting dependent object into target class

        Boolean status = t.buyTheCourse(4545.5);
        if(status)
            System.out.println("Course Enrolled Successfully");
        else
            System.out.println("Failed to enroll for the course");
    }
}
