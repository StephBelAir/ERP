package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * L'instance de la classe Process qui sera persistante, on pourra sauvegarder dans / charger depuis la base de données relationnelle ERP.
 * <p>
 * Un Process est déstiné à contenir un ensemble de machine
 */
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
    @Nullable
    protected LocalDateTime startDate;
    @Nullable
    protected LocalDateTime endDate;
    @Nullable
    protected LocalDateTime actualEndDate;

    /**
     * ManyToOne UNE machine n'est pas supprimé quand on supprime UN process
     */
    @ManyToMany(targetEntity = Machine.class, fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    protected List<Machine> machine = new ArrayList<>();

    public Process() {
    }

    /**
     * @param processName
     * @param startDate
     * @param endDate
     * @param actualEndDate
     * @param machine
     */
    public Process(String processName, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime actualEndDate, List<Machine> machine) {
        this.processName = processName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualEndDate = actualEndDate;
        this.machine = machine;
    }

    /**
     * @param processName
     * @param startDate
     * @param endDate
     * @param actualEndDate
     */
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

    /**
     * @param machine
     */
    public void addMachine(Machine machine) {
        this.machine.add(machine);
    }

    /**
     * @return machine
     */
    public List<Machine> getMachine() {
        return machine;
    }

    /**
     * @param machine
     */
    public void setMachine(List<Machine> machine) {
        this.machine = machine;
    }
}
