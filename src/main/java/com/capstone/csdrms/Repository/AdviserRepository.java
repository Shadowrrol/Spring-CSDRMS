package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.AdviserEntity;

@Repository
public interface AdviserRepository extends JpaRepository<AdviserEntity, Integer> {
}
