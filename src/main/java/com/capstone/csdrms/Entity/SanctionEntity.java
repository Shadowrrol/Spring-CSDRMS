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
@Table(name="tblsanction")
public class SanctionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sanctionID")
	private int sanction_id;
	
	@Column(name = "studentID")
	private String sid;
	private String behaviorDetails;
	private String sanctionRecommendation;
	private int isApproved;
	 
	@ManyToOne
	@JoinColumn(name = "studentID", referencedColumnName = "studentID", insertable = false, updatable = false)
	private StudentEntity student;
	
	 

	public SanctionEntity() {
		super();
	} 
 
	public SanctionEntity(int sanction_id, String sid, String behaviorDetails, String sanctionRecommendation) {
		super();
		this.sanction_id = sanction_id;
		this.sid = sid;
		this.behaviorDetails = behaviorDetails;
		this.sanctionRecommendation = sanctionRecommendation;
		this.isApproved = 0;
	}

	public int getSanction_id() {
		return sanction_id;
	}

	public void setSanction_id(int sanction_id) {
		this.sanction_id = sanction_id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getBehaviorDetails() {
		return behaviorDetails;
	}

	public void setBehaviorDetails(String behaviorDetails) {
		this.behaviorDetails = behaviorDetails;
	}

	public String getSanctionRecommendation() {
		return sanctionRecommendation;
	}

	public void setSanctionRecommendation(String sanctionRecommendation) {
		this.sanctionRecommendation = sanctionRecommendation;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}
	
	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	
	
}
