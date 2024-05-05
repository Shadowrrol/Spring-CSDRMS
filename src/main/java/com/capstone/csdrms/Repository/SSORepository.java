package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.SSOEntity;

@Repository
public interface SSORepository extends JpaRepository<SSOEntity, Long> {

	SSOEntity findByUsername(String username);
}
