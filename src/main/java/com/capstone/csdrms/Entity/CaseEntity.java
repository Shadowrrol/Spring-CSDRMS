package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblcase")
public class CaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caseID")
	private int cid;
	
	@Column(name = "studentID")
	private String sid;
	 
	private String case_name;
	private String investigator;
	private String violation;
	private String description;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "studentID", referencedColumnName = "studentID", insertable = false, updatable = false)
	private StudentEntity student;
	
	public CaseEntity() {
		super();
	}

	public CaseEntity(int cid, String sid, String case_name, String investigator, String violation, String description,
			String status, StudentEntity student) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.case_name = case_name;
		this.investigator = investigator;
		this.violation = violation;
		this.description = description;
		this.status = status;
		this.student = student;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getInvestigator() {
		return investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	public String getViolation() {
		return violation;
	}

	public void setViolation(String violation) {
		this.violation = violation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	
}
