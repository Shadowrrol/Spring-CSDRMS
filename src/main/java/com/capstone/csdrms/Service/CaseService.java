package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Repository.CaseRepository;

@Service
public class CaseService {

    @Autowired
    CaseRepository crepo;

    public CaseEntity insertCase(CaseEntity caseEntity) {
        return crepo.save(caseEntity);
    }
}
