package com.learning.telusko.service;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface IVaccineManagement {

    public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties);
    public Page<VaccineDetails> fetchDataByPageNo(int pageNo, int pageSize, boolean status, String... properties);
    //Page<T> part of spring framework

    public void fetchdetailsByPagination(int pageSize);
}

//here we are trying to use all the method in crudRepository