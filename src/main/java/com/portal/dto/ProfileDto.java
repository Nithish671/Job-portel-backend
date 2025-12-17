package com.portal.dto;

import java.util.ArrayList;
import java.util.List;

public class ProfileDto {

	private String email;

	private List<String> skills = new ArrayList<>();

	private List<ExperienceDto> experience;

	private String summary;

	private String phone;

	private String location;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<ExperienceDto> getExperience() {
		return experience;
	}

	public void setExperience(List<ExperienceDto> experience) {
		this.experience = experience;
	}

}
