package com.erp.erp_back.service;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// = DTO
@Service
public class MachineService {

    protected int machineId;
    protected LocalDateTime productionTime;
    protected int processOrder;
    protected String machineType;

    static MachineRepository machineRepository;

    public MachineService() {
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

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public static MachineRepository getMachineRepository() {
        return machineRepository;
    }

    public static void setMachineRepository(MachineRepository machineRepository) {
        MachineService.machineRepository = machineRepository;
    }

    public static Machine addMachine(MachineService machineService) {
        Machine machine = new Machine( machineService.getProductionTime(), machineService.getProcessOrder(), machineService.getMachineType());
        return machine;
    }
}
