package com.navisharma.FormDataWebApp.controller;

import com.navisharma.FormDataWebApp.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class EmployeeController
{
    @GetMapping("/register")
    public String getHomePage()
    {
        return "register";
    }


//    public String register(Map<String,Object> map, HttpServletRequest req)
//    {
//        String name = req.getParameter("name");
//        return "response";
//    }


    @PostMapping("/register")
      public String register(Map<String,Object> map, Employee emp)
    {
        System.out.println(emp);
        map.put("emp",emp);
        return "response";
    }




}
