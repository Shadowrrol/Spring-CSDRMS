package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdminEntity;
import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.GuidanceEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Entity.TeacherEntity;
import com.capstone.csdrms.Repository.AdminRepository;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.GuidanceRepository;
import com.capstone.csdrms.Repository.PrincipalRepository;
import com.capstone.csdrms.Repository.SSORepository;
import com.capstone.csdrms.Repository.TeacherRepository;

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
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	GuidanceRepository guidanceRepository;

	public Object login(String username, String password) {
		SSOEntity sso = srepo.findByUsername(username);
		AdviserEntity adviser = arepo.findByUsername(username);
		PrincipalEntity principal = prepo.findByUsername(username);
		AdminEntity admin = adminRepository.findByUsername(username);
		TeacherEntity teacher = teacherRepository.findByUsername(username);
		GuidanceEntity guidance = guidanceRepository.findByUsername(username);
		
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
		else if(teacher != null && bcrypt.matches(password, teacher.getPassword())){
			return teacher;
		}
		else if(guidance != null && bcrypt.matches(password, guidance.getPassword())){
			return guidance;
		}
		else {
            return null; // Login failed
        }
	}
}
