package com.capstone.csdrms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblreport")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private Long studentId; 

    private Long adviserId; 

    private String date;
    private String time;
    private String complaint;
    private String complainant;
    private String received;
    private String encoder;
    private boolean complete;
    private boolean viewedByAdviser;
	private boolean viewedBySso;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id", insertable = false, updatable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "adviserId", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AdviserEntity adviser;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "complainant", referencedColumnName = "username", insertable = false, updatable = false)
    private SSOEntity ssoComplainant;

    @ManyToOne(optional = true)
    @JoinColumn(name = "complainant", referencedColumnName = "username", insertable = false, updatable = false)
    private AdviserEntity adviserComplainant;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "complainant", referencedColumnName = "username", insertable = false, updatable = false)
    private TeacherEntity teacherComplainant;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "complainant", referencedColumnName = "username", insertable = false, updatable = false)
    private GuidanceEntity guidanceComplainant;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "complainant", referencedColumnName = "username", insertable = false, updatable = false)
    private PrincipalEntity principalComplainant;
    
    
    public ReportEntity() {
    }


	public ReportEntity(Long reportId, Long studentId, Long adviserId, String date, String time, String complaint,
			String complainant, String received, String encoder, boolean complete, boolean viewedByAdviser,
			boolean viewedBySso, StudentEntity student, AdviserEntity adviser, SSOEntity ssoComplainant,
			AdviserEntity adviserComplainant, TeacherEntity teacherComplainant, GuidanceEntity guidanceComplainant,
			PrincipalEntity principalComplainant) {
		super();
		this.reportId = reportId;
		this.studentId = studentId;
		this.adviserId = adviserId;
		this.date = date;
		this.time = time;
		this.complaint = complaint;
		this.complainant = complainant;
		this.received = received;
		this.encoder = encoder;
		this.complete = complete;
		this.viewedByAdviser = viewedByAdviser;
		this.viewedBySso = viewedBySso;
		this.student = student;
		this.adviser = adviser;
		this.ssoComplainant = ssoComplainant;
		this.adviserComplainant = adviserComplainant;
		this.teacherComplainant = teacherComplainant;
		this.guidanceComplainant = guidanceComplainant;
		this.principalComplainant = principalComplainant;
	}


	public Long getReportId() {
		return reportId;
	}


	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public Long getAdviserId() {
		return adviserId;
	}


	public void setAdviserId(Long adviserId) {
		this.adviserId = adviserId;
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


	public String getReceived() {
		return received;
	}


	public void setReceived(String received) {
		this.received = received;
	}


	public String getEncoder() {
		return encoder;
	}


	public void setEncoder(String encoder) {
		this.encoder = encoder;
	}


	public boolean isComplete() {
		return complete;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	public boolean isViewedByAdviser() {
		return viewedByAdviser;
	}


	public void setViewedByAdviser(boolean viewedByAdviser) {
		this.viewedByAdviser = viewedByAdviser;
	}


	public boolean isViewedBySso() {
		return viewedBySso;
	}


	public void setViewedBySso(boolean viewedBySso) {
		this.viewedBySso = viewedBySso;
	}


	public StudentEntity getStudent() {
		return student;
	}


	public void setStudent(StudentEntity student) {
		this.student = student;
	}


	public AdviserEntity getAdviser() {
		return adviser;
	}


	public void setAdviser(AdviserEntity adviser) {
		this.adviser = adviser;
	}


	public SSOEntity getSsoComplainant() {
		return ssoComplainant;
	}


	public void setSsoComplainant(SSOEntity ssoComplainant) {
		this.ssoComplainant = ssoComplainant;
	}


	public AdviserEntity getAdviserComplainant() {
		return adviserComplainant;
	}


	public void setAdviserComplainant(AdviserEntity adviserComplainant) {
		this.adviserComplainant = adviserComplainant;
	}


	public TeacherEntity getTeacherComplainant() {
		return teacherComplainant;
	}


	public void setTeacherComplainant(TeacherEntity teacherComplainant) {
		this.teacherComplainant = teacherComplainant;
	}


	public GuidanceEntity getGuidanceComplainant() {
		return guidanceComplainant;
	}


	public void setGuidanceComplainant(GuidanceEntity guidanceComplainant) {
		this.guidanceComplainant = guidanceComplainant;
	}


	public PrincipalEntity getPrincipalComplainant() {
		return principalComplainant;
	}


	public void setPrincipalComplainant(PrincipalEntity principalComplainant) {
		this.principalComplainant = principalComplainant;
	}
    
    
    
    





	
}
