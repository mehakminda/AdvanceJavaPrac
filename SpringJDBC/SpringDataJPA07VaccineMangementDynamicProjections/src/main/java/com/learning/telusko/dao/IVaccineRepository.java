package com.learning.telusko.dao;

import com.learning.telusko.View;
import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDetails, Long> {

    public <T extends View>List<T> findByVaccineCompany(String companyname, Class<T> cls);
    //extends -> upper and super -> lower bond -> from generics concepts
}
