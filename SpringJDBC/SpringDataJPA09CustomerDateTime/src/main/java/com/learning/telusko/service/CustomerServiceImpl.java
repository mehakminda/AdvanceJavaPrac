package com.learning.telusko.service;

import com.learning.telusko.bo.CustomerDetails;
import com.learning.telusko.dao.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    ICustomerDao repo;

    @Override
    public String registerCustomer(CustomerDetails customer) {
        Integer id= repo.save(customer).getCid();
        return "Customer details saved with id: "+id;
    }

    @Override
    public List<CustomerDetails> getAllCustomer() {
        return (List<CustomerDetails>) repo.findAll();
    }
}
