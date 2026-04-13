package com.learning.telusko.service;

import com.learning.telusko.dao.ITicketrepo;
import com.learning.telusko.pojo.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{

    @Autowired
    ITicketrepo repo;

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        System.out.println("Saving Passenger details");
        return repo.save(passenger);

    }

    @Override
    public Passenger getPassengerInfo(Integer pid) {
        Optional optional=repo.findById(pid);
        return (Passenger) optional.get();
    }
}


