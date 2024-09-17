package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.csdrms.Entity.CaseEntity;

public interface CaseRepository extends JpaRepository<CaseEntity, Integer> {
	
//	List<CaseEntity> findAllCasesBySid(String sid);
	
	@Query("SELECT c FROM CaseEntity c JOIN FETCH c.student")
	List<CaseEntity> findAllCaseWithStudentDetails();
	
//	List<CaseEntity> findAllBySid(String sid);
	
	List<CaseEntity> findAllByHandledBySSO(int handledBySSO);

	List<CaseEntity> findAllById(Long id);
	
	
	//This part is temporary disabled
//	@Query("SELECT c FROM CaseEntity c WHERE c.student.adviserId = :adviserId AND c.handledBySSO = 0")
//    List<CaseEntity> findAllByAdviserIdAndHandledBySSO(@Param("adviserId") Long adviserId);

}
