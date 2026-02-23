package com.learning.telusko.service;

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
    public List<VaccineDetails> searchByVaccineCompany(String companyName) {
        System.out.println("My custom finder method is implemented by: "+repo.getClass().getName());
       // return repo.findByVaccineCompany(companyName);
      //  return repo.findByVaccineCompanyIs(companyName);
        return repo.findByVaccineCompanyEquals(companyName);
    }

    @Override
    public List<VaccineDetails> searchByPrice(int price) {
        return repo.findByVaccineCost(price);
    }

    @Override
    public List<VaccineDetails> searchByPriceLessThan(int price) {
        return repo.findByVaccineCostLessThan(price);
    }

    @Override
    public List<VaccineDetails> searchByVaccineNameInAndVaccineCostBetween(Collection<String> vaccineNames, String startingPrice, String endPrice) {
        return repo.findByVaccineNameInAndVaccineCostBetween(vaccineNames,startingPrice,endPrice);
    }
}
