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
	
	
	public StudentEntity insertStudent(StudentEntity student) {
		StudentEntity existingStudent = srepo.findBySid(student.getSid());
	    if (existingStudent != null) {
	        throw new IllegalArgumentException("Student with id " + student.getSid() + " already exists");
	    }
	    return srepo.save(student);
	}

	
	public List<StudentEntity> getStudents(){
		return srepo.findAll();
	}
	
	
	@SuppressWarnings("finally")
	public StudentEntity updateStudent(String sid, StudentEntity newStudentDetails) {
		StudentEntity student = new StudentEntity();
	    try {
	    	student = srepo.findBySid(sid);

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
	
	
	public String deleteStudent(String sid) {
		StudentEntity existingStudent = srepo.findBySid(sid);
	    if (existingStudent != null) {
	        srepo.delete(existingStudent);
	        return "Student " + sid + " is successfully deleted!";
	    } else {
	        return "Student " + sid + " does not exist";
	    }
	}
	
	
}
