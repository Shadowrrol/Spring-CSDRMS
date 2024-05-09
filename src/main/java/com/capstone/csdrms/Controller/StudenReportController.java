package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.capstone.csdrms.Entity.StudentReportEntity;
import com.capstone.csdrms.Service.StudentReportService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student-report")
public class StudenReportController {
 
	 @Autowired
	StudentReportService sserv;
	
	@PostMapping("/insertReport")
	public StudentReportEntity insertStudentReport(@RequestBody StudentReportEntity studentReport) {
		return sserv.insertStudentReport(studentReport);
	}
	
	@GetMapping("/getAllStudentReports")
	public List<StudentReportEntity> getAllStudentReports(){
		return sserv.getAllStudentReports();
	}
	
	@GetMapping("/getStudentReports/{sid}")
	public List<StudentReportEntity> getStudentReportsById(@PathVariable String sid){
		return sserv.getStudentReportsById(sid);
	}
	
	@PutMapping("/updateStudentReport") 
	public StudentReportEntity updateStudentReport(@RequestParam int rid,@RequestBody StudentReportEntity newStudentReportDetails) {
		return sserv.updateStudentReport(rid, newStudentReportDetails);
	}
	
	@DeleteMapping("/deleteStudentReport/{rid}")
	public String deleteStudentReport(@PathVariable int rid) {
		return sserv.deleteStudent(rid);
	}
	
	@GetMapping("/getAllStudentReportsByYear")
    public List<StudentReportEntity> getAllStudentReportsByYear(@RequestParam(required = false) String year) {
        return sserv.getAllStudentReportsByYear(year);
    }
	
	@GetMapping("/getStudentReportsBySectionAndSchoolYear")
	public List<StudentReportEntity> getAllStudentReportsBySectionAndSchoolYear(@RequestParam String section,@RequestParam String schoolYear ) {
	    return sserv.getAllStudentReportsBySectionAndSchoolYear(section, schoolYear);
	}
	
	@GetMapping("/getStudentReportsBySchoolYear")
	public List<StudentReportEntity> getStudentReportsBySchoolYear(@RequestParam String schoolYear) {
		return sserv.getStudentReportsBySchoolYear(schoolYear);
	}
	
	@GetMapping("/getStudentReportsByGrade")
	public List<StudentReportEntity> getStudentReportsByGrade(@RequestParam int grade) {
	    return sserv.getAllStudentReportsByGrade(grade);
	}
	
	 @GetMapping("/getAllStudentReportsByYearAndGrade")
	    public List<StudentReportEntity> getAllStudentReportsByYearAndGrade(@RequestParam(required = false) String year,@RequestParam(required = false) Integer  grade) {
		 if (year != null && grade != null) {
			 System.out.println("year " + year + " and grade " + grade);
		        return sserv.getAllStudentReportsByYearAndGrade(year, grade);
		    }
		 else if(year == null && grade != null){
			 System.out.print("it is right year == null && grade != null");
		    	return sserv.getAllStudentReportsByGrade(grade);
		    }
		 else {
			 System.out.print("it is right is is else");
			 return sserv.getAllStudentReportsByYear(year);
		 }
	    }	
}
