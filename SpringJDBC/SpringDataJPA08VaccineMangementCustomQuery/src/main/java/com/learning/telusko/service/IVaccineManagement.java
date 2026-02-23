package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;

import java.util.Date;
import java.util.List;

public interface IVaccineManagement {

    public List<VaccineDetails>  fetchVaccineByCompanyName(String cn);
    public List<VaccineDetails> fetchVaccineByCompanies(String cmp1, String cmp2);
    public List<VaccineDetails> fetchVaccineDetailsByPriceRange(int min, int max);
    public List<String> fetchVaccineByPriceRange(int min, int max);
    public List<Object[]> fetchVaccineDetailByVaccineName(String vac1,String vac2);

    public int changePriceByVaccine(Integer newPrice, String vaccineName);

    public int removeVaccine(String vaccineName);
    public int removeVaccineByVaccineCostRange(Integer min, Integer max);

    public int addVaccineDetails(String vaccineName, String vaccineCompnay, String vaccineCost);

    public Date getDBDateAndTime();

}

