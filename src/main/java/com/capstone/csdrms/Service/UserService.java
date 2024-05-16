package com.capstone.csdrms.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Entity.User;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.PrincipalRepository;
import com.capstone.csdrms.Repository.SSORepository;
import com.capstone.csdrms.Repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class UserService {


	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SSORepository ssoRepository;
	
	@Autowired
	PrincipalRepository principalRepository;
	
	@Autowired
	AdviserRepository adviserRepository;
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	public void register(User user) {
		
		SSOEntity existingUser1 = ssoRepository.findByUsername(user.getUsername());
		PrincipalEntity existingUser2 = principalRepository.findByUsername(user.getUsername());
		AdviserEntity existingUser3 = adviserRepository.findByUsername(user.getUsername());
		
		 if (existingUser1 != null || existingUser2 != null || existingUser3 != null ) {
		        throw new IllegalArgumentException("User with username " + user.getUsername() + " already exists");
		    }
		 else {
			 BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			 String encryptedPassword = bcrypt.encode(user.getPassword());
			 user.setPassword(encryptedPassword);
				 
			 if (user instanceof SSOEntity) {
					ssoRepository.save((SSOEntity) user);
		        } else if (user instanceof PrincipalEntity) {
		        	principalRepository.save((PrincipalEntity) user);
		        } else if(user instanceof AdviserEntity) {
		        	adviserRepository.save((AdviserEntity) user);
		        } else {
		        	userRepository.save(user);
		        }
		 } 
	}
	
	public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        
        // Retrieve SSOEntity users
        TypedQuery<SSOEntity> ssoQuery = entityManager.createQuery("SELECT s FROM SSOEntity s", SSOEntity.class);
        allUsers.addAll(ssoQuery.getResultList());
        
        // Retrieve PrincipalEntity users
        TypedQuery<PrincipalEntity> principalQuery = entityManager.createQuery("SELECT p FROM PrincipalEntity p", PrincipalEntity.class);
        allUsers.addAll(principalQuery.getResultList());
        
        // Retrieve AdviserEntity users
        TypedQuery<AdviserEntity> adviserQuery = entityManager.createQuery("SELECT a FROM AdviserEntity a", AdviserEntity.class);
        allUsers.addAll(adviserQuery.getResultList());
        
        return allUsers;
    }
	
	public void update(User user) {
	    User existingUser = null;
	    
	    if (user instanceof SSOEntity) {
	        existingUser = ssoRepository.findByUsername(user.getUsername());
	    } else if (user instanceof PrincipalEntity) {
	        existingUser = principalRepository.findByUsername(user.getUsername());
	    } else if (user instanceof AdviserEntity) {
	        existingUser = adviserRepository.findByUsername(user.getUsername());
	    }
	    
	    if (existingUser == null) {
	        throw new IllegalArgumentException("User with username " + user.getUsername() + " doesn't exist");
	    }
	    
	    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(user.getPassword());
	    existingUser.setPassword(encryptedPassword);
	    
	    existingUser.setFirstname(user.getFirstname());
	    existingUser.setLastname(user.getLastname());
	    existingUser.setEmail(user.getEmail());
	    
	    // Save the updated user based on its type
	    if (existingUser instanceof SSOEntity) {
	        ssoRepository.save((SSOEntity) existingUser);
	    } else if (existingUser instanceof PrincipalEntity) {
	        principalRepository.save((PrincipalEntity) existingUser);
	    } else if (existingUser instanceof AdviserEntity) {
	        AdviserEntity existingAdviser = (AdviserEntity) existingUser;
	        existingAdviser.setSection(((AdviserEntity) user).getSection());
	        existingAdviser.setGrade(((AdviserEntity) user).getGrade());
	        existingAdviser.setSchoolYear(((AdviserEntity) user).getSchoolYear());
	        adviserRepository.save(existingAdviser);
	    }
	}
	
}
