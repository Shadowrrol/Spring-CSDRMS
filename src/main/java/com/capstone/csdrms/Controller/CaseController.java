package com.capstone.csdrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Service.CaseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/case")
public class CaseController {

	@Autowired
	CaseService cserv;
	
	@PostMapping("/insertCase")
	public CaseEntity insertCase(CaseEntity caseEntity) {
		return cserv.insertCase(caseEntity);
	}
}
