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
	
	private Long id;
	 
	private String case_name;
	private String investigator;
	private String violation;
	private String description;
	private String status;
	private int handledBySSO;
	 
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private StudentEntity student;
	
	public CaseEntity() {
		super();
	}

	public CaseEntity(int cid, Long id, String case_name, String investigator, String violation, String description,
			String status, int handledBySSO, StudentEntity student) {
		super();
		this.cid = cid;
		this.id = id;
		this.case_name = case_name;
		this.investigator = investigator;
		this.violation = violation;
		this.description = description;
		this.status = status;
		this.handledBySSO = handledBySSO;
		this.student = student;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getHandledBySSO() {
		return handledBySSO;
	}

	public void setHandledBySSO(int handledBySSO) {
		this.handledBySSO = handledBySSO;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	
}
