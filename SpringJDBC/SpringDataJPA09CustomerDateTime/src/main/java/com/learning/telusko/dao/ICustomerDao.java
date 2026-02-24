package com.learning.telusko.dao;

import com.learning.telusko.bo.CustomerDetails;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDao extends CrudRepository<CustomerDetails,Integer> {
}
