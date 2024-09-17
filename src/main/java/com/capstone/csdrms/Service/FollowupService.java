package com.capstone.csdrms.Service;

import java.util.List;

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
    
    public List<FollowupEntity> getAllFollowUps() {
        return followupRepository.findAll();
    }
    
    //Temporary Disabled

//    public List<FollowupEntity> getAllFollowUpsByAdviser(Long adviserId) {
//        return followupRepository.findAllByAdviserId(adviserId);
//    }
}

