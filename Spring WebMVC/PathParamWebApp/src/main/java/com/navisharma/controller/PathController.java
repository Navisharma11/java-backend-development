package com.navisharma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PathController
{
    //http://localhost:8484/NaviApp/getinfo/Suresh/
    //http://localhost:8484/NaviApp/getinfo/Suresh/DevOps
    @GetMapping("/getinfo/{name}/{course}")
    public String getSomeInfo(@PathVariable("name") String n,@PathVariable("course") String c, Map<String,Object> model)
    {
        String info="Hello "+n+ " I hope you're learning from this "+c+" ccourse";
        model.put("msg",info);
        return "home";
    }
}
