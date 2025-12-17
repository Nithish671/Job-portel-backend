package com.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.Experience;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Long>{

}
