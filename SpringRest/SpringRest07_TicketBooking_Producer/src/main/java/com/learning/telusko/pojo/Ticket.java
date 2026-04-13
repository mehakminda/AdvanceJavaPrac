package com.learning.telusko.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class Ticket {

    private Integer ticketNumber;
    private String status;
    private double ticketCost;
    private String name;
    private String fromPlace;
    private String toPlace;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofJourney;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;
}
