package com.navisharma.TicketBookingAPP.service;

import com.navisharma.TicketBookingAPP.model.Passenger;
import com.navisharma.TicketBookingAPP.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements ITicketService
{
    @Autowired
    private ITicketRepo repo;

    @Override
    public Passenger registerPassnger(Passenger passenger) {
        return repo.save(passenger);
    }

    @Override
    public Passenger fetchPassangerInfo(Integer id) {
        Optional<Passenger> optional = repo.findById(id);
        return optional.get();
    }
}
