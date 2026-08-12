package com.navisharma.TouristManagementAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaviService
{
    @Autowired
    private ITouristService service;

    public NaviService()
    {
        System.out.println("NaviService Bean Created");
    }
}
