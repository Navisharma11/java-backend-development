package com.navisharma;

import com.navisharma.service.VaccineService;
import com.navisharma.view.ResultView1;
import com.navisharma.view.ResultView2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringDataJpa6Application
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa6Application.class, args);

        VaccineService service = container.getBean(VaccineService.class);

        service.fetchByCostLessThan(4700.0, ResultView2.class).
                forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()+" "+v.getCost()));


	}

}
