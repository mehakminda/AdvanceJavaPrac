package com.learning.telusko.service;

import com.learning.telusko.bo.Customer;
import com.learning.telusko.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    public String registerCustomer(CustomerDTO dto) ;
    //anything Customer/CustomerDTO, we do not want to work directly with the business layer
    public List<Customer> findAllCustomers();
    public String removeDocument(String id);

    //custom methods
    public String removeDocumentByCustNo(Integer custNo);
    public Optional<Customer> findDocumentByCustNo(Integer custNo);


}
