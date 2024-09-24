package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.GuidanceEntity;

@Repository
public interface GuidanceRepository extends JpaRepository<GuidanceEntity, Long>{

	GuidanceEntity findByUsername(String username);
}
