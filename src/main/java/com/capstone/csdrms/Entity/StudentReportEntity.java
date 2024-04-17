package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblstudentReport")
public class StudentReportEntity {

	@Id
	@Column(name = "reportID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	 
	     
	private String sid;
	private String date;
	private String time;
	private String name;
	private String monitored_record;
	private String remarks;
	private String sanction;
	 
	public StudentReportEntity() {
		super();
	}

	public StudentReportEntity(int rid, String sid, String date, String time, String name, String monitored_record,
			String remarks, String sanction) {
		super();
		this.rid = rid;
		this.sid = sid;
		this.date = date;
		this.time = time;
		this.name = name;
		this.monitored_record = monitored_record;
		this.remarks = remarks;
		this.sanction = sanction;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	
	
}
