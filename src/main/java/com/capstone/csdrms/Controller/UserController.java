package com.capstone.csdrms.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.AdminEntity;
import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.GuidanceEntity;
import com.capstone.csdrms.Entity.PrincipalEntity;
import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Entity.TeacherEntity;
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
    
    @PostMapping("/registerAdmin")
    public String registerAdmin(@RequestBody AdminEntity admin) {
    	userService.register(admin);
        return "Admin created successfully";
    }
    
    @PostMapping("/registerTeacher")
    public String registerTeacher(@RequestBody TeacherEntity teacher) {
    	userService.register(teacher);
        return "Teacher created successfully";
    }
    
    @PostMapping("/registerGuidance")
    public String registerGuidance(@RequestBody GuidanceEntity guidance) {
    	userService.register(guidance);
        return "Guidance created successfully";
    }
     
    @GetMapping("/getAllAdvisers")
    public List<AdviserEntity> getAllAdvisers() {
        return userService.getAllAdvisers();
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
    
    @PutMapping("/updateAdmin")
    public String updateAdmin(@RequestBody AdminEntity updatedUser) {
        userService.update(updatedUser);
        return "Admin updated successfully";
    }
    
    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody TeacherEntity updatedUser) {
        userService.update(updatedUser);
        return "Teacher updated successfully";
    }
    
    @PutMapping("/updateGuidance")
    public String updateGuidance(@RequestBody GuidanceEntity updatedUser) {
        userService.update(updatedUser);
        return "Guidance updated successfully";
    }     
    
    @DeleteMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "User with username " + username + " successfully deleted!";
    }
    
    @GetMapping("/adviser")
    public ResponseEntity<AdviserEntity> getAdviser(@RequestParam int grade,@RequestParam String section,@RequestParam String schoolYear) {
    	 Optional<AdviserEntity> adviser = userService.getAdviser(grade, section, schoolYear);
         
         if (adviser.isPresent()) {
             return ResponseEntity.ok(adviser.get());
         } else {
             return ResponseEntity.notFound().build();
         }
    }
}
