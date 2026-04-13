package com.learning.telusko.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String name;
    private String departure;
    private String arrival;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofJourney;


}

/**
 * In your Java code, @GeneratedValue(strategy = GenerationType.IDENTITY) tells Hibernate to omit pid from the INSERT statement and let the database handle it.
 * Thats why we need to write "ALTER TABLE passenger MODIFY pid BIGINT AUTO_INCREMENT;"
 *
 *
 */
