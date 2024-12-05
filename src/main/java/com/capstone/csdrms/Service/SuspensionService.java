package com.capstone.csdrms.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Entity.ReportEntity;
import com.capstone.csdrms.Entity.SuspensionEntity;
import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.StudentRecordEntity;
import com.capstone.csdrms.Repository.CaseRepository;
import com.capstone.csdrms.Repository.ReportRepository;
import com.capstone.csdrms.Repository.SuspensionRepository;
import com.capstone.csdrms.Repository.StudentRecordRepository;
import com.capstone.csdrms.Repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class SuspensionService {
	
	@Autowired
	SuspensionRepository srepo;
	
	@Autowired
	StudentRecordRepository studentRecordRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ReportRepository reportRepository;
	
	
	 

	@Transactional
	public SuspensionEntity insertSuspension(SuspensionEntity suspension) {
	    // Fetch the associated CaseEntity using the cid (case ID)
	    Optional<ReportEntity> reportOptional = reportRepository.findById(suspension.getReportId());
	    
	    if (reportOptional.isPresent()) {
	    	ReportEntity reportEntity = reportOptional.get();
	        // Set the CaseEntity in the sanction
	    	suspension.setReportEntity(reportEntity);
	        
	        // Save the sanction entity
	        SuspensionEntity savedSanction = srepo.save(suspension);
	        
	        // Automatically insert a student report after the sanction is added
	        insertStudentRecordFromSanction(savedSanction);
	        
	        return savedSanction;
	    } else {
	        throw new IllegalArgumentException("Report with id " + suspension.getReportId()+ " not found.");
	    }
	}
	    
	 private void insertStudentRecordFromSanction(SuspensionEntity suspension) {
		    StudentEntity student = suspension.getReportEntity().getRecord().getStudent(); // Direct access to the student entity

		    if (student != null) {
		        // Prepare and set the fields of StudentReportEntity
		        Optional<StudentRecordEntity> studentRecordOptional = studentRecordRepository.findById(suspension.getReportEntity().getRecordId());
		        
		        StudentRecordEntity studentRecord = studentRecordOptional.orElseGet(StudentRecordEntity::new);
		        
		        String sanction = "Suspended for " + suspension.getDays()+" days starting from "+ suspension.getStartDate() + " to " +suspension.getEndDate() + " and will be return at " +suspension.getReturnDate() ;      

		        studentRecord.setSanction(sanction);
		        // Save the student record
		        studentRecordRepository.save(studentRecord);
		    } else {
		        throw new IllegalArgumentException("Student not found for the given sanction.");
		    }
		}
	    
	    
	public List<SuspensionEntity> getAllSuspensions(){
		return srepo.findAll();
	}
	
	public List<SuspensionEntity> getAllSuspensionsByStudentId(Long id){
		return srepo.findByReportEntity_Record_Student_Id(id);
	}
	
	public List<SuspensionEntity> getAllSuspensionsByGradeSectionAndSchoolYear(int grade, String section, String schoolYear){
		return srepo.findAllByReportEntity_Record_Student_GradeAndReportEntity_Record_Student_SectionAndReportEntity_Record_Student_SchoolYear(grade, section, schoolYear);
	}
	
	public List<SuspensionEntity> getAllSuspensionByComplainant(String username){
		return srepo.findAllByReportEntity_Complainant(username);
	}
	
	public List<SuspensionEntity> getAllUnviewedSuspensionsForSso(){
		return srepo.findAllByViewedBySsoFalse();
	}
	
	public List<SuspensionEntity> getAllUnviewedSuspensionsForPrincipal(){
		return srepo.findAllByViewedByPrincipalFalse();
	}
	
	public List<SuspensionEntity> getAllUnviewedSuspensionsForAdviser(int grade, String section, String schoolYear){
		return srepo.findAllByReportEntity_Record_Student_GradeAndReportEntity_Record_Student_SectionAndReportEntity_Record_Student_SchoolYearAndViewedByAdviserFalse(grade, section, schoolYear);
	}
	
	public List<SuspensionEntity> getAllUnviewedSuspensionsForComplainant(String username){
		return srepo.findAllByReportEntity_ComplainantAndViewedByComplainantFalse(username);
	}
	
	 public void markSuspensionsAsViewedForSso() {
	        List<SuspensionEntity> suspensions = srepo.findAllByViewedBySsoFalse();
	        suspensions.forEach(suspension -> suspension.setViewedBySso(true));
	        srepo.saveAll(suspensions);
	 }
	 
	 public void markSuspensionsAsViewedForPrincipal() {
	        List<SuspensionEntity> suspensions = srepo.findAllByViewedByPrincipalFalse();
	        suspensions.forEach(suspension -> suspension.setViewedByPrincipal(true));
	        srepo.saveAll(suspensions);
	 }
	 
	 public void markSuspensionsAsViewedForAdviser(int grade, String section, String schoolYear) {
	        List<SuspensionEntity> suspensions = srepo.findAllByReportEntity_Record_Student_GradeAndReportEntity_Record_Student_SectionAndReportEntity_Record_Student_SchoolYearAndViewedByAdviserFalse(grade, section, schoolYear);
	        suspensions.forEach(suspension -> suspension.setViewedByAdviser(true));
	        srepo.saveAll(suspensions);
	 }
	 
	 public void markSuspensionsAsViewedForComplainant(String username) {
		 	List<SuspensionEntity> suspensions = srepo.findAllByReportEntity_ComplainantAndViewedByComplainantFalse(username);
	        suspensions.forEach(suspension -> suspension.setViewedByComplainant(true));
	        srepo.saveAll(suspensions);
	 }
	  
	 public Optional<SuspensionEntity> getSuspensionByReportId(Long reportId) {
	        return srepo.findByReportId(reportId);
	    }
	 
//	public List<SuspensionEntity> getAllSanctionsById(Long id){
//        return srepo.findAllByCaseEntity_Id(id);
//    }
//	
//	 @Transactional
//	    public boolean approveSanction(int sanctionId) {
//	        Optional<SuspensionEntity> optionalSanction = srepo.findById(sanctionId);
//	        if (optionalSanction.isPresent()) {
//	            SuspensionEntity sanction = optionalSanction.get();
//	            sanction.setIsApproved(1);
//	            srepo.save(sanction);
//	            return true;
//	        }
//	        return false;
//	    }
//	 
//	 @Transactional
//	    public boolean declineSanction(int sanctionId) {
//	        Optional<SuspensionEntity> optionalSanction = srepo.findById(sanctionId);
//	        if (optionalSanction.isPresent()) {
//	            SuspensionEntity sanction = optionalSanction.get();
//	            sanction.setIsApproved(2);
//	            srepo.save(sanction);
//	            return true;
//	        }
//	        return false;
//	    }
//	 
//	 public List<SuspensionEntity> getApprovedAndDeclinedSanctions() {
//		 return srepo.findByIsApprovedIn(List.of(1, 2));
//	    }
//	 
//	 public List<SuspensionEntity> getSanctionsBySectionAndSchoolYear(String section, String schoolYear) {
//		    return srepo.findByCaseEntity_Student_SectionAndCaseEntity_Student_SchoolYear(section, schoolYear);
//		}
}
