package com.navisharma.main;

import com.navisharma.model.Alien;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LaunchApp
{
    public static void main(String[] args)
    {
        Alien alien1 = new Alien(1,"Rohit","Mumbai");
        Alien alien2 = new Alien(2,"Rohan","Bengaluru");
        Alien alien3 = new Alien(3,"Ramesh","Chennai");

        List<Alien> aliens = Arrays.asList(alien1, alien2, alien3);

//        System.out.println(alien);
        //Create ObjectMapper is inside Jackson Api

        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(alien1);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aliens);
        System.out.println(json);
    }
}
