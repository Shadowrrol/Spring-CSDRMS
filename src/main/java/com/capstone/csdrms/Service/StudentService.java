package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Repository.StudentRepository;



@Service
public class StudentService {

	@Autowired
	StudentRepository srepo;
	
	/*old
	public StudentEntity insertStudent(StudentEntity student) {
		StudentEntity existingStudent = srepo.findBySid(student.getSchoolId());
	    if (existingStudent != null) {
	        throw new IllegalArgumentException("Student with id " + student.getSchoolId() + " already exists");
	    }
	    return srepo.save(student);
	}
	*/
	public StudentEntity insertStudent(StudentEntity newStudent) {
        // Retrieve all entities from the database
        List<StudentEntity> students = srepo.findAll();
		String schoolID;
        // Iterate through each entity and access its attributes
        for (StudentEntity a : students) {
			schoolID = a.getSchoolId();
			if (schoolID == newStudent.getSchoolId()) {
				throw new IllegalArgumentException("Student with school id " + newStudent.getSchoolId() + " already exists");
			}
			
        }
		return srepo.save(newStudent);
	}
	public List<StudentEntity> getStudents(){
		return srepo.findAll();
	}
	
	@SuppressWarnings("finally")
	public StudentEntity updateStudent(int sid, StudentEntity newStudentDetails) {
		StudentEntity student = new StudentEntity();
	    try {
	    	student = srepo.findById(sid).get();
			student.setSchoolId(newStudentDetails.getSchoolId());
	    	student.setFirstname(newStudentDetails.getFirstname());
	    	student.setMiddlename(newStudentDetails.getMiddlename());
	    	student.setLastname(newStudentDetails.getLastname());
	    	student.setGrade(newStudentDetails.getGrade());
	    	student.setSection(newStudentDetails.getSection());
	    	student.setCon_num(newStudentDetails.getCon_num());
	    	
	       
	    } catch (NoSuchElementException ex) {
	        throw ex;
	    } finally {
	    	 return srepo.save(student);
		}
	}
	
	public StudentEntity getStudentById(int sid) {
		StudentEntity student = srepo.findById(sid).get();
		return student;
	}
	/*gamit string id mo error ambot mano
	public StudentEntity getStudentBySchoolId(String sid) {
		StudentEntity student = srepo.findBySid(sid);
		return student;
	}
	gagamit ta og string id aron ma find nato pero mag error siya basta tagaan nako og auto generated int id ang studentEntity.
	e keep unta ni nako ning searching gamit string pero dili mo coexist.
	*/
		
	/*public String deleteStudent(String sid) {
		StudentEntity existingStudent = srepo.findBySid(sid);
	*/ 

	public String deleteStudent(int sid) {
		StudentEntity existingStudent = srepo.findById(sid).get();
		if (existingStudent != null) {
	        srepo.delete(existingStudent);
	        return "Student " + sid + " is successfully deleted!";
	    } else {
	        return "Student " + sid + " does not exist";
	    }
		
	} 
}