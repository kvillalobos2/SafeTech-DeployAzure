package com.api.safetech.report.service;

import com.api.safetech.report.domain.model.entity.Report;
import com.api.safetech.report.domain.persistence.ReportRepository;
import com.api.safetech.report.domain.service.ReportService;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.shared.exception.ResourceValidationException;
import com.api.safetech.user.domain.persistence.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final static String ENTITY = "Report";
    private final static String ENTITY2 = "User";

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Report> getAll(){
        return reportRepository.findAll();
    }

    @Override
    public Report getById(Long reportId){
        return reportRepository.findById(reportId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, reportId));
    }

    @Override
    public List<Report> getByUserId(Long userId){
        var user = userRepository.findById(userId);
        if(user == null)
            throw new ResourceNotFoundException(ENTITY2, userId);

        return reportRepository.findByUserId(userId);
    }

    @Override
    public Report create(Report request, Long userId){
        var user = userRepository.findById(userId);
        if(user == null)
            throw new ResourceNotFoundException(ENTITY2, userId);

        try{
            request.setUser(user.get());
            return reportRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving report");
        }
    }

    @Override
    public Report update(Long reportId, Report request){
        try{
            return reportRepository.findById(reportId)
                    .map(report ->
                            reportRepository.save(
                                    report.withApplianceType(request.getApplianceType())
                                            .withApplianceModel(request.getApplianceModel())
                                            .withApplianceBrand(request.getApplianceBrand())
                                            .withApplianceDiagnostic(request.getApplianceDiagnostic())
                                            .withReparationDetails(request.getReparationDetails())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, reportId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating Report");
        }
    }

    @Override
    public Report delete(Long reportId){
        return reportRepository.findById(reportId)
                .map(report -> {
                    reportRepository.delete(report);
                    return report;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, reportId));
    }


}
