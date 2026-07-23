package com.navisharma.firstspringbootex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootExApplication {

    public static void main(String[] args)
    {
        ApplicationContext appContext = SpringApplication.run(FirstSpringBootExApplication.class, args);

        Dev obj = appContext.getBean(Dev.class);
        obj.build();

    }

}
