package com.learning.telusko.service;

import com.learning.telusko.request.Passenger;
import com.learning.telusko.request.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//This is the client/consumer class which will make api calls to producer api
@Service
public class BookingTicketServiceImpl implements IBookingTicketService{

    private static final String BOOK_URL = "http://localhost:8080/ticketBooking/api/getTicketNumber";
    private static final String BOOK_URL2 = "http://localhost:8080/ticketBooking/api/getTicket/{ticketNumber}";

    @Override
    public Ticket bookTicket(Passenger passenger) {
        System.out.println(passenger + " in integration logic method");
        RestTemplate restTemplate =new RestTemplate();

        ResponseEntity<Ticket> response = restTemplate.postForEntity(BOOK_URL, passenger,Ticket.class);
        //through this url i am passing passenger object to get ticket object.

       return response.getBody();
    }

    @Override
    public Ticket fetchTicketInfo(Integer ticketNumber) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> response = restTemplate.getForEntity(BOOK_URL2,Ticket.class,ticketNumber);
        System.out.println("Ticket object in consumer service IL "+ ticketNumber);
        return response.getBody();
    }
}


/**
 * consumer can be implemented in 2 ways
 * 1. RestTemplate
 * 2. Webclient
 */