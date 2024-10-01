package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.ReportEntity;

@Repository
public interface ReportRepository  extends JpaRepository<ReportEntity, Long> {
	
	List<ReportEntity> findAllByStudent_SectionAndStudent_SchoolYear(String section, String schoolYear);
	
	List<ReportEntity> findAllByComplainant(String complainant);

}
