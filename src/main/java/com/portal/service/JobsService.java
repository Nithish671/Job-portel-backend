package com.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dto.JobsDto;
import com.portal.model.Jobs;
import com.portal.repo.JobsRepo;

@Service
public class JobsService {

	@Autowired
	private JobsRepo jr;
	
	public void deleteJob(long id) {
		
		jr.deleteById(id);
	}
	
	public Jobs addJob(JobsDto jobDt) {
		
		Jobs job = new Jobs();
		
		job.setExp(jobDt.getExp());
		job.setJd(jobDt.getJd());
		job.setOrg(jobDt.getOrg());
		job.setSkills(jobDt.getSkills());
		job.setTitle(jobDt.getTitle());
		
		job.setAppId(new ArrayList<Long>());
		
		return jr.save(job);
	}
	
	public Jobs applyJob(long userId, long jobId) {
		
		Jobs job = jr.findById(jobId).get(); 
		
		job.getAppId().add(userId);
		
		job.setAppId(job.getAppId());
		
		return jr.save(job);
	}
	
	public List<Jobs> getJobs() {
		
		return jr.findAll();
	}
}
