package com.portal.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.JobsDto;
import com.portal.model.Jobs;
import com.portal.service.JobsService;

@RestController
@CrossOrigin
public class JobCtrl {

	@Autowired
	private JobsService js;
	
	@DeleteMapping("/delete-job/{id}")
	public void deleteJob(@PathVariable long id) {
		
		js.deleteJob(id);
	}
	
	@PostMapping("/save-job")
	public Jobs saveJob(@RequestBody JobsDto jdt) {
		
		return js.addJob(jdt);
	}
	
	@GetMapping("/get-jobs")
	public List<Jobs> getAllJobs() {
		
		return js.getJobs();
	}
	
	@PutMapping("/apply-job/{userId}/{jobId}")
	public Jobs applyJob(@PathVariable long userId, @PathVariable long jobId) {
		
		return js.applyJob(userId, jobId);
	}
}
