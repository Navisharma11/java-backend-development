package com.navisharma;

import com.navisharma.entity.Vaccine;
import com.navisharma.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa3Application
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa3Application.class, args);

        VaccineService service = container.getBean(VaccineService.class);

//		String status = service.registerVaccineInfo(new Vaccine("Phizer","Moderena",4500.0));
//        System.out.println(status);

//		Vaccine vac1 = new Vaccine("Polio","WHO",450.0);
//		Vaccine vac2 = new Vaccine("CovidShield","Astrazenica",3500.0);
//		Vaccine vac3 = new Vaccine("Covaxin","BharatBio",4000.0);

		List<Vaccine> vaccines = new ArrayList<Vaccine>();
		vaccines.add(new Vaccine("Polio","WHO",450.0));
		vaccines.add(new Vaccine("CovidShield","Astrazenica",3500.0));
		vaccines.add(new Vaccine("Covaxin","BharatBio",4000.0));
//
		service.registerMultipleVaccineInfo(vaccines).forEach(v->System.out.println(v));

		long count = service.vaccinescount();
//		System.out.println("No of Vaccines availabe "+count);
//
//		int id = 5;
//		Boolean ststus = service.checkVaccineAvailability(id);
//		if(ststus)
//			System.out.println("Vaccine with id "+ id + " is availabe");
//		else
//			System.out.println("Vaccine with id "+ id + " is not availabe");


//       service.getAllVaccineInfo().forEach(v->System.out.println(v));


//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(3);
//        ids.add(52);
//
//        service.getAllVaccines(ids).forEach(v->System.out.println(v));

//        Integer id = 1;
//
//        String status = service.removeVaccineById(id);
//        System.out.println(status);

//        Optional<Vaccine> optional = service.getVaccineById(id);
//
//        if(optional.isPresent())
//            System.out.println(optional.get());
//        else
//            System.out.println("vaccine with id "+id+ " is not present in records");

//        Vaccine vac1 = new Vaccine("Polio","WHO",450.0);
//        vac1.setId(1);
//
//       String status = service.removeVaccineByVaccine(vac1);
//       System.out.println(status);

//                List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(4);
//
//        String status = service.removeAllVaccinesByIds(ids);
//        System.out.println(status);

	}

}
