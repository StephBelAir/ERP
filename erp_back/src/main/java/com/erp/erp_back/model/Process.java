package com.erp.erp_back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "process")
public class Process {

    @Id
    protected int processId;

    public Process() {
    }

    public Process(int processId) {
        this.processId = processId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
