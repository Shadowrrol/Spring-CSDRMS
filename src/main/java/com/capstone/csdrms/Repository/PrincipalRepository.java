package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.PrincipalEntity;


@Repository
public interface PrincipalRepository extends JpaRepository<PrincipalEntity, Integer> {
    PrincipalEntity findByUsername(String username);
}
