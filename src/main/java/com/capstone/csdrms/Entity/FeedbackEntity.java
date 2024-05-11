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
@Table(name="tblfeedback")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackID")
    private int fid;

    @Column(name = "user_id")
    private Long uid;

    @Column(name = "caseID")
    private int cid;

    @Column(name = "isAcknowledged")
    private int isAcknowledged;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AdviserEntity adviser;

    @ManyToOne
    @JoinColumn(name = "caseID", insertable = false, updatable = false)
    private CaseEntity caseEntity;
    
    private String result;

    public FeedbackEntity() {
        super();
    }

	public FeedbackEntity(int fid, Long uid, int cid, int isAcknowledged, AdviserEntity adviser, CaseEntity caseEntity,
			String result) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.cid = cid;
		this.isAcknowledged = isAcknowledged;
		this.adviser = adviser;
		this.caseEntity = caseEntity;
		this.result = result;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getIsAcknowledged() {
		return isAcknowledged;
	}

	public void setIsAcknowledged(int isAcknowledged) {
		this.isAcknowledged = isAcknowledged;
	}

	public AdviserEntity getAdviser() {
		return adviser;
	}

	public void setAdviser(AdviserEntity adviser) {
		this.adviser = adviser;
	}

	public CaseEntity getCaseEntity() {
		return caseEntity;
	}

	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
}
