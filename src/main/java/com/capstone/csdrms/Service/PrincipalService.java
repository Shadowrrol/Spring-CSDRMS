package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Repository.PrincipalRepository;



@Service
public class PrincipalService {

	@Autowired
	PrincipalRepository arepo;

	//add new principal
	public PrincipalEntity insertPrincipal(PrincipalEntity principal) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(principal.getPassword());
		principal.setPassword(encryptedPassword);
		return arepo.save(principal);
	}
	
	//get a principal by ID
	public PrincipalEntity getPrincipalById(int pid){
		PrincipalEntity principal = new PrincipalEntity();
		principal = arepo.findById(pid).get();
		return principal;
	}

	//get all principal? murag wala rani gi kinihanglan?
	public List<PrincipalEntity> getAllPrincipal(){
		return arepo.findAll();
	}

	//update a principal
	@SuppressWarnings("finally")
	public PrincipalEntity updatePrincipal(int principalid, PrincipalEntity newPrincipalDetails) {
		PrincipalEntity principal = new PrincipalEntity();
		try {
			
			principal = arepo.findById(principalid).get();	    	
			principal.setFirstname(newPrincipalDetails.getFirstname());
	    	principal.setLastname(newPrincipalDetails.getLastname());
	    	principal.setUsername(newPrincipalDetails.getuserename());
	    	principal.setEmail(newPrincipalDetails.getEmail());
	    	principal.setCon_num(newPrincipalDetails.getCon_num());
	    	
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Principal " + principalid + "does not exist!");
			
		}finally{
			return arepo.save(principal);
		}
	}
	
	//delete a principal
	public String deletePrincipal(int principalid) {
		PrincipalEntity existingPrincipal = arepo.findById(principalid).get();
		if(existingPrincipal!=null) {
			arepo.delete(existingPrincipal);
			return "Principal " + principalid + " is successfully deleted!";
		}else
			return "Principal " + principalid + " does not exist!";
	}
	
	public PrincipalEntity login(String username, String password) {
        // Retrieve user by username
        PrincipalEntity user = arepo.findByUsername(username);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
        // Check if user exists and if password matches
        if (user != null && bcrypt.matches(user.getPassword(), password)) {
            return user; // Login successful
        } else {
            return null; // Login failed
        }
    }
}
