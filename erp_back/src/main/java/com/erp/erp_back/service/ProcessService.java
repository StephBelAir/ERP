package com.erp.erp_back.service;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.ProcessRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// = DTO
@Service
public class ProcessService {

    protected int processId;
    protected String processName;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime actualEndDate;
    protected List<Machine> machines;

    static ProcessRepository processRepository;

    public ProcessService() {
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
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

    /**
     * @return machines
     */
    public List<Machine> getMachines() {
        return machines;
    }

    /**
     * @param machines
     */
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    /**
     * @return processRepository
     */
    public static ProcessRepository getProcessRepository() {
        return processRepository;
    }

    /**
     * @param processRepository
     */
    public static void setProcessRepository(ProcessRepository processRepository) {
        ProcessService.processRepository = processRepository;
    }

    /**
     * @param processService
     * @return process
     */
    public static Process addProcess(ProcessService processService) {
        Process process = new Process(processService.getProcessName(), processService.getStartDate(), processService.getEndDate(), processService.getActualEndDate());
        return process;
    }

}
