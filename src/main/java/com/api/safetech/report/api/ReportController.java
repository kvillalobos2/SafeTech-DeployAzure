package com.api.safetech.report.api;

import com.api.safetech.report.domain.service.ReportService;
import com.api.safetech.report.mapping.ReportMapper;
import com.api.safetech.report.resource.CreateReportResource;
import com.api.safetech.report.resource.ReportResource;
import com.api.safetech.report.resource.UpdateReportResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Report")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportMapper reportMapper;

    @Operation(summary = "Get All Reports", description = "Get All Reports")
    @GetMapping("reports")
    public List<ReportResource> getAll(){
        return reportMapper.toResource(reportService.getAll());
    }

    @Operation(summary = "Get Report by Id", description = "Get Report by Id")
    @GetMapping("reports/{reportId}")
    public ReportResource getReportById(@PathVariable Long reportId){
        return reportMapper.toResource(reportService.getById(reportId));
    }

    @Operation(summary = "Get Reports by UserId", description = "Get All Reports by UserId")
    @GetMapping("users/{userId}/reports")
    public List<ReportResource> getReportByUserId(@PathVariable Long userId){
        return reportMapper.toResource(reportService.getByUserId(userId));
    }

    @Operation(summary = "Create New Report", description = "Create New Report")
    @PostMapping("users/{userId}/reports")
    public ReportResource createReport(@RequestBody CreateReportResource model, @PathVariable Long userId){
        return reportMapper.toResource(reportService.create(reportMapper.toModel(model), userId));
    }

    @Operation(summary = "Update Report", description = "Update Report")
    @PutMapping("reports/{reportId}")
    public ReportResource updateReport(@PathVariable Long reportId, @RequestBody UpdateReportResource model){
        return reportMapper.toResource(reportService.update(reportId, reportMapper.toModel(model)));
    }

    @Operation(summary = "Delete Report", description = "Delete Report")
    @DeleteMapping("{reportId}")
    public void deleteReport(@PathVariable Long reportId){
        reportService.delete(reportId);
    }

}
