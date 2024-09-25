package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.ReportEntity;

@Repository
public interface ReportRepository  extends JpaRepository<ReportEntity, Long> {

}
