package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	StudentEntity findBySid(String sid);
	List<StudentEntity> findAllBySection(String section);
}