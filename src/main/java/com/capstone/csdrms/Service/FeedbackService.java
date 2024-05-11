package com.capstone.csdrms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.csdrms.Entity.FeedbackEntity;
import com.capstone.csdrms.Repository.FeedbackRepository;


@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository frepo;
	
	public FeedbackEntity insertFeedback(FeedbackEntity feedback) {
		return frepo.save(feedback);
	}
	
	 public List<FeedbackEntity> getAllFeedbackByAidWithDetails(Long uid) {
	        return frepo.findAllByAidWithAdviserAndCase(uid);
	    }
	 
	 public List<FeedbackEntity> getAllFeedbackBacks(){
		 return frepo.findAll();
	 }
	 
	 public List<FeedbackEntity> getAllFeedbackBacksByUidAndIsAcknowledged(Long uid){
		 return frepo.findAllByUidAndIsAcknowledged(uid, 0);
	 }
	 
	 public FeedbackEntity acknowledgeFeedback(int feedbackId) {
	        FeedbackEntity feedback = frepo.findById(feedbackId).orElse(null);
	        if (feedback != null) {
	            feedback.setIsAcknowledged(1);
	            return frepo.save(feedback);
	        }
	        return null; // Handle error case appropriately
	    }

}
