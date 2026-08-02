package com.navisharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


@Service
public class GreetingService implements IGreetings
{
    @Autowired
    private LocalTime time;

    @Override
    public String generateWish(String name) {
        int hour = time.getHour();
        if(hour<12)
            return "Good Morning " + name;
        else if(hour<16)
            return "Good Afternoon " + name;
        else if(hour<2)
            return "Good Evening " + name;
        else
            return "Good Night " + name;
    }
}
