package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

  // Format à confirmer
  protected int processOrder;
  protected String machineType;


  public Machine() {
  }

  /**
   * @param productionTime
   * @param processOrder
   * @param machineType
   */
  public Machine(int productionTime, int processOrder, String machineType) {
    this.productionTime = productionTime;
    this.processOrder = processOrder;
    this.machineType = machineType;
  }

  /**
   * @param machineId
   * @param productionTime
   * @param processOrder
   * @param machineType
   */

  public Machine(int machineId, int productionTime, int processOrder,
                 String machineType) {
    this.machineId = machineId;
    this.productionTime = productionTime;
    this.processOrder = processOrder;
    this.machineType = machineType;
  }

  public Machine( int processOrder,
                 String machineType) {
    this.processOrder = processOrder;
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
}
