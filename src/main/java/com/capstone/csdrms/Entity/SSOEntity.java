package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//Mao ni ang UserEntity sauna
//Wala ra nako tang tanga ang usertype kay basin mabungkag sa frontend haha
@Entity
@Table(name="tblSSO")
public class SSOEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sso_id")
	private int sid;
	 
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int userType;
	 
	public SSOEntity() {
		super();
	}

	public SSOEntity(int sid, String username, String password, String firstname, String lastname, String email, int userType) {
		super();
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userType = userType;
	}
 
	public int getUid() {
		return sid;
	}

	public void setUid(int sid) {
		this.sid = sid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
}
