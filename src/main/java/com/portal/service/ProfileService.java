package com.portal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dto.ProfileDto;
import com.portal.model.Experience;
import com.portal.model.Profile;
import com.portal.repo.ExperienceRepo;
import com.portal.repo.ProfileRepo;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepo pr;
	
	@Autowired
	private ExperienceRepo er;
	
	public void deleteExp(long id) {
		er.deleteById(id);
	}
	
	public Profile getProfile(String email) {
		
		return pr.findByEmail(email);
	}
	
	public Profile updateProfile(ProfileDto pro) {
		
		Profile profile = pr.findByEmail(pro.getEmail());
		
		profile.setLocation(pro.getLocation());
		profile.setPhone(pro.getPhone());
		profile.setSummary(pro.getSummary());
		profile.setSkills(pro.getSkills() != null ? pro.getSkills() : new ArrayList<String>());
		
		profile.setExperience(pro.getExperience() != null ? new ArrayList<Experience>(
			pro.getExperience().stream().map(e -> {

			Experience exp = new Experience();
			if(e.getId() > 0) {
				exp.setId(e.getId());
			}
			exp.setName(e.getName());
			exp.setRole(e.getRole());
			exp.setJoinD(e.getJoinD());
			exp.setLastW(e.getLastW());
			exp.setProfile(profile);

			return exp;
		}).toList()) : new ArrayList<Experience>());
		
		return pr.save(profile);
	}
}
