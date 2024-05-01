package com.capstone.csdrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.FeedbackEntity;
import com.capstone.csdrms.Service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService fserv;
	
	@PostMapping("/insertFeedback")
    public FeedbackEntity insertFeedback(@RequestBody FeedbackEntity feedback) {
        return fserv.insertFeedback(feedback);
    }
	
}
