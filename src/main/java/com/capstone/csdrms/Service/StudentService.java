package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Entity.FeedbackEntity;
import com.capstone.csdrms.Entity.FollowupEntity;
import com.capstone.csdrms.Entity.SanctionEntity;
import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.StudentReportEntity;
import com.capstone.csdrms.Repository.CaseRepository;
import com.capstone.csdrms.Repository.FeedbackRepository;
import com.capstone.csdrms.Repository.FollowupRepository;
import com.capstone.csdrms.Repository.SanctionRepository;
import com.capstone.csdrms.Repository.StudentReportRepository;
import com.capstone.csdrms.Repository.StudentRepository;



@Service
public class StudentService {

	@Autowired
	StudentRepository srepo;
	
	@Autowired
	StudentReportRepository studentrepo;
	
	@Autowired
	FeedbackRepository feedbackrepo;
	
	@Autowired
	CaseRepository caserepo;
	
	@Autowired
	SanctionRepository sanctionrepo;
	
	@Autowired
	FollowupRepository followuprepo;
	
	
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
	
	public List<StudentEntity> getStudentsBySectionAndSchoolYear(String section, String schoolYear) {
        return srepo.findAllBySectionAndSchoolYear(section, schoolYear);
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
		
		List<FeedbackEntity> existingFeedbacksByStudent = feedbackrepo.findALLByCaseEntity_Sid(sid);
		List<StudentReportEntity> existingReportsByStudent = studentrepo.findAllBySid(sid);
		List<CaseEntity> existingCasesByStudent = caserepo.findAllBySid(sid);
		
		List<FollowupEntity> existingFollowupsByStudent = followuprepo.findAllByCaseEntity_Sid(sid);
		List<SanctionEntity> existingSanctionsByStudent = sanctionrepo.findBySid(sid);
		
		studentrepo.deleteAll(existingReportsByStudent);
		sanctionrepo.deleteAll(existingSanctionsByStudent);
		feedbackrepo.deleteAll(existingFeedbacksByStudent);
		followuprepo.deleteAll(existingFollowupsByStudent);
		caserepo.deleteAll(existingCasesByStudent);
		 srepo.delete(existingStudent);
		 
		return "Student " + sid + " is successfully deleted!";
//	    if (existingStudent != null) {
//	        srepo.delete(existingStudent);
//	        return "Student " + sid + " is successfully deleted!";
//	    } else {
//	        return "Student " + sid + " does not exist";
//	    }
	}
	
	public StudentEntity getStudentById(String sid) {
		StudentEntity student = srepo.findBySid(sid);
		return student;
	}
	
	
}