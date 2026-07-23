package com.navisharma.firstspringbootex;

import org.springframework.stereotype.Component;

@Component
public class Dev
{
    public Dev()
    {
        System.out.println("Dev bean created");
    }

    public void build()
    {
        System.out.println("Building awesome project");
    }

}
