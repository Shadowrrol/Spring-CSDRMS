package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.StudentReportEntity;
import com.capstone.csdrms.Repository.StudentReportRepository;

@Service
public class StudentReportService {

	@Autowired
	StudentReportRepository srepo;
	
	public StudentReportEntity insertStudentReport(StudentReportEntity studentReport) {
	    return srepo.save(studentReport);
	}

	
	public List<StudentReportEntity> getAllStudentReports(){
		return srepo.findAll();
	}
	
	public List<StudentReportEntity> getStudentReportsById(String sid) {
		return srepo.findAllBySid(sid);
	}
	
	
	@SuppressWarnings("finally")
	public StudentReportEntity updateStudentReport(int rid, StudentReportEntity newStudentReportDetails) {
		StudentReportEntity student = new StudentReportEntity();
	    try {
	    	student = srepo.findById(rid).get();

	    	student.setSid(newStudentReportDetails.getSid());
	    	student.setDate(newStudentReportDetails.getDate());
	    	student.setTime(newStudentReportDetails.getTime());
	    	student.setMonitored_record(newStudentReportDetails.getMonitored_record());;
	    	student.setRemarks(newStudentReportDetails.getRemarks());
	    	student.setSanction(newStudentReportDetails.getSanction());
	       
	    } catch (NoSuchElementException ex) {
	        throw ex;
	    } finally {
	    	 return srepo.save(student);
		}
	}
	
	public StudentReportEntity getStudentReportById(String sid) {
		StudentReportEntity student = srepo.findBySid(sid);
		return student;
	}
	
	
	public String deleteStudent(int rid) {
		StudentReportEntity existingStudentReport = srepo.findById(rid).get();
	    if (existingStudentReport != null) {
	        srepo.delete(existingStudentReport);
	        return "Student Report " + rid + " is successfully deleted!";
	    } else {
	        return "Student Report" + rid + " does not exist";
	    }
	}
}
