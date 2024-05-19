package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.csdrms.Entity.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long>{

	@Query("SELECT c.section FROM ClassEntity c WHERE c.grade = ?1")
    List<String> findAllSectionsByGrade(int grade);
	
	 @Query("SELECT DISTINCT c.grade FROM ClassEntity c")
	 List<Integer> findAllUniqueGrades();
}
