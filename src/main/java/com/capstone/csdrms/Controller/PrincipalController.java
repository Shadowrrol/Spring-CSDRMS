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


import com.capstone.csdrms.Service.PrincipalService;
import com.capstone.csdrms.Entity.PrincipalEntity;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/principal")
public class PrincipalController {

	@Autowired
	PrincipalService pserv;
	
	//C - Create an adviser record
	@PostMapping("/insertPrincipal")
	public PrincipalEntity insertPrincipal(@RequestBody PrincipalEntity adviser) {
		return pserv.insertPrincipal(adviser);
	}
	
	//R - Read all advieser records in tblPrincipal. Wala man dagway ni
	@GetMapping("/getAllPrincipals")
	public List<PrincipalEntity> getPrincipals(){
		return pserv.getAllPrincipal();
	}
	
	//U - Update an adviser record
	@PutMapping("/updatePrincipal")
	public PrincipalEntity updatePrincipal(@RequestParam int aid,@RequestBody PrincipalEntity newPrincipalDetails){
		return pserv.updatePrincipal(aid, newPrincipalDetails);
	}
	
	//D - Delete an adviser record
	@DeleteMapping("/deletePrincipal/{sid}")	
	public String deletePrincipal(@PathVariable int aid) {
		return pserv.deletePrincipal(aid);
	}

	// Get adviser by id
	 @GetMapping("/getPrincipal/{sid}")
	public PrincipalEntity getPrincipalById(@PathVariable int aid) {
		return pserv.getPrincipalById(aid);
	}
	
}
