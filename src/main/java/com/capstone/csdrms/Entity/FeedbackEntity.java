package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblfeedback")
public class FeedbackEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedbackID")
	int fid;
	
	int aid;
	int sanction_id;
	int isAcknowledged;
	
	public FeedbackEntity() {
		super();
	}

	public FeedbackEntity(int fid, int aid, int sanction_id, int isAcknowledged) {
		super();
		this.fid = fid;
		this.aid = aid;
		this.sanction_id = sanction_id;
		this.isAcknowledged = isAcknowledged;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getSanction_id() {
		return sanction_id;
	}

	public void setSanction_id(int sanction_id) {
		this.sanction_id = sanction_id;
	}

	public int getIsAcknowledged() {
		return isAcknowledged;
	}

	public void setIsAcknowledged(int isAcknowledged) {
		this.isAcknowledged = isAcknowledged;
	}
	
	
}
