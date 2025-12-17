package com.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.Jobs;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, Long>{

}
