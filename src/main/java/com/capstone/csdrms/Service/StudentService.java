package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	
	
	public boolean studentExists(String sid, String schoolYear) {
	    return srepo.existsBySidAndSchoolYear(sid, schoolYear);
	}

	public StudentEntity insertStudent(StudentEntity student) {
	    if (studentExists(student.getSid(), student.getSchoolYear())) {
	        throw new IllegalStateException("Student with this ID and school year already exists.");
	    }

	    List<StudentEntity> existingStudents = srepo.findAllBySid(student.getSid());
	    
	    if (!existingStudents.isEmpty()) {
	        for (StudentEntity existingStudent : existingStudents) {
	            existingStudent.setCurrent(0); 
	            srepo.save(existingStudent);   
	        }
	    }
	    return srepo.save(student);
	}
 
	 
	public List<StudentEntity> getCurrentStudents(){
		return srepo.findAllByCurrent(1);
	}
	
	public List<StudentEntity> getStudentsByAdviser(Long adviserId) {
        return srepo.findAllByAdviserId(adviserId);
    }

//	@SuppressWarnings("finally")
//	public StudentEntity updateStudent(String sid, StudentEntity newStudentDetails) {
//		StudentEntity student = new StudentEntity();
//	    try {
//	    	student = srepo.findBySid(sid);
//
//	    	student.setFirstname(newStudentDetails.getFirstname());
//	    	student.setMiddlename(newStudentDetails.getMiddlename());
//	    	student.setLastname(newStudentDetails.getLastname());
//	    	student.setGrade(newStudentDetails.getGrade());
//	    	student.setSection(newStudentDetails.getSection());
//	    	student.setCon_num(newStudentDetails.getCon_num());
//	    	
//	       
//	    } catch (NoSuchElementException ex) {
//	        throw ex;
//	    } finally {
//	    	 return srepo.save(student);
//		}
//	}
//	
	
//	public String deleteStudent(String sid) {
//		Optional<StudentEntity> existingStudent = srepo.findBySid(sid);
//		
//		List<FeedbackEntity> existingFeedbacksByStudent = feedbackrepo.findALLByCaseEntity_Sid(sid);
//		List<StudentReportEntity> existingReportsByStudent = studentrepo.findAllBySid(sid);
//		List<CaseEntity> existingCasesByStudent = caserepo.findAllBySid(sid);
//		
//		List<FollowupEntity> existingFollowupsByStudent = followuprepo.findAllByCaseEntity_Sid(sid);
//		List<SanctionEntity> existingSanctionsByStudent = sanctionrepo.findBySid(sid);
//		
//		studentrepo.deleteAll(existingReportsByStudent);
//		sanctionrepo.deleteAll(existingSanctionsByStudent);
//		feedbackrepo.deleteAll(existingFeedbacksByStudent);
//		followuprepo.deleteAll(existingFollowupsByStudent);
//		caserepo.deleteAll(existingCasesByStudent);
//		 srepo.delete(existingStudent);
//		 
//		return "Student " + sid + " is successfully deleted!";
////	    if (existingStudent != null) {
////	        srepo.delete(existingStudent);
////	        return "Student " + sid + " is successfully deleted!";
////	    } else {
////	        return "Student " + sid + " does not exist";
////	    }
//	}
	
	public Optional<StudentEntity> getCurrentStudentById(Long id) {
		return srepo.findByIdAndCurrent(id, 1);
	}
	
	public Optional<StudentEntity> getStudentById(Long id){
		return srepo.findById(id);
	}
	
	
}