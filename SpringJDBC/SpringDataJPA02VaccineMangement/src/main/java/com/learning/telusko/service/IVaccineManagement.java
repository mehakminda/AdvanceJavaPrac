package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;

public interface IVaccineManagement {

    public String registerVaccineDetails(VaccineDetails vaccine);
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vacines);
    public long getVaccinesCount();
    public boolean checkAvailability(Long id);
    public Iterable<VaccineDetails> getAllVacineInfo();
    public Iterable<VaccineDetails> getAllVaccineInfoByIds(Iterable<Long> isList);
}

//here we are trying to use all the method in crudRepository