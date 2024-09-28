package com.capstone.csdrms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tbladviser")
public class AdviserEntity extends User{

	private String schoolYear;
	private String grade;
	private String section;
	

	public AdviserEntity() { 
		super();
	}


	public AdviserEntity(String schoolYear, String grade, String section) {
		super();
		this.schoolYear = schoolYear;
		this.grade = grade;
		this.section = section;
	}


	public String getSchoolYear() {
		return schoolYear;
	}


	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}

	
	
	
}
