package com.navisharma.SpringBoot02;

import com.navisharma.SpringBoot02.service.GreetingsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  //==>@ComponentScan + @EnableAutoConfiguration
public class SpringBoot01Application {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot01Application.class, args);

		GreetingsService greet = container.getBean(GreetingsService.class);

		String status = greet.generateWish("Navi");
        System.out.println(status);

	}

}
