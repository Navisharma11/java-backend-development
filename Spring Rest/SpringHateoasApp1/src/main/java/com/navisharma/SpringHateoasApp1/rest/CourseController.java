package com.navisharma.SpringHateoasApp1.rest;

import com.navisharma.SpringHateoasApp1.model.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController
{
    @GetMapping("/course-info")
    public ResponseEntity<Course> getCourseInfo()
    {
        Course course = new Course(1,"DevOps with AWS",9999.9);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getAllCourseInfo()).withRel("Get All Course");

        course.add(link);
        return new ResponseEntity<Course>(course,HttpStatus.OK);
    }


    @GetMapping("/all-course-info")
    public ResponseEntity<List> getAllCourseInfo()
    {
        Course course1 = new Course(1,"DevOps with AWS",9999.9);
        Course course2 = new Course(2,"DevOps",999.9);
        Course course3 = new Course(3,"AWS",888.9);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        return new ResponseEntity<List>(courses,HttpStatus.OK);
    }

}
