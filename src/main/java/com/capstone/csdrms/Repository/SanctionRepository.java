package com.capstone.csdrms.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.SanctionEntity;

@Repository
public interface SanctionRepository extends JpaRepository<SanctionEntity, Integer> {

    List<SanctionEntity> findByIsApproved(int isApproved);

    Optional<SanctionEntity> findByCaseEntity_Id(Long id);
    List<SanctionEntity> findByIsApprovedIn(List<Integer> isApprovedValues);
    
//    List<SanctionEntity> findBySid(String sid);
    
    
    List<SanctionEntity> findByCaseEntity_Student_SectionAndCaseEntity_Student_SchoolYear(String section, String schoolYear);

	List<SanctionEntity> findAllByCaseEntity_Id(Long id);
}
