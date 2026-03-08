package com.learning.telusko.service;

import com.learning.telusko.bo.Customer;
import com.learning.telusko.dao.ICustomerRepo;
import com.learning.telusko.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  ICustomerService{

    @Autowired
    private ICustomerRepo repo;

    @Override
    public String registerCustomer(CustomerDTO dto) {
        System.out.println("Implementing of Mongo db repo: "+ repo.getClass().getName());
        //convert customerDTO to customer, in order to pass to save method which requires entity/document
        Customer customerDocument=new Customer();
        //Beanustils is used to convert data present in one object to another obj
        BeanUtils.copyProperties(dto,customerDocument);
        Customer c= repo.save(customerDocument);
        return "Added customer with id: "+ c.getId();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repo.findAll();
    }

    @Override
    public String removeDocument(String id) {
        Optional<Customer> optionalCustomer=repo.findById(id);
        if(optionalCustomer.isPresent()){
            repo.deleteById(id);
            return "Deleted document with id " +id;
        }
        return "Document not found in collection";

    }

    @Override
    public String removeDocumentByCustNo(Integer custNo) {
        Optional<Customer> customer=repo.findByCusNo(custNo);
        if(customer.isPresent()){
            repo.deleteByCusNo(custNo);
           // repo.delete(customer.get());
            return "Document deleted by customer number: " + custNo;
        }
        return "Document not found";

    }

    @Override
    public Optional<Customer>  findDocumentByCustNo(Integer custNo) {
        return repo.findByCusNo(custNo);
    }
}

//DTO part is optional, we can avoid it and also do as we were doing it in previous examples
