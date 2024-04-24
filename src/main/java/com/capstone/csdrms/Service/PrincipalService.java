package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.PrincipalRepository;
import com.capstone.csdrms.Repository.SSORepository;



@Service
public class PrincipalService {

	@Autowired
	PrincipalRepository prepo;
	
	@Autowired
	AdviserRepository arepo;
	
	@Autowired
	SSORepository srepo;

	//add new principal
	public PrincipalEntity insertPrincipal(PrincipalEntity principal) {
		SSOEntity existingUser = srepo.findByUsername(principal.getUsername());
	    AdviserEntity existingUser1 = arepo.findByUsername(principal.getUsername());
	    PrincipalEntity existingUser2 = prepo.findByUsername(principal.getUsername());
	    if (existingUser != null || existingUser1 != null || existingUser2 != null ) {
	        throw new IllegalArgumentException("User with username " + principal.getUsername() + " already exists");
	    }
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(principal.getPassword());
		principal.setPassword(encryptedPassword);
		return prepo.save(principal);
	}
	
	//get a principal by ID
	public PrincipalEntity getPrincipalById(int pid){
		PrincipalEntity principal = new PrincipalEntity();
		principal = prepo.findById(pid).get();
		return principal;
	}

	//get all principal? murag wala rani gi kinihanglan?
	public List<PrincipalEntity> getAllPrincipal(){
		return prepo.findAll();
	}

	//update a principal
	@SuppressWarnings("finally")
	public PrincipalEntity updatePrincipal(int principalid, PrincipalEntity newPrincipalDetails) {
		PrincipalEntity principal = new PrincipalEntity();
		try {
			
			principal = prepo.findById(principalid).get();	    	
			principal.setFirstname(newPrincipalDetails.getFirstname());
	    	principal.setLastname(newPrincipalDetails.getLastname());
	    	principal.setEmail(newPrincipalDetails.getEmail());
	    	principal.setCon_num(newPrincipalDetails.getCon_num());
	    	
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Principal " + principalid + "does not exist!");
			
		}finally{
			return prepo.save(principal);
		}
	}
	
	//delete a principal
	public String deletePrincipal(int principalid) {
		PrincipalEntity existingPrincipal = prepo.findById(principalid).get();
		if(existingPrincipal!=null) {
			prepo.delete(existingPrincipal);
			return "Principal " + principalid + " is successfully deleted!";
		}else
			return "Principal " + principalid + " does not exist!";
	}
	
	public PrincipalEntity login(String username, String password) {
        // Retrieve user by username
        PrincipalEntity user = prepo.findByUsername(username);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
        // Check if user exists and if password matches
        if (user != null && bcrypt.matches(user.getPassword(), password)) {
            return user; // Login successful
        } else {
            return null; // Login failed
        }
    }
}
