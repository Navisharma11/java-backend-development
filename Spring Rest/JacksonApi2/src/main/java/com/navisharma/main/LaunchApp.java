package com.navisharma.main;


import com.navisharma.model.Alien;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class LaunchApp
{
    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper();
        java.io.InputStream is = LaunchApp.class.getClassLoader().getResourceAsStream("sample.json");
        Alien alien = mapper.readValue(is, Alien.class);
        System.out.println(alien);

    }
}
