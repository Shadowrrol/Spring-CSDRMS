package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.SchoolYearEntity;
import com.capstone.csdrms.Service.SchoolYearService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/schoolYear")
public class SchoolYearController {

	@Autowired
	SchoolYearService syService;
	
	@GetMapping("/getAllSchoolYears")
	public List<SchoolYearEntity> getAllSchoolYears(){
		return syService.getAllSchoolYears();
	}
	
	@PostMapping("/addSchoolYear")
	 public String addSchoolYear(@RequestBody SchoolYearEntity syEntity) {
		 return syService.addSchoolYear(syEntity);
	 }
	
	 @PostMapping("/deleteSchoolYear/{schoolYear_ID}")
	public String deleteSchoolYear(@PathVariable Long schoolYear_ID) {
		return syService.deleteSchoolYear(schoolYear_ID);
	}
	
}
