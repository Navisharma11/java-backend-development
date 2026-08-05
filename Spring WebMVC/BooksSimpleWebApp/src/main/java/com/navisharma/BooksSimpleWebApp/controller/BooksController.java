package com.navisharma.BooksSimpleWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class BooksController
{
    @GetMapping("/home")
    public String showHomePage()
    {
        return "home";
    }

    @GetMapping("/response")
    public String getBooksInfo(Map<String,Object> map)
    {
        String books[] = new String[] {"Java","Spring Boot","Hibernate"};
        for(String name:books)
        {
            System.out.println(name);
        }
        map.put("books",books);
        return "response";

    }
}
