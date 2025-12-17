package com.portal.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.QueMsgDto;
import com.portal.model.QueMsg;
import com.portal.service.QueMsgService;

@RestController
@CrossOrigin
public class QueMsgCtrl {

	@Autowired
	private QueMsgService qms;
	
	@PostMapping("/query")
	public QueMsg saveMsg(@RequestBody QueMsgDto qmd) {
		
		return qms.saveMsg(qmd);
	}
}
