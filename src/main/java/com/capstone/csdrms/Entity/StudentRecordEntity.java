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
@Table(name="tblstudentRecord")
public class StudentRecordEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	 
	@Column(name = "studentID")     
	private String sid;
	
	private Long id;
	private String record_date;
	private String incident_date;
	private String time;
	private String monitored_record;
	private String remarks;
	
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private StudentEntity student;
	
	public StudentRecordEntity() {
		super();
	}

	public StudentRecordEntity(int recordId, String sid, Long id, String record_date, String incident_date, String time,
			String monitored_record, String remarks, StudentEntity student) {
		super();
		this.recordId = recordId;
		this.sid = sid;
		this.id = id;
		this.record_date = record_date;
		this.incident_date = incident_date;
		this.time = time;
		this.monitored_record = monitored_record;
		this.remarks = remarks;
		this.student = student;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}

	public String getIncident_date() {
		return incident_date;
	} 

	public void setIncident_date(String incident_date) {
		this.incident_date = incident_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMonitored_record() {
		return monitored_record;
	}

	public void setMonitored_record(String monitored_record) {
		this.monitored_record = monitored_record;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	
	
}
