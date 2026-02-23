package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDetails, Long> {
}

/**
 * Crud repository interface has 12 methods
 * Paging and Sorting Repository has 2 methods, is only for data retrieval
 * JPA Repository has
 */