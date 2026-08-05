package com.navisharma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class QueryController
{
    //http://localhost:8484/NaviApp/getinfo?name=Sally
    //http://localhost:8484/NaviApp/getinfo?name=Sally&course=spring
    @GetMapping("/getinfo")
    public String getSomeInfo(@RequestParam("name")String n,@RequestParam("course")String c, Map<String,Object> model)
    {
        String info="Hello "+n+ " I hope you're learning from this " + c + " course";
        model.put("msg",info);
        return "home";
    }
}
