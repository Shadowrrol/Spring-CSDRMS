package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.SSOEntity;

//Mao ni ang UserRepository sauna
@Repository
public interface SSORepository extends JpaRepository<SSOEntity, Integer> {

	SSOEntity findByUsername(String username);
}
