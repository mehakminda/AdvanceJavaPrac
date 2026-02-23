package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import com.learning.telusko.dao.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepository repo; //bean will be created by spring


    @Override
    public List<VaccineDetails> fetchVaccineByCompanyName(String cn) {
        return repo.searchVaccineByCompanyName(cn);
    }

    @Override
    public List<VaccineDetails> fetchVaccineByCompanies(String cmp1, String cmp2) {
        return repo.searchVaccineByCompanies(cmp1,cmp2);
    }

    @Override
    public List<VaccineDetails> fetchVaccineDetailsByPriceRange(int min, int max) {
        return repo.searchVaccineDetailsByPriceRange(min,max);
    }

    public List<String> fetchVaccineByPriceRange(int min, int max) {
        return repo.searchVaccineByPriceRange(min,max);
    }

    @Override
    public List<Object[]> fetchVaccineDetailByVaccineName(String vac1, String vac2) {
        return repo.searchVaccineDetailByVaccineName(vac1,vac2);
    }

    @Override
    public int changePriceByVaccine(Integer newPrice, String vaccineName) {
        return repo.updatenewVaccineCostByVaccine(newPrice,vaccineName);
    }

    @Override
    public int removeVaccine(String vaccineName) {
        return repo.deleteVaccine(vaccineName);
    }

    @Override
    public int removeVaccineByVaccineCostRange(Integer min, Integer max) {
        return repo.deleteVaccineByVaccineCostRange(min,max);
    }

    @Override
    public int addVaccineDetails(String vaccineName, String vaccineCompnay, String vaccineCost) {
        return repo.insertVaccineDetails(vaccineName,vaccineCompnay,vaccineCost);
    }

    @Override
    public Date getDBDateAndTime() {
        java.time.LocalDateTime ldt = repo.getTheSystemDateAndTime();
        return java.util.Date.from(ldt.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }
    //class java.time.LocalDateTime cannot be cast to class java.util.Date
    // This usually happens when fetching a date/time value from the database and expecting a java.util.Date, but the JPA provider (like Hibernate) returns a java.time.LocalDateTime instead.


}
