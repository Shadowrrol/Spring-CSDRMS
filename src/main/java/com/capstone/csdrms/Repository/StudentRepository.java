package com.capstone.csdrms.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	Optional<StudentEntity> findBySid(String sid);
	Optional<StudentEntity> findByIdAndCurrent(Long id, int current);
	List<StudentEntity> findAllBySectionAndSchoolYear(String section, String schoolYear);
	List<StudentEntity> findAllBySid(String sid);
	
	boolean existsBySidAndSchoolYear(String sid, String schoolYear); 
	
	List<StudentEntity> findAllByCurrent(int current);
	
}  