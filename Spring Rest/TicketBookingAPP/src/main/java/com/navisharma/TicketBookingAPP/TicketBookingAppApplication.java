package com.navisharma.TicketBookingAPP;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(      //Used to give overall information of our API
		info=@Info(
				title="TicketBooking ApI",
				version="v1.0",
				description="This API will Book and Generate Ticket"
		),
		servers=@Server(
                url="http://localhost:8484/TicketBookingAPI",
				description = "This API is deployed in the followed url"
		)

)
public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}

}
