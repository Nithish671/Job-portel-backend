package com.portal.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "experience")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private LocalDate joinD;
	
	private LocalDate lastW;
	
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	@JsonIgnore
	private Profile profile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
