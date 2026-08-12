package com.navisharma.RestApiProfiles;

import com.navisharma.RestApiProfiles.service.ICourse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestApiProfilesApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(RestApiProfilesApplication.class, args);
        ICourse course = container.getBean(ICourse.class);
		course.getTheCourse(555.5);
	}

}
