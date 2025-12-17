package com.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

	boolean existsByEmail(String email);
	
	AppUser findByEmail(String email);
}
