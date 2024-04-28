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

import com.capstone.csdrms.Entity.SSOEntity;
import com.capstone.csdrms.Methods.LoginRequest;
import com.capstone.csdrms.Service.SSOService;

//Mao ni ang UserController sauna
//wala ra nako gichange kining mapping nila kay mag ilis nasad mo sa postman
//basin mabungkag frontend pod

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sso")
public class SSOController {

	@Autowired
	SSOService userv;
	
	//C - Create a user record
	@PostMapping("/insertSSO")
	public SSOEntity insertUser(@RequestBody SSOEntity user) {
		return userv.insertUser(user);
	}
	
	//R - Read all user records in SSOUser
	@GetMapping("/getAllSSO")
	public List<SSOEntity> getUsers(){
		return userv.getUsers();
	}
	
	//U - Update a user record
	@PutMapping("/updateSSO") 
	public SSOEntity updateUser(@RequestParam int sid,@RequestBody SSOEntity newUserDetails){
		return userv.updateUser(sid, newUserDetails);
	}
	
	//D - Delete a user record
	@DeleteMapping("/deleteSSO/{uid}")
	public String deleteUser(@PathVariable int sid) {
		return userv.deleteUser(sid);
	}
	
	
}
