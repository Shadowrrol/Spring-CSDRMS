package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.SanctionEntity;
import com.capstone.csdrms.Service.SanctionService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sanction")
public class SanctionController {

	@Autowired
	SanctionService sserv;
	
	@GetMapping("/getAllSanctions")
	public List<SanctionEntity> getAllSanctions(){
		return sserv.getAllSanctions();
	}
	
	@PostMapping("/insertSanction")
	public SanctionEntity insertSanction(@RequestBody SanctionEntity sanction) {
		return sserv.insertSanction(sanction);
	}

	@GetMapping("/getSanctionsById/{id}")
	public List<SanctionEntity> getAllSanctionsById(@PathVariable Long id){
		return sserv.getAllSanctionsById(id);
	}
	
	@PostMapping("/approveSanction")
	public boolean approveSanction(@RequestParam int sanctionId) {
		return sserv.approveSanction(sanctionId);
	} 
	
	@PostMapping("/declineSanction")
	public boolean declineSanction(@RequestParam int sanctionId) {
		return sserv.declineSanction(sanctionId);
	}
	
	@GetMapping("/getApprovedAndDeclinedSanctions")
	public List<SanctionEntity> getApprovedAndDeclinedSanctions() {
	    return sserv.getApprovedAndDeclinedSanctions();
	}
	
	@GetMapping("/getSanctionsBySectionAndSchoolYear")
	public List<SanctionEntity> getSanctionsBySectionAndSchoolYear(@RequestParam String section,@RequestParam String schoolYear) {
		return sserv.getSanctionsBySectionAndSchoolYear(section, schoolYear);
	}
}
