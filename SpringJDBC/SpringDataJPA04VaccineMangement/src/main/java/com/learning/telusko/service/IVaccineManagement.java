package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IVaccineManagement {


    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccineDetails, boolean status, String... args);
    public List<VaccineDetails> searchVaccineByGivenObject(VaccineDetails vaccine);

    public VaccineDetails searchVaccineById(Long id);
    public String removeVaccineByIds(Iterable <Long> ids);


}

//here we are trying to use all the method in crudRepository