package com.learning.telusko.dao;

import com.learning.telusko.pojo.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketrepo extends JpaRepository<Passenger, Integer> {
}
