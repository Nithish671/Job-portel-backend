package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dto.QueMsgDto;
import com.portal.model.QueMsg;
import com.portal.repo.QueMsgRepo;

@Service
public class QueMsgService {

	@Autowired
	private QueMsgRepo qmr;
	
	public QueMsg saveMsg(QueMsgDto msgDt) {
		
		QueMsg qm = new QueMsg();
		
		qm.setEmail(msgDt.getEmail());
		qm.setMsg(msgDt.getMsg());
		qm.setName(msgDt.getName());
		
		return qmr.save(qm);
	}
}
