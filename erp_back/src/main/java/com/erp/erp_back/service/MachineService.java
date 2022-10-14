package com.erp.erp_back.service;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// = DTO

/**
 * Objets qui transportent des données entre les couches, où toutes les données d'une Machine
 * <br>
 * qui seront utilisées sont rassemblées avant d'aller dans un controlleur.
 */
@Service
public class MachineService {

  protected int machineId;
  protected int productionTime;
  protected String processOrder;
  protected String machineType;

  static MachineRepository machineRepository;

  public MachineService() {
  }

  public int getMachineId() {
    return machineId;
  }

  public void setMachineId(int machineId) {
    this.machineId = machineId;
  }

  public int getProductionTime() {
    return productionTime;
  }

  public void setProductionTime(int productionTime) {
    this.productionTime = productionTime;
  }

  public String getProcessOrder() {
    return processOrder;
  }

  public void setProcessOrder(String processOrder) {
    this.processOrder = processOrder;
  }

  public String getMachineType() {
    return machineType;
  }

  public void setMachineType(String machineType) {
    this.machineType = machineType;
  }

  /**
   * @return machineRepository
   */
  public static MachineRepository getMachineRepository() {
    return machineRepository;
  }

  /**
   * @param machineRepository
   */
  public static void setMachineRepository(MachineRepository machineRepository) {
    MachineService.machineRepository = machineRepository;
  }

  /**
   * @param machineService
   * @return machine
   */
  public static Machine addMachine(MachineService machineService) {
    Machine machine =
        new Machine(machineService.getProductionTime(), machineService.getProcessOrder(),
            machineService.getMachineType());
    return machine;
  }

  /**
   * @param machineService
   * @return machine
   */
  public static Machine editMachine(MachineService machineService) {
    Machine machine = new Machine(machineService.getMachineId(), machineService.getProductionTime(),
        machineService.getProcessOrder(), machineService.getMachineType());
    return machine;
  }
}
