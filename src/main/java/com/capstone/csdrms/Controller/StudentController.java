package com.capstone.csdrms.Controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.multipart.MultipartFile;

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService sserv;
	
	
		@PostMapping("/insertStudent")
		public StudentEntity insertStudent(@RequestBody StudentEntity student) {
			return sserv.insertStudent(student);
		}
		
		@GetMapping("/getAllCurrentStudents")
		public List<StudentEntity> getCurrentStudents(){
			return sserv.getCurrentStudents();
		}
		  
//		@PutMapping("/updateStudent")
//		public StudentEntity updateStudent(@RequestParam String sid,@RequestBody StudentEntity newStudentDetails){
//			return sserv.updateStudent(sid, newStudentDetails);
//		}
		
//		@DeleteMapping("/deleteStudent/{sid}")
//		public String deleteStudent(@PathVariable String sid) {
//			return sserv.deleteStudent(sid);
//		}
		
		@GetMapping("/getCurrentStudent/{id}")
		public Optional<StudentEntity> getCurrentStudentById(@PathVariable Long id) {
			return sserv.getCurrentStudentById(id);
		}
		  
		 @GetMapping("/getAllStudentsByAdviser/{section}/{schoolYear}")
		 public List<StudentEntity> getStudentsByAdviser(@PathVariable String section,@PathVariable String schoolYear) {
			return sserv.getStudentsByAdviser(section, schoolYear); 
		}
		 
		 @GetMapping("/getStudentById/{id}")
		 public Optional<StudentEntity> getStudentById(@PathVariable Long id){
			 return sserv.getStudentById(id);
		 }
		 
		 @PostMapping("/import")
		    public ResponseEntity<?> importStudentData(@RequestParam("file") MultipartFile file, @RequestParam String schoolYear) {
		        try {
		        	sserv.importStudentData(file,schoolYear);  // Call service to process the Excel file
		            return ResponseEntity.ok("File uploaded and students imported successfully");
		        } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
		        }
		    }
	
}