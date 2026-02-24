package com.learning.telusko.service;

import com.learning.telusko.bo.JobSeekerProfile;
import com.learning.telusko.dao.JobSeekerDAO;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements  IJobSeekerService{

    @Autowired
    JobSeekerDAO repo;
    @Override
    public String registerJobSeeker(JobSeekerProfile jobSeekerProfile) {
        Integer id= repo.save(jobSeekerProfile).getId();
        return "Job Seeker details registered with id: "+id;
    }

    @Override
    public Optional<JobSeekerProfile> getDetailsById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<JobSeekerProfile> getAllJobSeeker() {
        return repo.findAll();
    }
}
