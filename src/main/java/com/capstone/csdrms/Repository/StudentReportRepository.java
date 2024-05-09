package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.csdrms.Entity.StudentReportEntity;



@Repository
public interface StudentReportRepository extends JpaRepository<StudentReportEntity, Integer> {

	StudentReportEntity findBySid(String sid);
	
	List<StudentReportEntity> findAllBySid(String sid);

	List<StudentReportEntity> findAllByDateBetween(String startDate, String endDate);
	
	List<StudentReportEntity> findAllBySectionAndSchoolYear(String section, String schoolYear);
	
	List<StudentReportEntity> findAllByGrade(int grade);
	
	List<StudentReportEntity> findAllBySidIn(List<String> sid);
	
	 List<StudentReportEntity> findAllBySchoolYear(String schoolYear);
}
 