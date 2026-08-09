package com.navisharma.controller;

import com.navisharma.service.IGreetings;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class GreetingController
{
    @Autowired
    private IGreetings greetService;

    @GetMapping("/greet")
    public String generateWish(Model model)
    {
        String greeting = greetService.generateWish("Navi Sharma");
        model.addAttribute("wish",greeting);
        return "greeting";
    }

    @GetMapping("/wish")
    public void generateWish(HttpServletResponse response) throws IOException {
        String greeting = greetService.generateWish("Navi Sharma");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello this response is from controller directly "+greeting+"</h1>");

    }

}
