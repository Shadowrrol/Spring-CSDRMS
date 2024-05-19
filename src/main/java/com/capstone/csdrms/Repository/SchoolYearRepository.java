package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.csdrms.Entity.SchoolYearEntity;

public interface SchoolYearRepository extends JpaRepository<SchoolYearEntity, Long> {

	SchoolYearEntity findBySchoolYear(String SchoolYear);
}
