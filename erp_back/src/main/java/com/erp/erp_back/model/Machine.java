package com.erp.erp_back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "machine")
public class Machine {

    @Id

    protected int machineId;
    protected LocalDateTime productionTime;

    // Format à confirmer
    protected int processOrder;

    public Machine() {
    }

    /**
     *
     * @param productionTime
     * @param processOrder
     */
    public Machine(LocalDateTime productionTime, int processOrder) {
        this.productionTime = productionTime;
        this.processOrder = processOrder;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public LocalDateTime getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDateTime productionTime) {
        this.productionTime = productionTime;
    }

    public int getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(int processOrder) {
        this.processOrder = processOrder;
    }
}
