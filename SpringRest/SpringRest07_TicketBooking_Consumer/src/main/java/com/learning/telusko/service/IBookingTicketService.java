package com.learning.telusko.service;

import com.learning.telusko.request.Passenger;
import com.learning.telusko.request.Ticket;


public interface IBookingTicketService {
    public Ticket bookTicket(Passenger passenger);
    public Ticket fetchTicketInfo(Integer ticketNumber);
}
