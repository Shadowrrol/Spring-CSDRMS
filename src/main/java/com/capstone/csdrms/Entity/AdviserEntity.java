package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbladviser")
public class AdviserEntity extends User{

	private String section;

	public AdviserEntity() {
		super();
	}

	public AdviserEntity(String section) {
		super();
		this.section = section;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	
	
	
	
}
