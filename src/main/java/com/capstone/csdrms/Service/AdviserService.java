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
public class AdviserService {

	@Autowired
	AdviserRepository arepo;
	
	@Autowired
	PrincipalRepository prepo;
	
	@Autowired
	SSORepository srepo;

	//add new adviser
	public AdviserEntity insertAdviser(AdviserEntity adviser) {
		 SSOEntity existingUser = srepo.findByUsername(adviser.getUsername());
		    AdviserEntity existingUser1 = arepo.findByUsername(adviser.getUsername());
		    PrincipalEntity existingUser2 = prepo.findByUsername(adviser.getUsername());
		    if (existingUser != null || existingUser1 != null || existingUser2 != null ) {
		        throw new IllegalArgumentException("User with username " + adviser.getUsername() + " already exists");
		    }
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(adviser.getPassword());
		adviser.setPassword(encryptedPassword);
		return arepo.save(adviser);
	}
	
	//get an adviser by ID
	public AdviserEntity getAdviserById(int aid){
		AdviserEntity adviser = new AdviserEntity();
		adviser = arepo.findById(aid).get();
		return adviser;
	}

	//get all adviser? murag wala rani gi kinihanglan?
	public List<AdviserEntity> getAllAdviser(){
		return arepo.findAll();
	}

	//update an adviser
	@SuppressWarnings("finally")
	public AdviserEntity updateAdviser(int adviserid, AdviserEntity newAdviserDetails) {
		AdviserEntity adviser = new AdviserEntity();
		try {
			
			adviser = arepo.findById(adviserid).get();	    	
			adviser.setFirstname(newAdviserDetails.getFirstname());
	    	adviser.setLastname(newAdviserDetails.getLastname());
	    	adviser.setEmail(newAdviserDetails.getEmail());
	    	adviser.setSection(newAdviserDetails.getSection());
	    	adviser.setCon_num(newAdviserDetails.getCon_num());
	    	
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Adviser " + adviserid + "does not exist!");
			
		}finally{
			return arepo.save(adviser);
		}
	}
	
	//delete an adviser
	public String deleteAdviser(int adviserid) {
		AdviserEntity existingAdviser = arepo.findById(adviserid).get();
		if(existingAdviser!=null) {
			arepo.delete(existingAdviser);
			return "Adviser " + adviserid + " is successfully deleted!";
		}else
			return "Adviser " + adviserid + " does not exist!";
	}

}
