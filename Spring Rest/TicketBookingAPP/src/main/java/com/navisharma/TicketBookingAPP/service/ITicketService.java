package com.navisharma.TicketBookingAPP.service;

import com.navisharma.TicketBookingAPP.model.Passenger;

public interface ITicketService
{
    Passenger registerPassnger(Passenger passenger);
    Passenger fetchPassangerInfo(Integer id);

}
