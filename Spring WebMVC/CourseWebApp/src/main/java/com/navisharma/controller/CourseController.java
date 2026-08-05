package com.navisharma.controller;

import com.navisharma.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController
{

    @GetMapping("/courseinfo")
    public String getCCourseInfo(Model model)
    {
        model.addAttribute("cid","T1");
        model.addAttribute("cname","DevOps");
        model.addAttribute("price","4999 INR");
        return "course";
    }

//    @GetMapping("/coursedetails")
//    public String getCCourseDetails(Model model)
//    {
//        Course course = new Course();
//        course.setCid(1);
//        course.setCname("DevOps with AWS");
//        course.setPrice(5999.9);
//        model.addAttribute("course",course);
//        return "coursedet";
//    }

    @GetMapping({"/coursedetails","/course","/info"})
    public String getCCourseDetails(Model model)
    {
        Course course = new Course();
        course.setCid(1);
        course.setCname("DevOps with AWS");
        course.setPrice(5999.9);
        model.addAttribute("course",course);
        return "coursedet";
    }

}
