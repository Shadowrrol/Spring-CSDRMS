package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Entity.UserEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	StudentEntity findBySid(String sid);
}
