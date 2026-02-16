package com.learning.telusko.dao;

import com.learning.telusko.bo.VaccineDetails;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

//@Repository
public interface IVaccineRepository extends CrudRepository<VaccineDetails, Long> {
}
