package com.navisharma;


import com.navisharma.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


@SpringBootApplication
public class SpringDataJpa7CustomFinderApplication
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa7CustomFinderApplication.class, args);

        VaccineService service = container.getBean(VaccineService.class);

//		service.fetchByCost(3500.0).forEach(v->System.out.println(v));
//		service.fetchByCostLessThanEqual(4000.0).forEach(v->System.out.println(v));
//		service.fetxhByCostBetween(3300.0,4000.0).forEach(v->System.out.println(v));
//		service.fetchByVaccineCompanyEquals("Astrazenica").forEach(v->System.out.println(v));

		Collection<String> vaccinesNames = new HashSet<>();
		vaccinesNames.add("CovidShield");
		vaccinesNames.add("Phizer");
		vaccinesNames.add("Covaxin");


		service.fetchByVaccineNameInAndCostBetween(vaccinesNames,3600.0,4100.0).forEach(v->System.out.println(v));
	}

}
