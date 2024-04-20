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

import com.capstone.csdrms.Methods.LoginRequest;
import com.capstone.csdrms.Service.AdviserService;
import com.capstone.csdrms.Service.SSOService;
import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.SSOEntity;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/adviser")
public class AdviserController {

	@Autowired
	AdviserService aserv;
	
	//C - Create an adviser record
	@PostMapping("/insertAdviser")
	public AdviserEntity insertAdviser(@RequestBody AdviserEntity adviser) {
		return aserv.insertAdviser(adviser);
	}
	
	//R - Read all advieser records in tblAdviser
	@GetMapping("/getAllAdvisers")
	public List<AdviserEntity> getAdvisers(){
		return aserv.getAllAdviser();
	}
	
	//U - Update an adviser record
	@PutMapping("/updateAdviser")
	public AdviserEntity updateAdviser(@RequestParam int aid,@RequestBody AdviserEntity newAdviserDetails){
		return aserv.updateAdviser(aid, newAdviserDetails);
	}
	
	//D - Delete an adviser record
	@DeleteMapping("/deleteAdviser/{sid}")	
	public String deleteAdviser(@PathVariable int aid) {
		return aserv.deleteAdviser(aid);
	}

	// Get adviser by id
	 @GetMapping("/getAdviser/{sid}")
	public AdviserEntity getAdviserById(@PathVariable int aid) {
		return aserv.getAdviserById(aid);
	}
	
}
