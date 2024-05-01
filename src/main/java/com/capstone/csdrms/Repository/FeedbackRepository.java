package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.FeedbackEntity;


@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {
	
	
}
