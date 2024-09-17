package com.capstone.csdrms.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;  // Correct Sheet import
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public List<StudentEntity> getStudentsByAdviser(String section, String schoolYear) {
        return srepo.findAllBySectionAndSchoolYear(section, schoolYear);
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
	
	public void importStudentData(MultipartFile file) throws Exception {
	    List<StudentEntity> students = new ArrayList<>();

	    try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
	        Sheet sheet = workbook.getSheetAt(0);  // Assuming data is in the first sheet

	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue;  // Skip header row

	            StudentEntity student = new StudentEntity();
	            
	            // Handle SID (which could be numeric in Excel)
	            if (row.getCell(0).getCellType() == CellType.NUMERIC) {
	                student.setSid(String.valueOf((long) row.getCell(0).getNumericCellValue()));
	            } else {
	                student.setSid(row.getCell(0).getStringCellValue());
	            }

	            // Handle First Name
	            student.setFirstname(row.getCell(1).getStringCellValue());

	            // Handle Middle Name (might be empty or string)
	            student.setMiddlename(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "");

	            // Handle Last Name
	            student.setLastname(row.getCell(3).getStringCellValue());

	            // Handle Grade (numeric)
	            student.setGrade((int) row.getCell(4).getNumericCellValue());

	            // Handle Section
	            student.setSection(row.getCell(5).getStringCellValue());

	            // Handle School Year
	            student.setSchoolYear(row.getCell(6).getStringCellValue());

	            // Handle Contact Number (could be numeric or string)
	            if (row.getCell(7).getCellType() == CellType.NUMERIC) {
	                student.setCon_num(String.valueOf((long) row.getCell(7).getNumericCellValue()));
	            } else {
	                student.setCon_num(row.getCell(7).getStringCellValue());
	            }

	            // Handle Current status (numeric)
	            student.setCurrent((int) row.getCell(8).getNumericCellValue());

	            students.add(student);
	        }
	    }

	    srepo.saveAll(students);
	}


	
	
}