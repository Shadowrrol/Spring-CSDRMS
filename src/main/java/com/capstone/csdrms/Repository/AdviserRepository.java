package com.capstone.csdrms.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.AdviserEntity;

@Repository
public interface AdviserRepository extends JpaRepository<AdviserEntity, Long> {
    AdviserEntity findByUsername(String username);
    Optional<AdviserEntity> findByGradeAndSectionAndSchoolYear(String grade, String section, String schoolYear);
    
    Optional<AdviserEntity> findBySectionAndSchoolYear(String section, String schooYear);
}
