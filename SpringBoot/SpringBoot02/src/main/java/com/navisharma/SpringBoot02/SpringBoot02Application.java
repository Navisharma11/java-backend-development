package com.navisharma.SpringBoot02;

import com.navisharma.SpringBoot02.service.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  //==>@ComponentScan + @EnableAutoConfiguration
public class SpringBoot02Application {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot02Application.class, args);

		Alien alien = container.getBean(Alien.class);
		alien.disp();

		container.close();
		
	}

}
