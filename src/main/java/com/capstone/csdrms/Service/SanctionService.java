package com.capstone.csdrms.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Entity.SanctionEntity;
import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.StudentReportEntity;
import com.capstone.csdrms.Repository.CaseRepository;
import com.capstone.csdrms.Repository.SanctionRepository;
import com.capstone.csdrms.Repository.StudentReportRepository;
import com.capstone.csdrms.Repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class SanctionService {
	
	@Autowired
	SanctionRepository srepo;
	
	@Autowired
	StudentReportRepository studentReportRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CaseRepository caseRepository;
	
	 

	@Transactional
	public SanctionEntity insertSanction(SanctionEntity sanction) {
	    // Fetch the associated CaseEntity using the cid (case ID)
	    Optional<CaseEntity> caseOptional = caseRepository.findById(sanction.getCid());
	    
	    if (caseOptional.isPresent()) {
	        CaseEntity caseEntity = caseOptional.get();
	        // Set the CaseEntity in the sanction
	        sanction.setCaseEntity(caseEntity);
	        
	        // Save the sanction entity
	        SanctionEntity savedSanction = srepo.save(sanction);
	        
	        // Automatically insert a student report after the sanction is added
	        insertStudentReportFromSanction(savedSanction);
	        
	        return savedSanction;
	    } else {
	        throw new IllegalArgumentException("Case with id " + sanction.getCid() + " not found.");
	    }
	}
	    
	 private void insertStudentReportFromSanction(SanctionEntity sanction) {
		    StudentEntity student = sanction.getCaseEntity().getStudent(); // Direct access to the student entity

		    if (student != null) {
		        // Prepare and set the fields of StudentReportEntity
		        StudentReportEntity studentReport = new StudentReportEntity();
		        studentReport.setId(student.getId());
		        studentReport.setSid(student.getSid());
		        
		        // Automatically set the current date and time
		        LocalDate today = LocalDate.now();
		        LocalTime currentTime = LocalTime.now();
		        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		        studentReport.setMonitored_record("Sanction");
		        studentReport.setRecord_date(today.toString());
		        studentReport.setIncident_date(today.toString());  // Assuming incident happened today
		        studentReport.setTime(currentTime.format(timeFormatter));

		        studentReport.setRemarks(sanction.getSanctionRecommendation());

		        // Save the student report
		        studentReportRepository.save(studentReport);
		    } else {
		        throw new IllegalArgumentException("Student not found for the given sanction.");
		    }
		}
	    
	    
	public List<SanctionEntity> getAllSanctions(){
		return srepo.findAll();
	}
	
	public List<SanctionEntity> getAllSanctionsById(Long id){
        return srepo.findAllByCaseEntity_Id(id);
    }
	
	 @Transactional
	    public boolean approveSanction(int sanctionId) {
	        Optional<SanctionEntity> optionalSanction = srepo.findById(sanctionId);
	        if (optionalSanction.isPresent()) {
	            SanctionEntity sanction = optionalSanction.get();
	            sanction.setIsApproved(1);
	            srepo.save(sanction);
	            return true;
	        }
	        return false;
	    }
	 
	 @Transactional
	    public boolean declineSanction(int sanctionId) {
	        Optional<SanctionEntity> optionalSanction = srepo.findById(sanctionId);
	        if (optionalSanction.isPresent()) {
	            SanctionEntity sanction = optionalSanction.get();
	            sanction.setIsApproved(2);
	            srepo.save(sanction);
	            return true;
	        }
	        return false;
	    }
	 
	 public List<SanctionEntity> getApprovedAndDeclinedSanctions() {
		 return srepo.findByIsApprovedIn(List.of(1, 2));
	    }
	 
	 public List<SanctionEntity> getSanctionsBySectionAndSchoolYear(String section, String schoolYear) {
		    return srepo.findByCaseEntity_Student_SectionAndCaseEntity_Student_SchoolYear(section, schoolYear);
		}
}
