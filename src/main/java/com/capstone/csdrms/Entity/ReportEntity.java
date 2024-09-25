package com.capstone.csdrms.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblreport")
public class ReportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;
	
	private Long id;
	
	private String date;
	private String time;
	private String complaint;
	private String complainant;
	private String adviser;
	private String received;
	private boolean complete;
	
	public ReportEntity() {
		super();
	}

	public ReportEntity(Long reportId, Long id, String date, String time, String complaint, String complainant,
			String adviser, String received, boolean complete) {
		super();
		this.reportId = reportId;
		this.id = id;
		this.date = date;
		this.time = time;
		this.complaint = complaint;
		this.complainant = complainant;
		this.adviser = adviser;
		this.received = received;
		this.complete = complete;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getComplainant() {
		return complainant;
	}

	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}

	public String getAdviser() {
		return adviser;
	}

	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	
	
}
