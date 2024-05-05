package com.capstone.csdrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.csdrms.Methods.LoginRequest;
import com.capstone.csdrms.Service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class LoginController {
	
	
	@Autowired
	LoginService sserv;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
	    String username = loginRequest.getUsername();
	    String password = loginRequest.getPassword();

	    // Call the login method in LoginService
	    Object loggedInUser = sserv.login(username, password);

	    if (loggedInUser != null) {
	        // Return user details if login is successful
	        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
	    } else {
	        // Return error message if login fails
	        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
	    }
	}

}
