package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.csdrms.Entity.StudentReportEntity;



@Repository
public interface StudentReportRepository extends JpaRepository<StudentReportEntity, Integer> {
	
	List<StudentReportEntity> findAllBySid(String sid);
	List<StudentReportEntity> findBySectionAndSchoolYear(String section, String schoolYear);
	
}
 