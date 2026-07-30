package com.navisharma;

import com.navisharma.service.VaccineService;
import com.navisharma.view.ResultView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SpringDataJpa5Application
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa5Application.class, args);

        VaccineService service = container.getBean(VaccineService.class);

        service.fetchByCost(4500.0).forEach(r->System.out.println(r.getVaccineName() +" "+ r.getVaccineCompany()));


	}

}
