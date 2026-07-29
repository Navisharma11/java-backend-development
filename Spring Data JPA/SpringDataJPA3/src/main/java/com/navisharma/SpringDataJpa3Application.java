package com.navisharma;

import com.navisharma.entity.Vaccine;
import com.navisharma.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa3Application
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa3Application.class, args);

        VaccineService service = container.getBean(VaccineService.class);

//		service.fetchDetailsBySorting(true,"vaccineName","vaccineCompany")
//		.forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));

		service.fetchDetailsByPagenation(0,3,true,"VaccineName","VaccineCompany")
				.forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));

	    Page<Vaccine> pages = service.fetchDetailsByPagenation(0,3,true,"VaccineName","VaccineCompany");
		System.out.println(pages.getTotalPages());


//		service.fetchDetailsByPagenation(2);

	}

}
