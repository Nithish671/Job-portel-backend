package com.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dto.AppUserDto;
import com.portal.dto.ProfileDto;
import com.portal.model.AppUser;
import com.portal.model.Experience;
import com.portal.model.Profile;
import com.portal.repo.AppUserRepo;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepo aur;
	
	public AppUser getUser(long id) {
		
		return aur.findById(id).get();
	}
	
	public List<AppUser> getAllUsers() {
		
		return aur.findAll();
	}
	
	public AppUser getUser(String email) {
		
		return aur.findByEmail(email);
	}

	public AppUser updateUser(long id, AppUserDto userDto) {
		
		AppUser user = aur.findById(id).get();
		
		user.setAdmin(userDto.getAdmin());

		user.setEmail(userDto.getEmail());

		user.setName(userDto.getName());

		user.setPassword(userDto.getPassword());
		
		userDto.getProfile().setEmail(userDto.getEmail());

		user.setProfile(mapProfile(userDto.getProfile()));
		
		return aur.save(user);
	}
	
	public AppUser saveUser(AppUserDto userDto) {

		if (aur.existsByEmail(userDto.getEmail())) {

			throw new RuntimeException("User already exists!");
		}

		AppUser user = new AppUser();

		user.setAdmin(userDto.getAdmin());

		user.setEmail(userDto.getEmail());

		user.setName(userDto.getName());

		user.setPassword(userDto.getPassword());
		
		userDto.getProfile().setEmail(userDto.getEmail());

		user.setProfile(mapProfile(userDto.getProfile()));

		return aur.save(user);
	}

	public Profile mapProfile(ProfileDto proDto) {

		Profile pro = new Profile();

		pro.setEmail(proDto.getEmail());
		pro.setLocation(proDto.getLocation());
		pro.setPhone(proDto.getPhone());
		pro.setSummary(proDto.getSummary());
		pro.setSkills(proDto.getSkills() != null ? proDto.getSkills() : new ArrayList<String>());

		pro.setExperience(proDto.getExperience() != null ? proDto.getExperience().stream().map(e -> {

			Experience exp = new Experience();

			exp.setName(e.getName());
			exp.setRole(e.getRole());
			exp.setJoinD(e.getJoinD());
			exp.setLastW(e.getLastW());
			exp.setProfile(pro);

			return exp;
		}).toList() : new ArrayList<Experience>());

		return pro;
	}

}
