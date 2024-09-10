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
	private String name;
	private String section;
	private int grade;
	private String schoolYear;
	private String record_date;
	private String incident_date;
	private String time;
	private String monitored_record;
	private String remarks;
	private String sanction;
	
	public StudentReportEntity() {
		super();
	}

	public StudentReportEntity(int rid, String sid, String name, String section, int grade, String schoolYear,
			String record_date, String incident_date, String time, String monitored_record, String remarks,
			String sanction) {
		super();
		this.rid = rid;
		this.sid = sid;
		this.name = name;
		this.section = section;
		this.grade = grade;
		this.schoolYear = schoolYear;
		this.record_date = record_date;
		this.incident_date = incident_date;
		this.time = time;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
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

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	
	
}
