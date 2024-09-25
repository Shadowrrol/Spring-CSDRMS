package com.capstone.csdrms.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.csdrms.Entity.ReportEntity;
import com.capstone.csdrms.Service.ReportService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@PostMapping("/insertReport")
	public ReportEntity insertReport(@RequestBody ReportEntity report) {
		return reportService.insertReport(report);
	}
	
	@GetMapping("/getAllReports")
	public List<ReportEntity> getAllReports(){
		return reportService.getAllReports();
	}
	
	@PutMapping("/complete/{id}")
    public ResponseEntity<ReportEntity> completeReport(@PathVariable("id") Long reportId) {
        try {
            ReportEntity completedReport = reportService.completeReport(reportId);
            return ResponseEntity.ok(completedReport);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
	
	@PutMapping("/updateReceived/{reportId}")
    public ResponseEntity<ReportEntity> updateReceived(@PathVariable Long reportId, @RequestBody Map<String, String> data) {
        Optional<ReportEntity> updatedReport = reportService.updateReceived(reportId, data.get("received"));
        return updatedReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
}
