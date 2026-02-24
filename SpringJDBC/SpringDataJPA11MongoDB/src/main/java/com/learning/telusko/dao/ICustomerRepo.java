package com.learning.telusko.dao;

import com.learning.telusko.bo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepo extends MongoRepository<Customer,Integer> {
}
