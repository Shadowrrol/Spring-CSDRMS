package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.csdrms.Entity.FollowupEntity;

public interface FollowupRepository extends JpaRepository<FollowupEntity, Long> {
}
