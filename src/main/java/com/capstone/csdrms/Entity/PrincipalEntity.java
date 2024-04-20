package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblprincipal")
public class PrincipalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String school_ID;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;

	@Column(name = "contact_number")
	private String con_num;

	public PrincipalEntity() {
		super();
	}

	public PrincipalEntity(int pid, String school_ID, String firstname, String lastname, String username, String password, String email, String con_num) {
		super();
		this.pid = pid;
		this.school_ID = school_ID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.con_num =	con_num;
	}

	public int getAid() {
		return pid;
	}

	public void setAid(int pid) {
		this.pid = pid;
	}
	public String getSchoolId() {
		return school_ID;
	}

	public void setSchoolId(String school_ID) {
		this.school_ID = school_ID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getuserename() {
		return username;
	}

	public void setUsername(String username) {
		this.username= username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}


	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCon_num() {
		return con_num;
	}

	public void setCon_num(String con_num) {
		this.con_num = con_num;
	}
}
