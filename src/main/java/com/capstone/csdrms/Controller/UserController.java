package com.capstone.csdrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.capstone.csdrms.Entity.UserEntity;
import com.capstone.csdrms.Methods.LoginRequest;
import com.capstone.csdrms.Service.UserService;


//control test

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userv;
	
	
	
	
	//C - Create a user record
	@PostMapping("/insertUser")
	public UserEntity insertUser(@RequestBody UserEntity user) {
		return userv.insertUser(user);
	}
	
	//R - Read all user records in tblUser
	@GetMapping("/getAllUsers")
	public List<UserEntity> getUsers(){
		return userv.getUsers();
	}
	
	//U - Update a user record
	@PutMapping("/updateUser")
	public UserEntity updateUser(@RequestParam int uid,@RequestBody UserEntity newUserDetails){
		return userv.updateUser(uid, newUserDetails);
	}
	
	//D - Delete a user record
	@DeleteMapping("/deleteUser/{uid}")
	public String deleteUser(@PathVariable int uid) {
		return userv.deleteUser(uid);
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
	        String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();

	        // Call the login method in UserService
	        UserEntity user = userv.login(username, password);

	        if (user != null) {
	            // Return user details if login is successful
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } else {
	            // Return error message if login fails
	            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
	        }
	    }
	
}
