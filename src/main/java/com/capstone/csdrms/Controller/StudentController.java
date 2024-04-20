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
import com.capstone.csdrms.Service.StudentService;

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
	public StudentEntity updateStudent(@RequestParam int sid,@RequestBody StudentEntity newStudentDetails){
			return sserv.updateStudent(sid, newStudentDetails);
		}
									//(@RequestParam String sid,@RequestBody StudentEntity newStudentDetails) mao ni sauna, ilisda inyo postman

	//D - Delete a user record
	@DeleteMapping("/deleteStudent/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		return sserv.deleteStudent(sid);
	}


	//Read student by int ID, not school ID. Bag o ni siya gamit int
	@GetMapping("/getStudentID/{sid}")
	public StudentEntity getStudentById(@PathVariable int sid) {
		return sserv.getStudentById(sid);
	}
	
/*String sid ni gamit mao tong sauna pero dili mogana int sid lang ato gamiton.

	//D - Delete a user record
	@DeleteMapping("/deleteStudent/{sid}")
	public String deleteStudent(@PathVariable String sid) {
		return sserv.deleteStudent(sid);
	}

	//Read student by school ID. Mao ni tong sauna
	@GetMapping("/getStudent/{sid}")
	public StudentEntity getStudentBySchoolId(@PathVariable String school_ID) {
		return sserv.getStudentBySchoolId(school_ID);
	}
	//Read student by school ID. Mao ni tong sauna
	@GetMapping("/getStudent/{sid}")
	public StudentEntity getStudentBySchoolId(@PathVariable String school_ID) {
		return sserv.getStudentBySchoolId(school_ID);
	}
 */
}
