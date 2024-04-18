package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbladviser")
public class AdviserEntity {
	
	@Id
	@Column(name = "adviserID")
	private String aid;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String section;
	
	@Column(name = "contact_number")
	private String con_num;

	public AdviserEntity() {
		super();
	}

	public AdviserEntity(String aid, String firstname, String lastname, String username, String password, String email, String section,
			String con_num) {
		super();
		this.aid = aid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.section = section;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCon_num() {
		return con_num;
	}

	public void setCon_num(String con_num) {
		this.con_num = con_num;
	}
}
