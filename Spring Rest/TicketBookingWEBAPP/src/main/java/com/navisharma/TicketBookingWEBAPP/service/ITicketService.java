package com.navisharma.TicketBookingWEBAPP.service;

import com.navisharma.TicketBookingWEBAPP.model.Passenger;
import com.navisharma.TicketBookingWEBAPP.model.Ticket;

public interface ITicketService
{
    public Integer registerPassanger(Passenger passenger);
    public Ticket getFullTicket(Integer ticketNumber);
}
