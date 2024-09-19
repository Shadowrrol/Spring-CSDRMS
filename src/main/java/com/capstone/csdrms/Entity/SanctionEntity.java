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
	
	@Column(name = "caseID")
    private int cid;

    @ManyToOne
    @JoinColumn(name = "caseID", insertable = false, updatable = false)
    private CaseEntity caseEntity;
	
	private String sanctionRecommendation;
	private int isApproved;
	 
    
	public SanctionEntity() {
		super();
	}

	
	public SanctionEntity(int sanction_id, int cid, CaseEntity caseEntity, String sanctionRecommendation,
			int isApproved) {
		super();
		this.sanction_id = sanction_id;
		this.cid = cid;
		this.caseEntity = caseEntity;
		this.sanctionRecommendation = sanctionRecommendation;
		this.isApproved = isApproved;
	}


	public int getSanction_id() {
		return sanction_id;
	}


	public void setSanction_id(int sanction_id) {
		this.sanction_id = sanction_id;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public CaseEntity getCaseEntity() {
		return caseEntity;
	}


	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
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
 
}
