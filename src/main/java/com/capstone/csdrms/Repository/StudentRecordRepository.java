package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.csdrms.Entity.StudentRecordEntity;



@Repository
public interface StudentRecordRepository extends JpaRepository<StudentRecordEntity, Integer> {
	
	List<StudentRecordEntity> findAllBySid(String sid);
	List<StudentRecordEntity> findAllByStudent_SectionAndStudent_SchoolYear(String section, String schoolYear);
	
}
 