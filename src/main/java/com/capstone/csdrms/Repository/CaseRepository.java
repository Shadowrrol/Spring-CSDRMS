package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.CaseEntity;

@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, Integer> {

}
