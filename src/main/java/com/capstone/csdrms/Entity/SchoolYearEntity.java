package com.capstone.csdrms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tblschoolyear")
public class SchoolYearEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schoolYear_ID;
	
	private String schoolYear;

	public SchoolYearEntity() {
		super();
	}

	public SchoolYearEntity(Long schoolYear_ID, String schoolYear) {
		super();
		this.schoolYear_ID = schoolYear_ID;
		this.schoolYear = schoolYear;
	}

	public Long getSchoolYear_ID() {
		return schoolYear_ID;
	}

	public void setSchoolYear_ID(Long schoolYear_ID) {
		this.schoolYear_ID = schoolYear_ID;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	
}
