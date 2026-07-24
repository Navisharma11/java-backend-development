package com.navisharma.SpringBoot02.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Alien
{

    static
    {
        System.out.println("Static block of alien bean");
    }

    {
        System.out.println("Java Instance Block of Alien bean");
    }

    public Alien()
    {
        System.out.println("Alien Bean Created");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("init Method of Alien");
    }

    public void disp()
    {
        System.out.println("Business logic of Alien Class");
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println("Bean Destroyed");
    }

}
