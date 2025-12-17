package com.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.QueMsg;

@Repository
public interface QueMsgRepo extends JpaRepository<QueMsg, Long> {

}
