package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Repository.CaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    // Get all cases
    public List<CaseEntity> getAllCases() {
        return caseRepository.findAllCaseWithStudentDetails();
    }

    // Get case by ID
    public Optional<CaseEntity> getCaseById(int id) {
        return caseRepository.findById(id);
    }

    // Insert or update a case
    public CaseEntity saveCase(CaseEntity caseEntity) {
        return caseRepository.save(caseEntity);
    }

    // Delete case by ID
    public void deleteCase(int id) {
        caseRepository.deleteById(id);
    }
    
    public Optional<CaseEntity> completeCase(int caseId) {
        return caseRepository.findById(caseId)
                .map(caseEntity -> {
                    caseEntity.setStatus("Completed");
                    return caseRepository.save(caseEntity);
                });
    }
    
    public List<CaseEntity> getAllCaseBySid(String sid){
    	return caseRepository.findAllCasesBySid(sid);
    }
}
