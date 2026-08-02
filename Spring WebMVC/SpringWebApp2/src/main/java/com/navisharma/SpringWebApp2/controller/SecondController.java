package com.navisharma.SpringWebApp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/telusko2")
public class SecondController
{
    @GetMapping("/welcome")
    public String displaySomeResponse2(Model model) {

//        System.out.println("Model is internally implemented by " + model.getClass().getName());
        model.addAttribute("info","We are coming up with DevOps with AWS course");

        return "home";
    }

}
