package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
	
	public List<StudentReportEntity> getAllStudentReportsByYear(String year) {
        if (year == null || year.isEmpty()) {
            return srepo.findAll(); // Return all reports if year is not specified
        } else {
            // Assuming the date format is "yyyy-MM-dd"
            String startDate = year + "-01-01";
            String endDate = year + "-12-31";
            return srepo.findAllByDateBetween(startDate, endDate);
        }
    }
	
	public  List<StudentReportEntity> getAllStudentReportsByGrade(int grade) {
		return srepo.findAllByGrade(grade);
	} 
	
	public List<StudentReportEntity> getAllStudentReportsByYearAndGrade(String year, int grade) {
        // Assuming your StudentReport entity has fields like 'date' and 'grade'
        List<StudentReportEntity> allReports = srepo.findAll();
        return filterReportsByYearAndGrade(allReports, year, grade);
    }
    
    private List<StudentReportEntity> filterReportsByYearAndGrade(List<StudentReportEntity> reports, String year, int grade) {
        // Filter reports by year and grade
        return reports.stream()
                      .filter(report -> getYearFromDate(report.getDate()).equals(year) && report.getGrade() == grade)
                      .collect(Collectors.toList());
    }

    private String getYearFromDate(String date) {
        // Assuming the date string format is 'YYYY-MM-DD'
        return date.split("-")[0];
    }
	
	public 	List<StudentReportEntity> getAllStudentReportsBySectionAndSchoolYear(String section, String school_year){
		return srepo.findAllBySectionAndSchoolYear(section, school_year);
	}
	
	public List<StudentReportEntity> getStudentReportsBySchoolYear(String schoolYear) {
		return srepo.findAllBySchoolYear(schoolYear);
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
