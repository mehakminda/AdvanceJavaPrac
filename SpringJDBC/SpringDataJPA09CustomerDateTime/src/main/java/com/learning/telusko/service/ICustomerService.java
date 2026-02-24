package com.learning.telusko.service;

import com.learning.telusko.bo.CustomerDetails;

import java.util.List;

public interface ICustomerService {
    public String registerCustomer(CustomerDetails customer);
    public List<CustomerDetails> getAllCustomer();
}
