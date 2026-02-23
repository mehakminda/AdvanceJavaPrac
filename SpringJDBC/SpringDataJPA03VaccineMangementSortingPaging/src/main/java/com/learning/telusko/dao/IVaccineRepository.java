package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

//@Repository
public interface IVaccineRepository extends PagingAndSortingRepository<VaccineDetails, Long> {
}

/**
 * Crud repository interface has 12 mthods
 * Paging and Sorting Repository has 2 methods, is only for data retrieval
 * JPA Repository has
 */