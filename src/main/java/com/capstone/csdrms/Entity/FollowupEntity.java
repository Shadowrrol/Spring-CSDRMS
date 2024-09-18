package com.capstone.csdrms.Entity;

import java.time.LocalDate;
import java.time.LocalTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblfollowups")
public class FollowupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "caseID")
	private int cid;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String action;

    @Column
    private String reasoning;
    
    @ManyToOne
    @JoinColumn(name = "caseID", insertable = false, updatable = false)
    private CaseEntity caseEntity;
    

	public FollowupEntity() {
		super();
	}

	public FollowupEntity(Long id, int cid, LocalDate date, LocalTime time, String action, String reasoning,
			CaseEntity caseEntity) {
		super();
		this.id = id;
		this.cid = cid;
		this.date = date;
		this.time = time;
		this.action = action;
		this.reasoning = reasoning;
		this.caseEntity = caseEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getReasoning() {
		return reasoning;
	}

	public void setReasoning(String reasoning) {
		this.reasoning = reasoning;
	}

	public CaseEntity getCaseEntity() {
		return caseEntity;
	}

	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
	}
	 

	
    
}
