package com.learning.telusko.service;

import com.learning.telusko.ResultsView;
import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring


    @Override
    public List<ResultsView> searchByVaccineCostLessThan(int price) {
        System.out.println("Implementation of the repo : "+ repo.getClass().getName());
        return repo.findByVaccineCostLessThan(price);
    }
}
