package com.example.job.job.impl;


import com.example.job.job.Job;
import com.example.job.job.JobRepository;
import com.example.job.job.JobService;
import com.example.job.job.dto.JobWithCompanyDTO;
import com.example.job.job.external.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceimpl implements JobService {

//    private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    public JobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();

        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobWithCompanyDTO convertToDto(Job job) {
        RestTemplate restTemplate = new RestTemplate();

            JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
            jobWithCompanyDTO.setJob(job);

            Company company = restTemplate.getForObject("http://localhost:8081/companies/" + job.getCompanyId(), Company.class);
            jobWithCompanyDTO.setCompany(company);

            return jobWithCompanyDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());

                // Persist changes
                jobRepository.save(job);

                return true;
            }
        return false;
    }
}
