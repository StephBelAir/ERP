package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Transactional
@JsonSerialize
@Table(name = "process")
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int processId;
    protected String processName;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime actualEndDate;

    @OneToMany(targetEntity = Machine.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Machine> machine = new ArrayList<>();

    public Process() {
    }

    public Process(String processName, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime actualEndDate, List<Machine> machine) {
        this.processName = processName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualEndDate = actualEndDate;
        this.machine = machine;
    }

    public Process(String processName, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime actualEndDate) {
        this.processName = processName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualEndDate = actualEndDate;
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

    public void addMachine(Machine machine) {
        this.machine.add(machine);
    }

   public List<Machine> getMachine() {
        return machine;
    }

    public void setMachine(List<Machine> machine) {
        this.machine = machine;
    }
}
