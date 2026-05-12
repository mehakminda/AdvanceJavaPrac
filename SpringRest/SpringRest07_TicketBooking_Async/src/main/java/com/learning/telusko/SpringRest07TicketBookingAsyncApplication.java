package com.learning.telusko;

import com.learning.telusko.request.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class SpringRest07TicketBookingAsyncApplication {

    private static final String BOOK_URL2 = "http://localhost:8080/ticketBooking/api/getTicket/{ticketNumber}";

    public static void main(String[] args) {
        SpringApplication.run(SpringRest07TicketBookingAsyncApplication.class, args);
        System.out.println("Request to API started");

        WebClient client = WebClient.create();
        client.get()
                .uri(BOOK_URL2,10)
                .retrieve()
                .bodyToMono(Ticket.class)
                //.block(); //sync
                .subscribe(SpringRest07TicketBookingAsyncApplication::handleResponse);

        System.out.println("Request to API ended");
       // System.out.println(ticket);
    }
    public static void handleResponse(Ticket ticket){
        System.out.println(ticket);
    }
}
