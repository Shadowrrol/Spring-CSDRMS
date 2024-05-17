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
@Table(name="tblstudentReport")
public class StudentReportEntity {
 
	@Id
	@Column(name = "reportID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	 
	@Column(name = "studentID")     
	private String sid;
	
	private String date;
	private String time;
	private String monitored_record;
	private String remarks;
	private String sanction; 
	
	@ManyToOne
	@JoinColumn(name = "studentID", referencedColumnName = "studentID", insertable = false, updatable = false)
	private StudentEntity student;
	  
	public StudentReportEntity() {
		super();
	}

	public StudentReportEntity(int rid, String sid, String date, String time, String monitored_record, String remarks,
			String sanction, StudentEntity student) {
		super();
		this.rid = rid;
		this.sid = sid;
		this.date = date;
		this.time = time;
		this.monitored_record = monitored_record;
		this.remarks = remarks;
		this.sanction = sanction;
		this.student = student;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;	
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	
	
}
