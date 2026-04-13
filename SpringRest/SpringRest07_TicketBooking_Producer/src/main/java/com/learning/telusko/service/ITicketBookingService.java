package com.learning.telusko.service;

import com.learning.telusko.pojo.Passenger;

public interface ITicketBookingService {
    public Passenger registerPassenger(Passenger passenger);
    public Passenger getPassengerInfo(Integer pid);
}

//here passenger id is ticket number..