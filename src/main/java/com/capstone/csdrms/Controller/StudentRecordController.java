package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


import com.capstone.csdrms.Entity.StudentRecordEntity;
import com.capstone.csdrms.Service.StudentRecordService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student-record")
public class StudentRecordController {
 
	 @Autowired
	StudentRecordService sserv;
	
	@PostMapping("/insertRecord")
	public StudentRecordEntity insertStudentRecord(@RequestBody StudentRecordEntity studentRecord) {
		return sserv.insertStudentRecord(studentRecord);
	}
	
	@GetMapping("/getAllStudentRecords")
	public List<StudentRecordEntity> getAllStudentRecords(){
		return sserv.getAllStudentRecords();
	}

	@GetMapping("/getStudentRecords/{sid}")
	public List<StudentRecordEntity> getStudentRecordsBySid(@PathVariable String sid){
		return sserv.getStudentRecordsBySid(sid);
	}
	
	@PutMapping("/update/{recordId}")
    public ResponseEntity<StudentRecordEntity> updateStudentRecord(
            @PathVariable int recordId, 
            @RequestBody StudentRecordEntity updatedRecord) {
        try {
            // Call the service to update the student record
            StudentRecordEntity updated = sserv.updateStudentRecord(recordId, updatedRecord);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Handle not found or other exceptions
        }
    }
	
//	@GetMapping("/getStudentRecordsByAdviser")
//	public List<StudentRecordEntity> getStudentRecordsByAdviser(@RequestParam  String sid,@RequestParam  String section,@RequestParam  String schoolYear){
//		return sserv.getStudentRecordsByAdviser(sid,section,schoolYear);
//	}
	
//	@PutMapping("/updateStudentReport") 
//	public StudentReportEntity updateStudentReport(@RequestParam int rid,@RequestBody StudentReportEntity newStudentReportDetails) {
//		return sserv.updateStudentReport(rid, newStudentReportDetails);
//	}
//	
	@DeleteMapping("/deleteStudentRecord/{rid}")
	public String deleteStudentRecord(@PathVariable int rid) {
		return sserv.deleteStudentRecord(rid);
	}
	
	@GetMapping("/getStudentRecordsByAdviser")
	public List<StudentRecordEntity> getAllStudentRecordsByAdviser(@RequestParam int grade, @RequestParam String section,@RequestParam String schoolYear ) {
	    return sserv.getAllStudentRecordsByAdviser(grade, section, schoolYear);
	}
	
}
