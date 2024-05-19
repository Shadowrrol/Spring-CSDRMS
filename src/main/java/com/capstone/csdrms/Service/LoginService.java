package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdminEntity;
import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Repository.AdminRepository;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.PrincipalRepository;
import com.capstone.csdrms.Repository.SSORepository;

@Service
public class LoginService {
	
	@Autowired
	SSORepository srepo;
	
	@Autowired
	AdviserRepository arepo;
	
	@Autowired
	PrincipalRepository prepo;
	
	@Autowired
	AdminRepository adminRepository;

	public Object login(String username, String password) {
		SSOEntity sso = srepo.findByUsername(username);
		AdviserEntity adviser = arepo.findByUsername(username);
		PrincipalEntity principal = prepo.findByUsername(username);
		AdminEntity admin = adminRepository.findByUsername(username);
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		if (sso != null && bcrypt.matches(password, sso.getPassword())) {
            return sso; // Login successful
        }
		
		else if(adviser != null && bcrypt.matches(password, adviser.getPassword())){
			return adviser;
		}
		else if(principal != null && bcrypt.matches(password, principal.getPassword())){
			return principal;
		}
		else if(admin != null && bcrypt.matches(password, admin.getPassword())){
			return admin;
		}
		else {
            return null; // Login failed
        }
	}
}
