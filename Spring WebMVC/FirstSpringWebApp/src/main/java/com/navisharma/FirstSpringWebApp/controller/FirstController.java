package com.navisharma.FirstSpringWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView displaySomeResponse() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("message", "Hello! Welcome to our first web app");
        mav.setViewName("index");

        return mav;
    }


    @GetMapping("/welcome2")
    public ModelAndView displaySomeResponse2() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("message", "Hello! Enjoy Telusko Learning");
        mav.setViewName("index");

        return mav;
    }

}