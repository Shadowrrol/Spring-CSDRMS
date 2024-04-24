package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.SanctionEntity;


@Repository
public interface SanctionRepository  extends JpaRepository<SanctionEntity, Integer> {

	List<SanctionEntity> findByIsApproved(int isApproved);
}
