package com.navisharma.OAuthSecurityApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeluskoController
{

    @GetMapping("/info")
    public String getCourseInfo()
    {
        return "Telusko has Launched DevOps With AWS Course";
    }

}
