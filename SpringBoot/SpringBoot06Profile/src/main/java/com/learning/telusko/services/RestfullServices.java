package com.learning.telusko.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
//@Primary
@Profile({"rest","dev","prod"})
public class RestfullServices implements Courses{
    @Override
    public boolean registerToCourses(Double cost) {
        System.out.println("Registered to course RestFul services and amount paid is "+cost);
        return true;
    }
}


/**
 * what if we have primary in one and profile in another? primary is executed
 */

/**
 * Microservices is a bean (@Component) and has @Profile("microservice").
 * RestfullServices is also a bean (@Component) without a profile restriction.
 * Since the microservice profile is active, Spring creates Microservices and it still creates RestfullServices, so Courses has two candidates and @Autowired fails.
 */