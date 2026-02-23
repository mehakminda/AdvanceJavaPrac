package com.learning.telusko.dao;

import com.learning.telusko.ResultsView;
import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

//@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDetails, Long> {

    public List<ResultsView> findByVaccineCostLessThan(int price);
    //we use results view as we do not want entire vaccine details object we only need
}


/**
 * In finder method, we get entire vaccine details object. But what if we want only the vaccine name/vaccine company/price. Then we use projections.
 *
 *  We create an interface( any name , we created ResultsView), in this we write setter corresponding for what all column/fields of vaccine class we need.
 *
 */
