package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Transactional
@JsonSerialize
@Table(name = "machine")
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int machineId;
    protected LocalDateTime productionTime;

    // Format à confirmer
    protected int processOrder;

    public Machine() {
    }

    /**
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
