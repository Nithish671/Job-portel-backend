package com.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long>{

	Profile findByEmail(String email);
}
