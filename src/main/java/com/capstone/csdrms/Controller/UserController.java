package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Entity.User;
import com.capstone.csdrms.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;
	
	@PostMapping("/registerSSO")
    public String registerSSO(@RequestBody SSOEntity sso) {
		userService.register(sso);
        return "sso created successfully";
    }

    @PostMapping("/registerPrincipal")
    public String registerPrincipal(@RequestBody PrincipalEntity principal) {
    	userService.register(principal);
        return "Principal created successfully";
    }
    
    @PostMapping("/registerAdviser")
    public String registerAdviser(@RequestBody AdviserEntity adviser) {
    	userService.register(adviser);
        return "Adviser created successfully";
    }
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PutMapping("/updateSSO")
    public String updateSSO(@RequestBody SSOEntity updatedUser) {
        userService.update(updatedUser);
        return "SSO updated successfully";
    }
    
    @PutMapping("/updatePrincipal")
    public String updatePrincipal(@RequestBody PrincipalEntity updatedUser) {
        userService.update(updatedUser);
        return "Principal updated successfully";
    }
    
    @PutMapping("/updateAdviser")
    public String updateAdviser(@RequestBody AdviserEntity updatedUser) {
        userService.update(updatedUser);
        return "Adviser updated successfully";
    }
}
