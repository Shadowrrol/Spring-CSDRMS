package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.FollowupEntity;
import com.capstone.csdrms.Service.FollowupService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/followup")
public class FollowupController {
    
    @Autowired
    private FollowupService followupService;

    @PostMapping("/insertFollowUp")
    public ResponseEntity<?> submitFollowup(@RequestBody FollowupEntity followup) {
        FollowupEntity savedFollowup = followupService.saveFollowup(followup);
        return new ResponseEntity<>(savedFollowup, HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllFollowUps")
    public List<FollowupEntity> getAllFollowUps() {
    	return followupService.getAllFollowUps();
    }
    
    @GetMapping("/getAllFollowUpsByAdviser/{adviserId}")
    public List<FollowupEntity> getAllFollowUpsByAdviser(@PathVariable Long adviserId) {
    	return followupService.getAllFollowUpsByAdviser(adviserId);
    }
}

 