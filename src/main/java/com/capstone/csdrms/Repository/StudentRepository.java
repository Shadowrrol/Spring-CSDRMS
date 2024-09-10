package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	StudentEntity findBySid(String sid);
	List<StudentEntity> findAllBySectionAndSchoolYear(String section, String schoolYear);
	
	boolean existsBySidAndSchoolYear(String sid, String schoolYear); 
} 