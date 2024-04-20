package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblstudent")
public class StudentEntity {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	
	private String school_ID;
	private String firstname;
	private String middlename;
	private String lastname;
	private int grade;
	private String section;
	
	@Column(name = "contact_number")
	private String con_num;

	public StudentEntity() {
		super();
	}

	public StudentEntity(int sid, String school_ID, String firstname, String middlename, String lastname, int grade, String section,
			String con_num) {
		super();
		this.sid = sid;
		this.school_ID = school_ID;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.grade = grade;
		this.section = section;
		this.con_num = con_num;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSchoolId() {
		return this.school_ID;
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

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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
