package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.SanctionEntity;

@Repository
public interface SanctionRepository extends JpaRepository<SanctionEntity, Integer> {

    List<SanctionEntity> findByIsApproved(int isApproved);

    @Query("SELECT s FROM SanctionEntity s JOIN FETCH s.student WHERE s.isApproved = 0")
    List<SanctionEntity> findAllPendingSanctions();

    List<SanctionEntity> findByIsApprovedIn(List<Integer> isApprovedValues);
    
    List<SanctionEntity> findBySid(String sid);
    
    @Query("SELECT s FROM SanctionEntity s INNER JOIN StudentEntity st ON s.sid = st.sid WHERE st.section = ?1 AND st.schoolYear = ?2")
    List<SanctionEntity> findBySectionAndSchoolYear(String section, String schoolYear);
}
