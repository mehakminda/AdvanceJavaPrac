package com.learning.telusko.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

//@Repository //optional annotation
public interface IStudentDao extends CrudRepository<StudentTable, Serializable> {
}
