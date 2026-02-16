package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring

    @Override
    public String registerVaccineDetails(VaccineDetails vaccine) {
        System.out.println("Implementing class of IvaccineRepo is: "+ repo.getClass().getName());
        VaccineDetails v=repo.save(vaccine);
        return "Vaccine details registered with id : "+v.getId();
    }

    @Override
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccines) {
        return repo.saveAll(vaccines);
    }

    @Override
    public long getVaccinesCount() {
        return repo.count();
    }

    @Override
    public boolean checkAvailability(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Iterable<VaccineDetails> getAllVacineInfo() {
        return repo.findAll();
    }

    @Override
    public Iterable<VaccineDetails> getAllVaccineInfoByIds(Iterable<Long> isList) {
        return repo.findAllById(isList);
    }
}

/**
 *  jdk.proxy2.$Proxy105 persistence logic is developed by proxy class
 */

/**
 * Spring data jps part is creating the pojo, ivaccinerepo interface , ivaccinerepo reference and make function to save method.
 *
 * there we are using main method to call registervaccinedetails method, in spring rest controller will take care of that part
 */