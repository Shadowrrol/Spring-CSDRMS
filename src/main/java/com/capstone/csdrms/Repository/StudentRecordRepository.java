package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.csdrms.Entity.StudentRecordEntity;



@Repository
public interface StudentRecordRepository extends JpaRepository<StudentRecordEntity, Long> {
	
	List<StudentRecordEntity> findAllBySid(String sid);
	List<StudentRecordEntity> findAllByStudent_GradeAndStudent_SectionAndStudent_SchoolYear(int grade, String section, String schoolYear);
	
	List<StudentRecordEntity> findAllBySidAndStudent_SectionAndStudent_SchoolYear(String sid, String section, String schoolYear);
	
}
 
