package com.capstone.csdrms.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.UserEntity;
import com.capstone.csdrms.Repository.TimeLogRepository;
import com.capstone.csdrms.Repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class UserService {


	@Autowired
	UserRepository userRepository;	
	
	@Autowired
	TimeLogService timeLogService;
	
	@Autowired
	ActivityLogService activityLogService;
	
	
	
	
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	 public void register(UserEntity user) {

		 Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());

	        if (existingUser.isPresent()) {
	            throw new IllegalArgumentException("Username already exist");
	        }

	        if (user.getUserType()== 2) {
	        	Optional<UserEntity> principalUser = userRepository.findByUserTypeAndDeleted(2,false);
				
	        	 if (principalUser.isPresent()) {
		            	throw new IllegalArgumentException("Principal already exists");
		            }
	        }
	        else if(user.getUserType()== 3) {
	        	Optional<UserEntity> adviserUser = userRepository.findByGradeAndSectionAndSchoolYearAndDeleted(user.getGrade(), user.getSection(), user.getSchoolYear(), false);
		          

	            if (adviserUser.isPresent()) {
	            	throw new IllegalArgumentException("Adviser with the same grade, section, and school year already exists");
	            }
	        }
	        else {
	        	user.setGrade(null);
	        	user.setSection(null);
	        	user.setSchoolYear(null);
	        }

	        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	        String encryptedPassword = bcrypt.encode(user.getPassword());
	        user.setPassword(encryptedPassword);

	        
	            userRepository.save(user);
	            
	    }
	
	public List<UserEntity> getAllUsers() {
        return userRepository.findAllActiveUsers();
    }
	
	
	public UserEntity updateUser(Long userId, UserEntity updatedUser, Long initiator) {
		Optional<UserEntity> optionalUser = userRepository.findById(userId);
		
		 if (optionalUser.isPresent()) {
	            UserEntity existingUser = optionalUser.get();
	            
	            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
	    	        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	    	        String encryptedPassword = bcrypt.encode(updatedUser.getPassword());
	    	        existingUser.setPassword(encryptedPassword);
	    	    }
	            
	            // Update fields based on the input user object
	            existingUser.setUsername(updatedUser.getUsername());
	            existingUser.setFirstname(updatedUser.getFirstname());
	            existingUser.setLastname(updatedUser.getLastname());;
	            existingUser.setEmail(updatedUser.getEmail());           
	            if(existingUser.getUserType() == 3) {
	            	existingUser.setGrade(updatedUser.getGrade());
		            existingUser.setSection(updatedUser.getSection());
		            existingUser.setSchoolYear(updatedUser.getSchoolYear());
	            }
	            
	            Optional<UserEntity> optionalUser1 = userRepository.findById(initiator);
	            UserEntity user = optionalUser1.get();
	            activityLogService.logActivity("Update User", "User " + updatedUser.getUsername() + " updated by User "+ user.getUsername(), initiator);

	            // Save the updated user back to the database
	            return userRepository.save(existingUser);
	        } else {
	            // Handle case where user is not found
	            throw new RuntimeException("User not found with id: " + userId);
	        }

	}
	
//	 public void deleteUser(String username) {
//	        // Find the user by their username
//	        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
//
//	        if (optionalUser.isPresent()) {
//	            // If the user is found, delete the user
//	            UserEntity user = optionalUser.get();
//	            timeLogService.deleteAllTimeLogsByUser(user.getUserId());
//	            reportService.deleteAllReportsByComplainant(username);
//	            userRepository.delete(user);
//	            activityLogService.logActivity("Delete User", "User " + user.getUsername() + " deleted by Admin", Long.valueOf(4));
//	        } else {
//	            // Handle case where user is not found
//	            throw new RuntimeException("User not found with username: " + username);
//	        }
//	    }
	
	@Transactional
    public boolean softDeleteUserByUsername(String username, Long initiator) {
        int rowsUpdated = userRepository.softDeleteByUsername(username);
        
        
        activityLogService.logActivity("Delete User", "User " + username + " deleted by Admin" , initiator);
        
        return rowsUpdated > 0; // Returns true if a user was marked as deleted
    }
	
	
	 
	 public UserEntity getPrincipal() {
		 Optional<UserEntity> optionalPrincipal = userRepository.findByUserTypeAndDeleted(2,false);
				 if (optionalPrincipal.isPresent()) {
					 UserEntity principal = optionalPrincipal.get();
					 return principal;
				 }
				 else {
			            // Handle case where user is not found
			            throw new RuntimeException("User Principal not found");
			        }
	 }
	 
	 public Optional<UserEntity> getAdviser(int grade, String section, String schoolYear) {
		 return userRepository.findByGradeAndSectionAndSchoolYearAndDeleted(grade, section, schoolYear, false);
	 }
	
	
	
}
