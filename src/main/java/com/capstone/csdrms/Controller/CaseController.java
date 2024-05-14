package com.capstone.csdrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capstone.csdrms.Entity.CaseEntity;
import com.capstone.csdrms.Service.CaseService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    // Get all cases
    @GetMapping
    public List<CaseEntity> getAllCases() {
        return caseService.getAllCases();
    }

    // Get a single case by ID
    @GetMapping("/{id}")
    public Optional<CaseEntity> getCaseById(@PathVariable int id) {
        return caseService.getCaseById(id);
    }

    // Insert or update a case 
    @PostMapping
    public CaseEntity saveCase(@RequestBody CaseEntity caseEntity) {
        return caseService.saveCase(caseEntity);
    }

    // Update a case by ID
    @PutMapping("/{id}")
    public CaseEntity updateCase(@PathVariable int id, @RequestBody CaseEntity updatedCase) {
        return caseService.getCaseById(id)
                .map(existingCase -> {
                    existingCase.setSid(updatedCase.getSid());
                    existingCase.setCase_name(updatedCase.getCase_name());
                    existingCase.setInvestigator(updatedCase.getInvestigator());
                    existingCase.setViolation(updatedCase.getViolation());
                    existingCase.setDescription(updatedCase.getDescription());
                    existingCase.setStatus(updatedCase.getStatus());
                    return caseService.saveCase(existingCase);
                })
                .orElseGet(() -> {
                    updatedCase.setCid(id);
                    return caseService.saveCase(updatedCase);
                });
    }

    // Delete a case by ID
    @DeleteMapping("/{id}")
    public void deleteCase(@PathVariable int id) {
        caseService.deleteCase(id);
    }
    
    @GetMapping("/student/{sid}")
    public List<CaseEntity> getAllCaseBySid(@PathVariable String sid){
    	return caseService.getAllCaseBySid(sid);
    }
    
    @PutMapping("/complete/{id}")
    public ResponseEntity<CaseEntity> completeCase(@PathVariable int id) {
        return caseService.completeCase(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/handledBySSO")
    public List<CaseEntity> getAllCaseHandledBySSO(){
    	return caseService.getAllCaseHandledBySSO();
    }
    
    @GetMapping("/handledByAdviser")
    public List<CaseEntity> getAllCaseHandledByAdviser(){
    	return caseService.getAllCaseHandledByAdviser();
    }
    
    @PutMapping("/{id}/sso")
    public CaseEntity updateCaseHandledBySSO(@PathVariable int id) {
        return caseService.getCaseById(id)
                .map(existingCase -> {
                    existingCase.setHandledBySSO(1);
                    return caseService.saveCase(existingCase);
                })
                .orElse(null); // Or handle the case where the ID does not exist
    }
}
