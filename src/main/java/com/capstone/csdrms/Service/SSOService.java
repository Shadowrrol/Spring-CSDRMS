package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Repository.SSORepository;


//Mao ni ang UserService sauna
@Service
public class SSOService {
	
	@Autowired
	SSORepository urepo;
	
	
	public SSOEntity insertUser(SSOEntity user) {
	    SSOEntity existingUser = urepo.findByUsername(user.getUsername());
	    if (existingUser != null) {
	        throw new IllegalArgumentException("User with username " + user.getUsername() + " already exists");
	    }
	    return urepo.save(user);
	}

	
	public List<SSOEntity> getUsers(){
		return urepo.findAll();
	}
	
	
	public SSOEntity updateUser(int uid, SSOEntity newUserDetails) {
	    try {
	        SSOEntity user = urepo.findById(uid).orElseThrow(() -> new NoSuchElementException("User " + uid + " does not exist!"));

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
	
	public SSOEntity login(String username, String password) {
        // Retrieve user by username
        SSOEntity user = urepo.findByUsername(username);
        
        // Check if user exists and if password matches
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login successful
        } else {
            return null; // Login failed
        }
    }

}
