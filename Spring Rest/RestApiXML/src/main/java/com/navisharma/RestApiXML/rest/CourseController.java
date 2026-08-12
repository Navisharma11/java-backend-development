package com.navisharma.RestApiXML.rest;

import com.navisharma.RestApiXML.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController
{
    @PostMapping(value="/add-course", consumes={"application/xml","application/json"})  //consume means this api can take both xml or json type data
    public ResponseEntity<String> addCourseInfo(@RequestBody Course course)
    {
        System.out.println(course);
        String msg = "Course info added";
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }


    @GetMapping(value="/get-course", produces={"application/xml","application/json"})  //produce means this api can give both xml or json type data
    public ResponseEntity<Course> getCourseInfo()
    {
        Course course = new Course(1,"DevOps with AWS","4 Months",9999.9);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


}
