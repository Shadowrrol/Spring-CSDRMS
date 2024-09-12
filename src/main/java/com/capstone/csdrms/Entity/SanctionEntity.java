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
	
	private Long id;
	private String behaviorDetails;
	private String sanctionRecommendation;
	private int isApproved;
	 
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private StudentEntity student;
	
	 

	public SanctionEntity() {
		super();
	}



	public SanctionEntity(int sanction_id, Long id, String behaviorDetails, String sanctionRecommendation,
			int isApproved, StudentEntity student) {
		super();
		this.sanction_id = sanction_id;
		this.id = id;
		this.behaviorDetails = behaviorDetails;
		this.sanctionRecommendation = sanctionRecommendation;
		this.isApproved = isApproved;
		this.student = student;
	}



	public int getSanction_id() {
		return sanction_id;
	}



	public void setSanction_id(int sanction_id) {
		this.sanction_id = sanction_id;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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
