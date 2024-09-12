package com.capstone.csdrms.Controller;

import java.util.List;
import java.util.Optional;

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
		  
		 @GetMapping("/getAllStudentsByAdviser/{adviserId}")
		 public List<StudentEntity> getStudentsByAdviser(@PathVariable Long adviserId) {
			return sserv.getStudentsByAdviser(adviserId); 
		}
		 
		 @GetMapping("/getStudentById/{id}")
		 public Optional<StudentEntity> getStudentById(@PathVariable Long id){
			 return sserv.getStudentById(id);
		 }
	
}