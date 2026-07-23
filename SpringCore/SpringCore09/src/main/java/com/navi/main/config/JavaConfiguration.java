package com.navi.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages={"com.navi.main"})
public class JavaConfiguration
{
    public JavaConfiguration()
    {
        System.out.println("JavaConfiguration bean created");
    }

    @Bean
    public LocalDateTime createTimeObj()
    {
    System.out.println();
        return LocalDateTime.now();
    }

}
