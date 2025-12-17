package com.portal.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.ProfileDto;
import com.portal.model.Profile;
import com.portal.service.ProfileService;

@RestController
@CrossOrigin
public class ProfileCtrl {

	@Autowired
	private ProfileService ps;
	
	@DeleteMapping("/delete-exp/{id}")
	public void deleteExp(@PathVariable long id) {
		
		ps.deleteExp(id);
	}
	
	@GetMapping("/get-profile/{email}")
	public Profile getProfile(@PathVariable String email) {
		
		return ps.getProfile(email);
	} 
	
	@PutMapping("/update-profile")
	public Profile updateProfile(@RequestBody ProfileDto pro) {
		
		return ps.updateProfile(pro);
	}
	
}
