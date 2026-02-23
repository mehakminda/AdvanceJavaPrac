package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;

import java.util.List;
import java.util.Optional;

public interface IVaccineManagement {

    public String registerVaccineDetails(VaccineDetails vaccine);
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vacines);
    public long getVaccinesCount();
    public boolean checkAvailability(Long id);
    public Iterable<VaccineDetails> getAllVacineInfo();
    public Iterable<VaccineDetails> getAllVaccineInfoByIds(Iterable<Long> isList);
    public Optional<VaccineDetails> getVaccineById(Long id); //optional is a container for object (ie) object holder
    public String removeVaccineById(Long id);
    public String removeVaccinesById(List<Long> ids);
    public String removeVaccineObject(VaccineDetails vaccine);
}

//here we are trying to use all the method in crudRepository