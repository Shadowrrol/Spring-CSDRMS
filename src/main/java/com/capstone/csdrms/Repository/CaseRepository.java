package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.csdrms.Entity.CaseEntity;

public interface CaseRepository extends JpaRepository<CaseEntity, Integer> {
}
