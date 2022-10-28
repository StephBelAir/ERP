package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

/**
 * L'instance de la classe Machine qui sera persistante, on pourra sauvegarder dans / charger depuis la base de données relationnelle ERP.
 * <p>
 * - Une Machine est destinée à représenter une étape d'un process.
 * <br>
 * - Une machine est définie par son rang dans le process et son temp de cycle.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Transactional
@JsonSerialize
@Table(name = "machine")
public class Machine implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int machineId;
  protected int productionTime;

  protected String machineName;
  protected String machineType;


  public Machine() {
  }

  public Machine(int machineId) {
    this.machineId = machineId;
  }

  public Machine(int machineId, int productionTime) {
    this.machineId = machineId;
    this.productionTime = productionTime;
  }

  public Machine(String machineName){
    this.machineName = machineName;
  }

  /**
   * @param productionTime
   * @param machineName
   * @param machineType
   */
  public Machine(int productionTime, String machineName, String machineType) {
    this.productionTime = productionTime;
    this.machineName = machineName;
    this.machineType = machineType;
  }

  /**
   * @param machineId
   * @param productionTime
   * @param machineName
   * @param machineType
   */

  public Machine(int machineId, int productionTime, String machineName,
                 String machineType) {
    this.machineId = machineId;
    this.productionTime = productionTime;
    this.machineName = machineName;
    this.machineType = machineType;
  }

  public Machine(String machineName,
                 String machineType) {
    this.machineName = machineName;
    this.machineType = machineType;
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

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String processOrder) {
    this.machineName = processOrder;
  }

  public String getMachineType() {
    return machineType;
  }

  public void setMachineType(String machineType) {
    this.machineType = machineType;
  }
}
