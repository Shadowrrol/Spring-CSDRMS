package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.csdrms.Entity.FollowupEntity;

public interface FollowupRepository extends JpaRepository<FollowupEntity, Long> {
	
	

	  List<FollowupEntity> findAllByCaseEntity_Student_SectionAndCaseEntity_Student_SchoolYear(String section, String schoolYear);
	 
	  List<FollowupEntity> findAllByCaseEntity_Id(Long id);
	
}

