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

import com.capstone.csdrms.Entity.SuspensionEntity;
import com.capstone.csdrms.Service.SuspensionService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/suspension")
public class SuspensionController {

	@Autowired
	SuspensionService sserv;
	
	@GetMapping("/getAllSuspensions")
	public List<SuspensionEntity> getAllSuspensions(){
		return sserv.getAllSuspensions();
	}
	
	@PostMapping("/insertSuspension")
	public SuspensionEntity insertSuspension(@RequestBody SuspensionEntity suspension) {
		return sserv.insertSuspension(suspension);
	}
	
	@GetMapping("/getSuspensionsByStudentId/{id}")
	public List<SuspensionEntity> getAllSuspensionsByStudentId(@PathVariable Long id){
		return sserv.getAllSuspensionsByStudentId(id);
	}
	
	
	

//	@GetMapping("/getSanctionsById/{id}")
//	public List<SuspensionEntity> getAllSanctionsById(@PathVariable Long id){
//		return sserv.getAllSanctionsById(id);
//	}
//	
//	@PostMapping("/approveSanction")
//	public boolean approveSanction(@RequestParam int sanctionId) {
//		return sserv.approveSanction(sanctionId);
//	} 
//	
//	@PostMapping("/declineSanction")
//	public boolean declineSanction(@RequestParam int sanctionId) {
//		return sserv.declineSanction(sanctionId);
//	}
//	
//	@GetMapping("/getApprovedAndDeclinedSanctions")
//	public List<SuspensionEntity> getApprovedAndDeclinedSanctions() {
//	    return sserv.getApprovedAndDeclinedSanctions();
//	}
//	
//	@GetMapping("/getSanctionsBySectionAndSchoolYear")
//	public List<SuspensionEntity> getSanctionsBySectionAndSchoolYear(@RequestParam String section,@RequestParam String schoolYear) {
//		return sserv.getSanctionsBySectionAndSchoolYear(section, schoolYear);
//	}
}
