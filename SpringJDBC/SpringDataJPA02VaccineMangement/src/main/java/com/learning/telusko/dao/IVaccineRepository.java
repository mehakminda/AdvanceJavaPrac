package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

//@Repository
public interface IVaccineRepository extends CrudRepository<VaccineDetails, Long> {
}

/**
 * Crud repository interface has 12 mthods
 * Paging and Sorting Repository has 2 methods
 * JPA Repository has
 */