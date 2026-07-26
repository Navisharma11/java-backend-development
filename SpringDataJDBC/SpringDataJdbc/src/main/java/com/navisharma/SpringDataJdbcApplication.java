package com.navisharma;

import com.navisharma.dao.EmployeeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {
          ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);
//        EmployeeDao dao = container.getBean(EmployeeDao.class);
//		dao.input();

	}

}
