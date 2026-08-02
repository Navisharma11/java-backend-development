package com.navisharma.SpringWebApp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/telusko")
public class FirstController {

    @GetMapping("/welcome")
    public String displaySomeResponse2(Model model) {

//        System.out.println("Model is internally implemented by " + model.getClass().getName());
        model.addAttribute("info","We have fast tract spring boot batch next weekend");

        return "home";
    }


    @GetMapping("/skill")
    public String displaySomeImportantMsg(Model model) {

//        System.out.println("Model is internally implemented by " + model.getClass().getName());
        model.addAttribute("focus","Focus is the most important skill");

        return "focus";
    }


//    @PostMapping("/skill")
//    public String displaySomeImportantMsg2(Model model) {
//
//        model.addAttribute("focus","Focus is the most important skill");
//
//        return "focus";
//    }


    @GetMapping("/info")
    public String displaySomeImportantInfo(Map<String ,Object> map) {

        System.out.println(map.getClass().getName());
       map.put("info","DevOps with AWS will start from git and linux and covers advanced concepts");

        return "navi";
    }


    @GetMapping("/navi")
    public void displaySomeImportantInfo2(Map<String ,Object> map) {

        map.put("info","DevOps with AWS will start from git and linux and covers advanced concepts");

    }

}