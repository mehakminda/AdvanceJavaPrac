package com.learning.telusko.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//we will pass this object to ui and not to db hence no entity
@Data
@NoArgsConstructor
public class Passenger {

    private Integer pid;
    private String name;
    private String departure;
    private String arrival;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofJourney;
}

/***
 * The datasource was likely attempting to connect because your code contained JPA-related imports
 * (e.g., jakarta.persistence in Passenger.java and JpaRepository in IBookingTicketService.java),
 * which could trigger Spring Boot's auto-configuration for JPA even if the dependency was
 * commented out or not present. I've removed these unused imports to clean up the code.
 *
 * Your pom.xml correctly has the JPA dependencies commented out, so no database connection
 * should occur now. The application compiles and runs successfully without any datasource
 * configuration. If you encounter this issue again, ensure no JPA starters are active and consider adding
 * spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration to application.properties if needed.
 */