package com.learning.telusko.controller;

import com.learning.telusko.request.Passenger;
import com.learning.telusko.request.Ticket;
import com.learning.telusko.service.IBookingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
    @Autowired
    private IBookingTicketService service;

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Passenger passenger, Model model){
        System.out.println("Passenger from in Controller"+ passenger);
        Ticket ticket = service.bookTicket(passenger);
        model.addAttribute("ticketNumber",ticket.getTicketNumber());
        model.addAttribute("ticketdate",ticket.getDateofJourney());
        return "index";
    }

    @GetMapping("/get-ticket")
    public String getTicket(@RequestParam Integer ticketNumber, Model model){
        System.out.println("Getting ticket details for Ticket ID: "+ ticketNumber);
        Ticket ticket = service.fetchTicketInfo(ticketNumber);
        model.addAttribute("ticketNumber",ticket.getTicketNumber());
        /* model.addAttribute("ticketdate",ticket.getDateofJourney());*/
        return "ticket-form";
    }

    @GetMapping("/form")
    public String getIndexPage( Model model){

        model.addAttribute("passenger", new Passenger());
        return "index";
    }

    @GetMapping("/ticket")
    public String get( Model model){

        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }
}
/**
 * Access : localhost:8080
 */