package com.portal.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AppUserDto;
import com.portal.model.AppUser;
import com.portal.service.AppUserService;

@RestController
@CrossOrigin
public class AppUserCtrl {

	@Autowired
	private AppUserService aus;
	
	@GetMapping("/get-user/{email}")
	public AppUser getUser(@PathVariable String email) {
		
		return aus.getUser(email);
	}
	
	@GetMapping("/getUser/{id}")
	public AppUser getUser(@PathVariable long id) {
		
		return aus.getUser(id);
	}
	
	@GetMapping("/get-users")
	public List<AppUser> getAllUsers() {
		
		return aus.getAllUsers();
	}
	
	@PostMapping("/save-user")
	public AppUser createUser(@RequestBody AppUserDto userDto) {
		
		return aus.saveUser(userDto);
	}
	
	@PutMapping("/update-user/{id}")
	public AppUser updateUser(@PathVariable long id, @RequestBody AppUserDto userDto) {
		
		return aus.updateUser(id, userDto);
	} 
}
