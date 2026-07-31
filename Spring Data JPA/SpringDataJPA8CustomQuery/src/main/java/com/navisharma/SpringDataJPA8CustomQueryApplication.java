package com.navisharma;


import com.navisharma.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;
import java.util.HashSet;


@SpringBootApplication
public class SpringDataJPA8CustomQueryApplication
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJPA8CustomQueryApplication.class, args);

        VaccineService service = container.getBean(VaccineService.class);

//		service.fetchByVaccineCompany("BharatBio").forEach(v->System.out.println(v));

//		service.fetchByVaccineCompany("BharatBio","Astrazenica").forEach(v->System.out.println(v));

//		service.fetchByVaccineCost(3500.0,4100.0).forEach(r->System.out.println(r[0]+" "+r[1]));

//		int rowsAffected = service.updateThePriceByVaccineName(10000.0,"Covaxin");
//		if(rowsAffected!=0)
//		{
//			System.out.println("Update Success");
//		}
//		else
//		{
//			System.out.println("Update Failure");
//		}


//		int rowsAffected = service.deleteTheVaccinesByVaccineNames("covaxin");
//		if(rowsAffected!=0)
//		{
//			System.out.println("Record deleted");
//		}
//		else
//		{
//			System.out.println("Deletion Failure");
//		}

//
//		int rowsAffected = service.insertVaccineDetails(4,"Covaxin","BharatBio", 10000.0);
//		if(rowsAffected!=0)
//		{
//			System.out.println("New Record Added");
//		}
//		else
//		{
//			System.out.println("Failed to add new Record");
//		}

		System.out.println(service.getSystemDateAndTime());
	}

}
