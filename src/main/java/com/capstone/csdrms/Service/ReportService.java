package com.capstone.csdrms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.capstone.csdrms.Entity.AdviserEntity;
import com.capstone.csdrms.Entity.ReportEntity;
import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Repository.AdviserRepository;
import com.capstone.csdrms.Repository.ReportRepository;
import com.capstone.csdrms.Repository.StudentRepository;

@Service 
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	@Autowired
    StudentRepository studentRepository;

    @Autowired
    AdviserRepository adviserRepository;
	
    public ReportEntity insertReport(ReportEntity report) throws Exception {
        Optional<StudentEntity> studentOptional = studentRepository.findById(report.getStudentId());
        if (studentOptional.isEmpty()) {
            throw new Exception("Student not found");
        }

        StudentEntity student = studentOptional.get();

        Optional<AdviserEntity> adviserOptional = adviserRepository.findBySectionAndSchoolYear(student.getSection(), student.getSchoolYear());
        if (adviserOptional.isEmpty()) {
            throw new Exception("Adviser not found for the student's section and school year");
        }

        AdviserEntity adviser = adviserOptional.get();
        report.setAdviserId(adviser.getUid());

        return reportRepository.save(report);
    }
	
	public List<ReportEntity> getAllReports(){
		return reportRepository.findAll();
	}
	
	public ReportEntity completeReport(Long reportId) throws Exception {
        Optional<ReportEntity> reportOpt = reportRepository.findById(reportId);
        if (reportOpt.isPresent()) {
            ReportEntity report = reportOpt.get();
            report.setComplete(true);  // Mark the report as complete
            return reportRepository.save(report);  // Save the updated entity
        } else {
            throw new Exception("Report not found with ID: " + reportId);
        }
    }
	
	public Optional<ReportEntity> updateReceived(Long reportId, String receivedDate) {
        Optional<ReportEntity> reportOptional = reportRepository.findById(reportId);
        if (reportOptional.isPresent()) {
            ReportEntity report = reportOptional.get();
            report.setReceived(receivedDate);
            reportRepository.save(report);
            return Optional.of(report);
        }
        return Optional.empty();
    }
	

}
