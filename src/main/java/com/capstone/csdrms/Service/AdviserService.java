package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Repository.AdviserRepository;



@Service
public class AdviserService {

	@Autowired
	AdviserRepository arepo;

	//add new adviser
	public AdviserEntity insertAdviser(AdviserEntity adviser) {
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
	public AdviserEntity updateAdviser(String adviserid, AdviserEntity newAdviserDetails) {
		AdviserEntity adviser = new AdviserEntity();
		try {
			
			adviser = arepo.findByAid(adviserid);	    	
			adviser.setFirstname(newAdviserDetails.getFirstname());
	    	adviser.setLastname(newAdviserDetails.getLastname());
	    	adviser.setUsername(newAdviserDetails.getuserename());
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
	public String deleteAdviser(String adviserid) {
		AdviserEntity existingAdviser = arepo.findByAid(adviserid);
		if(existingAdviser!=null) {
			arepo.delete(existingAdviser);
			return "Adviser " + adviserid + " is successfully deleted!";
		}else
			return "Adviser " + adviserid + " does not exist!";
	}
}
