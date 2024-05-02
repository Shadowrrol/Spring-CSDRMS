package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.PrincipalRepository;
import com.capstone.csdrms.Repository.SSORepository;


//Mao ni ang UserService sauna
@Service
public class SSOService {
	
	@Autowired
	SSORepository urepo;
	
	@Autowired
	AdviserRepository arepo;
	
	@Autowired
	PrincipalRepository prepo;
	
	
	
	
	public SSOEntity insertUser(SSOEntity user) {
	    SSOEntity existingUser = urepo.findByUsername(user.getUsername());
	    AdviserEntity existingUser1 = arepo.findByUsername(user.getUsername());
	    PrincipalEntity existingUser2 = prepo.findByUsername(user.getUsername());
	    if (existingUser != null || existingUser1 != null || existingUser2 != null ) {
	        throw new IllegalArgumentException("User with username " + user.getUsername() + " already exists");
	    }
	    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);
	    return urepo.save(user);
	}

	
	public List<SSOEntity> getUsers(){
		return urepo.findAll();
	}
	
	
	public SSOEntity updateUser(int sid, SSOEntity newUserDetails) {
	    try {
	        SSOEntity user = urepo.findById(sid).orElseThrow(() -> new NoSuchElementException("User " + sid + " does not exist!"));

	        // Update the user details
	        user.setPassword(newUserDetails.getPassword());
	        user.setFirstname(newUserDetails.getFirstname());
	        user.setLastname(newUserDetails.getLastname());
	        user.setEmail(newUserDetails.getEmail());

	        // Save the updated user
	        return urepo.save(user);
	    } catch (NoSuchElementException ex) {
	        throw ex;
	    }
	}
	
	
	public String deleteUser(int sid) {
	    if (urepo.existsById(sid)) {
	        urepo.deleteById(sid);
	        return "User " + sid + " is successfully deleted!";
	    } else {
	        return "User " + sid + " does not exist";
	    }
	}
	

}
