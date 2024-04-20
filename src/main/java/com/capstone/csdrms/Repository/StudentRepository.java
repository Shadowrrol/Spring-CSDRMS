package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.StudentEntity;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//StudentEntity findBySid(String sid);
	//public List<StudentRepository> findAllByName(String name);
}
