package com.learning.telusko.dao;

import com.learning.telusko.bo.JobSeekerProfile;
import org.springframework.data.repository.CrudRepository;

public interface JobSeekerDAO extends CrudRepository<JobSeekerProfile,Integer> {
}
