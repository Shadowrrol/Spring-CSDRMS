package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.csdrms.Entity.FollowupEntity;

public interface FollowupRepository extends JpaRepository<FollowupEntity, Long> {
	
	//Temporary Disabled
//	 @Query("SELECT f FROM FollowupEntity f " +
//	           "JOIN f.caseEntity c " +
//	           "JOIN c.student s " +
//	           "WHERE s.adviserId = :adviserId")
//	    List<FollowupEntity> findAllByAdviserId(@Param("adviserId") Long adviserId);
	 
	  List<FollowupEntity> findAllByCaseEntity_Id(Long id);
	
}

