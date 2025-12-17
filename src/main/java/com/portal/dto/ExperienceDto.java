package com.portal.dto;

import java.time.LocalDate;

public class ExperienceDto {
	
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String name;
	
	private LocalDate joinD;
	
	private LocalDate lastW;
	
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoinD() {
		return joinD;
	}

	public void setJoinD(LocalDate joinD) {
		this.joinD = joinD;
	}

	public LocalDate getLastW() {
		return lastW;
	}

	public void setLastW(LocalDate lastW) {
		this.lastW = lastW;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
