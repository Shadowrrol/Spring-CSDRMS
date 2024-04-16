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

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.UserEntity;
import com.capstone.csdrms.Service.StudentService;
import com.capstone.csdrms.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService sserv;
	
	//C - Create a user record
		@PostMapping("/insertStudent")
		public StudentEntity insertStudent(@RequestBody StudentEntity student) {
			return sserv.insertStudent(student);
		}
		
		//R - Read all user records in tblUser
		@GetMapping("/getAllStudents")
		public List<StudentEntity> getStudents(){
			return sserv.getStudents();
		}
		
		//U - Update a user record
		@PutMapping("/updateStudent")
		public StudentEntity updateStudent(@RequestParam String sid,@RequestBody StudentEntity newStudentDetails){
			return sserv.updateStudent(sid, newStudentDetails);
		}
		
		//D - Delete a user record
		@DeleteMapping("/deleteStudent/{sid}")
		public String deleteStudent(@PathVariable String sid) {
			return sserv.deleteStudent(sid);
		}
	
}
