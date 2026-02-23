package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface IVaccineManagement {

    public List<VaccineDetails> searchByVaccineCompany(String companyName);
    public List<VaccineDetails> searchByPrice(int price);

    public List<VaccineDetails> searchByPriceLessThan(int price);



    public List<VaccineDetails> searchByVaccineNameInAndVaccineCostBetween(Collection<String> vaccineNames, String startingPrice, String endPrice);
}
