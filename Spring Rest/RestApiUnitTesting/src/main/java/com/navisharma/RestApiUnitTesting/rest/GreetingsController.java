package com.navisharma.RestApiUnitTesting.rest;

import com.navisharma.RestApiUnitTesting.model.Student;
import com.navisharma.RestApiUnitTesting.service.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController
{
    @Autowired
    private IGreetings service;

    @GetMapping("/greet")
    public ResponseEntity<String> getWishes()
    {
        String res = service.generateWish("Navi Sharma");
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student data)
    {
        System.out.println(data);
        Boolean status = service.addStudent(data);
        if(status){
            String msg = "Student Data Added";
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        }
        else {
            String msg = "Student data couldn't be added";
            return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
