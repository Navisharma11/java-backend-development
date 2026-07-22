package com.navi.main.service;

import org.springframework.stereotype.Service;

@Service("service")   //serviceLayer
public class ServiceLayer
{
    public ServiceLayer()
    {
        System.out.println("ServiceLayer bean created");
    }
}
