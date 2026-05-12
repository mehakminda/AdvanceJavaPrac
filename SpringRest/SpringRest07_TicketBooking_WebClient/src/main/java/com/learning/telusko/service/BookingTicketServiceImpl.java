package com.learning.telusko.service;

import com.learning.telusko.request.Passenger;
import com.learning.telusko.request.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


//This is the client/consumer class which will make api calls to producer api
@Service
public class BookingTicketServiceImpl implements IBookingTicketService{

    private static final String BOOK_URL = "http://localhost:8080/ticketBooking/api/getTicketNumber";
    private static final String BOOK_URL2 = "http://localhost:8080/ticketBooking/api/getTicket/{ticketNumber}";

    @Override
    public Ticket bookTicket(Passenger passenger) {
        System.out.println(passenger + " in integration logic method");
        //Create webclient object
        WebClient webClient = WebClient.create();
        //send the request  and process the data
        Ticket ticket = webClient.post().uri(BOOK_URL).bodyValue(passenger).retrieve().bodyToMono(Ticket.class).block();
        return ticket;
        //block -> sync call
        //cusbcribe  -> async call
    }

    @Override
    public Ticket fetchTicketInfo(Integer ticketNumber) {
       WebClient client = WebClient.create();
       Ticket ticket = client.get().uri(BOOK_URL2,ticketNumber).retrieve().bodyToMono(Ticket.class).block();
        return ticket;
    }
}


/**
 * consumer can be implemented in 2 ways
 * 1. RestTemplate
 * 2. Webclient
 */