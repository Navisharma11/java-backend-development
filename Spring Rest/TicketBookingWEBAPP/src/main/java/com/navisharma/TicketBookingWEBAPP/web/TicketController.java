package com.navisharma.TicketBookingWEBAPP.web;

import com.navisharma.TicketBookingWEBAPP.model.Passenger;
import com.navisharma.TicketBookingWEBAPP.model.Ticket;
import com.navisharma.TicketBookingWEBAPP.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController
{
    @Autowired
    private ITicketService service;

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Passenger passenger, Model model)
    {
        Integer ticketNumber = service.registerPassanger(passenger);
        model.addAttribute("ticketNum",ticketNumber);
        return "index"; //Logical View Name
    }

    @GetMapping("/passenger-form")
    public String bookTicketForm(@ModelAttribute Passenger passenger, Model model)
    {
        model.addAttribute("passenger", new Passenger());
        return "index"; //Logical View Name
    }


    @GetMapping("/ticket-form")
    public String ticketForm(@ModelAttribute Passenger passenger, Model model)
    {
        model.addAttribute("passenger", new Passenger());
        return "ticket-form"; //Logical View Name
    }


    @GetMapping("/get-ticket")
    public String getTicket(@RequestParam("ticketNumber") Integer ticketNumber, Model model)
    {
        Ticket ticket = service.getFullTicket(ticketNumber);
        model.addAttribute("ticket",ticket);
         return "ticket-info";
    }

}
