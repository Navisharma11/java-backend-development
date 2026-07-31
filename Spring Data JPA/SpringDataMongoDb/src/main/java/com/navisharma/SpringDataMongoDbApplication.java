package com.navisharma;

import com.navisharma.dto.CustomerDTO;
import com.navisharma.service.ICustomerService;
import com.navisharma.utils.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataMongoDbApplication {

	public static void main(String[] args)
	{
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataMongoDbApplication.class, args);

        ICustomerService service = container.getBean(ICustomerService.class);

//		CustomerDTO dto = new CustomerDTO(2,"Rohit","Mumbai");
//		String status = service.registerCustomer(dto);
//		System.out.println(status);


//		CustomerDTO dto = new CustomerDTO();
//		dto.setId(IdGenerator.generateId());
//		dto.setCustNo(4);
//		dto.setName("Suresh");
//		dto.setCity("Chennai");
//
//		String status = service.registerCustomer(dto);
//		System.out.println(status);


		String status = service.removeDocument("6a6cd6faebe7b5bf7409048b");
        System.out.println(status);

		service.findAllCustomer().forEach(c->System.out.println(c));




	}

}
