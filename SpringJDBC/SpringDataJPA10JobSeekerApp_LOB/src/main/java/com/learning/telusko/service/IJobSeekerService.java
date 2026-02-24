package com.learning.telusko.service;

import com.learning.telusko.bo.JobSeekerProfile;

import java.util.Optional;

public interface IJobSeekerService {

    public String registerJobSeeker(JobSeekerProfile jobSeekerProfile);
    public Optional<JobSeekerProfile> getDetailsById(Integer id);
    public Iterable<JobSeekerProfile> getAllJobSeeker();
}
