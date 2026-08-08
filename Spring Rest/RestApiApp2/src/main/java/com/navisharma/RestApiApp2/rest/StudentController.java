package com.navisharma.RestApiApp2.rest;

import com.navisharma.RestApiApp2.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class StudentController
{
    @GetMapping("/info1")
    public ResponseEntity<Student>studentInfo()
    {
        Student st = new Student(1,"Sally","Chandigarh");
        return new ResponseEntity<Student>(st, HttpStatus.OK);
    }


    @PostMapping("/add")
    public String addStudent(@RequestBody Student data)
    {
        System.out.println(data);
        return "Data Saved";
    }

}
