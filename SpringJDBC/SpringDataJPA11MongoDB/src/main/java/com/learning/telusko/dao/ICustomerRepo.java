package com.learning.telusko.dao;

import com.learning.telusko.bo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ICustomerRepo extends MongoRepository<Customer,String> {

    //deleting or finding by customNo, these are not provided by default, hence we have to mention in repo
    //finder methods and custom methods
    void deleteByCusNo(Integer cusNo);
    Optional<Customer>  findByCusNo(Integer cusNo);
}

/**
 * The findByCustNo method should return a Customer or Optional<customer>, not void.</customer>
 * why is it so, How will I know what it will return?
 *
 * see WHY_Optional_Return.md file
 */