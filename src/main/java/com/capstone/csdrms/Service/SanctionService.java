package com.capstone.csdrms.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.SanctionEntity;
import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.StudentReportEntity;
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
	
	

	 @Transactional
	    public SanctionEntity insertSanction(SanctionEntity sanction) {
	        SanctionEntity savedSanction = srepo.save(sanction);
	        
	        // Automatically insert a student report after the sanction is added
	        insertStudentReportFromSanction(savedSanction);
	        
	        return savedSanction;
	    }
	    
	    private void insertStudentReportFromSanction(SanctionEntity sanction) {
	        // Find the student by SID from the sanction
	    	Optional<StudentEntity> studentOptional = studentRepository.findById(sanction.getId());
	        
	        if (studentOptional.isPresent()) {
	            StudentEntity student = studentOptional.get();
	            
	            // Prepare the student report entity
	            StudentReportEntity studentReport = new StudentReportEntity();
	            Long temp_id = student.getId();
	            System.out.println("Student ID is: "+ temp_id);
	            studentReport.setId(student.getId());
	            studentReport.setSid(student.getSid());
	             
	            // Automatically set the current date and time
	            LocalDate today = LocalDate.now();
	            LocalTime currentTime = LocalTime.now();
	            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            
	            studentReport.setMonitored_record("Sanction");
	            studentReport.setRecord_date(today.toString());
	            studentReport.setIncident_date(today.toString());  // Assuming the incident happened today
	            studentReport.setTime(currentTime.format(timeFormatter)); // Set the current time
	            
	            // Set the remarks from the sanction recommendation
	            studentReport.setRemarks(sanction.getSanctionRecommendation());
	            
	            // Save the student report
	            studentReportRepository.save(studentReport);
	        } else {
	            // Handle case where student doesn't exist
	            throw new IllegalArgumentException("Student with id " + sanction.getId() + " not found.");
	        }
	    }
	 
	public List<SanctionEntity> getPendingSanctions(){
        return srepo.findAllPendingSanctions();
    }
	
	public List<SanctionEntity> getAllSanctionsBySid(Long id){
        return srepo.findAllById(id);
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
		    return srepo.findBySectionAndSchoolYear(section, schoolYear);
		}
}
