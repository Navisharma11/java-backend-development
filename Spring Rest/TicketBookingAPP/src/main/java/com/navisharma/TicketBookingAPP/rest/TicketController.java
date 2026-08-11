package com.navisharma.TicketBookingAPP.rest;

import com.navisharma.TicketBookingAPP.model.Passenger;
import com.navisharma.TicketBookingAPP.model.Ticket;
import com.navisharma.TicketBookingAPP.service.ITicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book-ticket")
@Tag(name="TicketBookingAPI" ,description="There are 2 apis one will accept Passenger" +   // Used to give information about the specific controller and the api methods
        " info and generate ticket number and other will generate full Ticket info based on ticket number")
public class TicketController
{
    @Autowired
    private ITicketService service;

    @PostMapping("/get-ticketnumber")
    @Operation(summary = "POST Opertion", description = "This API will accept Passenger info and Generate Ticket number")
    public ResponseEntity<Integer> register(@RequestBody Passenger passenger)
    {
        Passenger passen = service.registerPassnger(passenger);
        Integer ticketNumber = passen.getPid();
        return new ResponseEntity<Integer>(ticketNumber, HttpStatus.CREATED);
    }


    @GetMapping("/get-ticket/{ticketNumber}")
    @Operation(summary = "GET Opertion", description = "This API will accept Ticket number and Generate Full Ticket")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber") Integer ticketNumber)
    {
        Passenger passenger = service.fetchPassangerInfo(ticketNumber);
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(passenger.getPid());
        ticket.setName(passenger.getName());
        ticket.setDeparture(passenger.getDeparture());
        ticket.setArrival(passenger.getArrival());
        ticket.setDateOfJourney(passenger.getDateOfJourney());
        ticket.setStatus("confirmed");
        ticket.setTicketPrice(555.5);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

}
