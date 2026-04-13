package com.learning.telusko.controller;

import com.learning.telusko.pojo.Passenger;
import com.learning.telusko.pojo.Ticket;
import com.learning.telusko.service.ITicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class TicketBookingController {
    @Autowired
    private ITicketBookingService service;

    @PostMapping("/getTicketNumber")
    public ResponseEntity<Ticket> enrolPassenger(@RequestBody Passenger passenger){
       Passenger pas =  service.registerPassenger(passenger);
       Ticket ticket = new Ticket();
       ticket.setTicketNumber(pas.getPid());
       ticket.setTicketCost(112211);
       ticket.setName(pas.getName());
       ticket.setStatus("Booked");
       ticket.setStartTime(LocalTime.of(9,30));
       ticket.setEndTime(LocalTime.of(11,11));
       ticket.setDateofJourney(LocalDate.of(2026,06,24));
       ticket.setFromPlace("Hyderabad");
       ticket.setToPlace("Agra");

       return new ResponseEntity<>(ticket, HttpStatus.OK);

    }

    @GetMapping("/getTicket/{ticketNumber}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketNumber){
       Ticket ticket = new Ticket();
       Passenger passenger = service.getPassengerInfo(ticketNumber);
       ticket.setTicketNumber(passenger.getPid());
       ticket.setName(passenger.getName());
       ticket.setStatus(passenger.getArrival());
       ticket.setDateofJourney(passenger.getDateofJourney());
       ticket.setStartTime(LocalTime.of(9,30));
       ticket.setEndTime(LocalTime.of(12,30));

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
