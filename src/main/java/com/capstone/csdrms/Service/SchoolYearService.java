package com.capstone.csdrms.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.SchoolYearEntity;
import com.capstone.csdrms.Repository.SchoolYearRepository;

@Service
public class SchoolYearService {

	@Autowired
	SchoolYearRepository syRepository;
	
	public List<SchoolYearEntity> getAllSchoolYears(){
		return syRepository.findAll();
	}
	
	 public String addSchoolYear(SchoolYearEntity syEntity) {
		 SchoolYearEntity existingSy = syRepository.findBySchoolYear(syEntity.getSchoolYear());
	        if (existingSy == null) {
	            syRepository.save(syEntity);
	            return "School year: " + syEntity.getSchoolYear_ID() + " successfully added!";
	        }
	        else
	        return "School year: " + syEntity.getSchoolYear_ID() + " already exists!";
	    }
	
	public String deleteSchoolYear(Long schoolYear_ID) {
		Optional<SchoolYearEntity> schoolYearOptional = syRepository.findById(schoolYear_ID);
		if(schoolYearOptional.isPresent()) {
			syRepository.deleteById(schoolYear_ID);
			return "School Year successfuly deleted!";
		}
		return "School Year " + schoolYear_ID+ "doesn't exist"; 
	}
	
}
