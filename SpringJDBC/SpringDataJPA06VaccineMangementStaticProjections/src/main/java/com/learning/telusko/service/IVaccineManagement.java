package com.learning.telusko.service;

import com.learning.telusko.ResultsView;
import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface IVaccineManagement {

    public List<ResultsView> searchByVaccineCostLessThan(int price);
}
