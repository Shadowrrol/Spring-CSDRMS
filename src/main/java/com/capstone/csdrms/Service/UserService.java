package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.UserEntity;
import com.capstone.csdrms.Repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository urepo;
	
	
	public UserEntity insertUser(UserEntity user) {
	    UserEntity existingUser = urepo.findByUsername(user.getUsername());
	    if (existingUser != null) {
	        throw new IllegalArgumentException("User with username " + user.getUsername() + " already exists");
	    }
	    return urepo.save(user);
	}

	
	public List<UserEntity> getUsers(){
		return urepo.findAll();
	}
	
	
	public UserEntity updateUser(int uid, UserEntity newUserDetails) {
	    try {
	        UserEntity user = urepo.findById(uid).orElseThrow(() -> new NoSuchElementException("User " + uid + " does not exist!"));

	        // Update the user details
	        user.setPassword(newUserDetails.getPassword());
	        user.setFirstname(newUserDetails.getFirstname());
	        user.setLastname(newUserDetails.getLastname());
	        user.setEmail(newUserDetails.getEmail());
	        user.setSection(newUserDetails.getSection());

	        // Save the updated user
	        return urepo.save(user);
	    } catch (NoSuchElementException ex) {
	        throw ex;
	    }
	}
	
	
	public String deleteUser(int uid) {
	    if (urepo.existsById(uid)) {
	        urepo.deleteById(uid);
	        return "User " + uid + " is successfully deleted!";
	    } else {
	        return "User " + uid + " does not exist";
	    }
	}
	
	public UserEntity login(String username, String password) {
        // Retrieve user by username
        UserEntity user = urepo.findByUsername(username);
        
        // Check if user exists and if password matches
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login successful
        } else {
            return null; // Login failed
        }
    }

}
