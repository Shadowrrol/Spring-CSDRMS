package com.capstone.csdrms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.capstone.csdrms.Entity.ReportEntity;
import com.capstone.csdrms.Repository.ReportRepository;

@Service 
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	public ReportEntity insertReport(ReportEntity report) {
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
