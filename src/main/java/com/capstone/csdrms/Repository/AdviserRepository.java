package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.UserEntity;


@Repository
public interface AdviserRepository extends JpaRepository<AdviserEntity, Integer> {

	AdviserEntity findByAid(String sid);
}
