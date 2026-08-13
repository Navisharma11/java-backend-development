package com.navisharma.RestApiAppActuator.rest;


import com.navisharma.RestApiAppActuator.service.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class GreetingsController
{
    @Autowired
    private IGreetings greeting;

    @GetMapping("/greet")
    public ResponseEntity<String> getWishes()
    {
        String res = greeting.generateWish("Navi Sharma");
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }


    @GetMapping("/greet2")
    public String getWishes1()
    {
        String res = greeting.generateWish("Navi Sharma");
        return res;
    }
}