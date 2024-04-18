package com.capstone.csdrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.FollowupEntity;
import com.capstone.csdrms.Service.FollowupService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/followup")
public class FollowupController {
    
    @Autowired
    private FollowupService followupService;

    @PostMapping
    public ResponseEntity<?> submitFollowup(@RequestBody FollowupEntity followup) {
        FollowupEntity savedFollowup = followupService.saveFollowup(followup);
        return new ResponseEntity<>(savedFollowup, HttpStatus.CREATED);
    }
}

