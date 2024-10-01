package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.StudentRecordEntity;
import com.capstone.csdrms.Repository.StudentRecordRepository;

@Service 
public class StudentRecordService {

	@Autowired
	StudentRecordRepository srepo;
	
	public StudentRecordEntity insertStudentRecord(StudentRecordEntity studentRecord) {
	    return srepo.save(studentRecord);
	}

	public List<StudentRecordEntity> getAllStudentRecords(){
		return srepo.findAll();
	}
	
	public 	List<StudentRecordEntity> getAllStudentRecordsBySectionAndSchoolYear(String section, String schoolYear){
		return srepo.findAllByStudent_SectionAndStudent_SchoolYear(section, schoolYear);
	}
	
	public List<StudentRecordEntity> getStudentRecordsBySid(String sid) {
		return srepo.findAllBySid(sid);
	}
	
	public List<StudentRecordEntity> getStudentRecordsByAdviser(String sid, String section, String schoolYear){
		return srepo.findAllBySidAndStudent_SectionAndStudent_SchoolYear(sid, section, schoolYear);
	}
	
//	@SuppressWarnings("finally")
//	public StudentReportEntity updateStudentReport(int rid, StudentReportEntity newStudentReportDetails) {
//		StudentReportEntity student = new StudentReportEntity();
//	    try {
//	    	student = srepo.findById(rid).get();
//
//	    	student.setSid(newStudentReportDetails.getSid());
//	    	student.setDate(newStudentReportDetails.getDate());
//	    	student.setMonitored_record(newStudentReportDetails.getMonitored_record());;
//	    	student.setRemarks(newStudentReportDetails.getRemarks());
//	    	student.setSanction(newStudentReportDetails.getSanction());
//	       
//	    } catch (NoSuchElementException ex) {
//	        throw ex;
//	    } finally {
//	    	 return srepo.save(student);
//		}
//	}
	
	public String deleteStudentRecord(int rid) {
		StudentRecordEntity existingStudentReport = srepo.findById(rid).get();
	    if (existingStudentReport != null) {
	        srepo.delete(existingStudentReport);
	        return "Student Report " + rid + " is successfully deleted!";
	    } else {
	        return "Student Report" + rid + " does not exist";
	    }
	}
}
