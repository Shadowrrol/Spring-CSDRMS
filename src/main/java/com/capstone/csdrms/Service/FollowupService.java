package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.FollowupEntity;
import com.capstone.csdrms.Repository.FollowupRepository;

@Service
public class FollowupService {
    @Autowired
    private FollowupRepository followupRepository;

    public FollowupEntity saveFollowup(FollowupEntity followup) {
        return followupRepository.save(followup);
    }
}

