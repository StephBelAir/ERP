package com.erp.erp_back.service;

import com.erp.erp_back.repository.ProcessRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// = DTO
@Service
public class ProcessService {

    protected String processName;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime actualEndDate;

    static ProcessRepository processRepository;

    public ProcessService() {
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDateTime actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public static ProcessRepository getProcessRepository() {
        return processRepository;
    }

    public static void setProcessRepository(ProcessRepository processRepository) {
        ProcessService.processRepository = processRepository;
    }
}
