package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.csdrms.Entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{

	AdminEntity findByUsername(String username);
}
