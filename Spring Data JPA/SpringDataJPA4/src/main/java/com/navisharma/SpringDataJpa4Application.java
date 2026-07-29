package com.navisharma;

import com.navisharma.entity.Vaccine;
import com.navisharma.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SpringDataJpa4Application
{
	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa4Application.class, args);

        VaccineService service = container.getBean(VaccineService.class);

//        Vaccine vac = service.searchVaccineById(109);
//		System.out.println(vac);

//		Vaccine vac = new Vaccine("Covaxin","BharatBio",4000.0);
//		vac.setId(104);
//
//		service.searchVaccineByGivenInfo(vac).forEach(v->System.out.println(v));


		List<Integer> ids = new ArrayList<>();
		ids.add(150);
		ids.add(153);
		ids.add(154);
		String status = service.removeVaccineInfoByIds(ids);
        System.out.println(status);

	}

}
