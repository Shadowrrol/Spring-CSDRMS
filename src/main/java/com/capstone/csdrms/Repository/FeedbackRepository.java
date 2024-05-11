package com.capstone.csdrms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.csdrms.Entity.FeedbackEntity;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {

    @Query("SELECT f FROM FeedbackEntity f JOIN FETCH f.adviser JOIN FETCH f.caseEntity WHERE f.uid = :uid")
    List<FeedbackEntity> findAllByAidWithAdviserAndCase(Long uid);
    
    List<FeedbackEntity> findAllByUidAndIsAcknowledged(Long uid, int isAcknowledged);
}
