package com.navisharma.TicketBookingWEBAPP.service;

import com.navisharma.TicketBookingWEBAPP.model.Passenger;
import com.navisharma.TicketBookingWEBAPP.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TicketService implements ITicketService
{
    private String url = "http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticketnumber";
    private String get_url =  "http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticket/{ticketNumber}";

    @Override
    public Integer registerPassanger(Passenger passenger) {
        //RestTemplate and WebClient

//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);
//        Integer ticketNumber = response.getBody();

        WebClient webClient = WebClient.create();
        Integer ticketNumber = webClient.post()
                .uri(url)
                .bodyValue(passenger)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();//synchronous
        return ticketNumber;
    }

    @Override
    public Ticket getFullTicket(Integer ticketNumber) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url, Ticket.class, ticketNumber);
//        Ticket ticket = response.getBody();

        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.get()
                .uri(get_url, ticketNumber)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
                return ticket;
    }
}
