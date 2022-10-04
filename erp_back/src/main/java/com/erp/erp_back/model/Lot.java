package com.erp.erp_back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * L'instance de la classe Lot qui sera persistante, on pourra sauvegarder dans / charger depuis la base de données relationnelle ERP.
 * <br>
 * Un Lot est déstiné à contenir UN process
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonSerialize
@Entity
@Transactional
public class Lot implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;
  protected int quantity;
  protected int length;
  protected int width;
  protected String productName;
  protected String type;
  protected int specialType;
  @Nullable
  protected LocalDateTime startDate;
  @Nullable
  protected LocalDateTime endDate;
  @Nullable
  protected LocalDateTime actualEndDate;

  /**
   * ManyToOne UN process n'est pas supprimé quand on supprime UN lot
   */
  @ManyToOne(targetEntity = Process.class, fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  protected Process process;


  public Lot() {
  }

  /**
   * @param quantity
   * @param length
   * @param width
   * @param productName
   * @param type
   * @param specialType
   * @param startDate
   * @param endDate
   * @param actualEndDate
   * @param process
   */
  public Lot(int quantity, int length, int width, String productName, String type, int specialType,
             LocalDateTime startDate, LocalDateTime endDate, LocalDateTime actualEndDate,
             Process process) {
    this.quantity = quantity;
    this.length = length;
    this.width = width;
    this.productName = productName;
    this.type = type;
    this.specialType = specialType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.actualEndDate = actualEndDate;
    this.process = process;
  }

  /**
   * @param quantity
   * @param length
   * @param width
   * @param productName
   * @param type
   * @param specialType
   * @param startDate
   * @param endDate
   * @param actualEndDate
   */
  public Lot(int quantity, int length, int width, String productName, String type, int specialType,
             @Nullable LocalDateTime startDate, @Nullable LocalDateTime endDate,
             @Nullable LocalDateTime actualEndDate) {
    this.quantity = quantity;
    this.length = length;
    this.width = width;
    this.productName = productName;
    this.type = type;
    this.specialType = specialType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.actualEndDate = actualEndDate;
  }


  public Lot(int id, @Nullable String productName) {
    this.id = id;
    this.productName = productName;
  }

  public Lot(int id, @Nullable String productName, int width) {
    this.productName = productName;
    this.width = width;
  }

  public Lot(int id, int quantity, int length, int width, @Nullable String productName, String type,
             int specialType, @Nullable LocalDateTime startDate, @Nullable LocalDateTime endDate,
             @Nullable LocalDateTime actualEndDate) {
    this.id = id;
    this.quantity = quantity;
    this.length = length;
    this.width = width;
    this.productName = productName;
    this.type = type;
    this.specialType = specialType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.actualEndDate = actualEndDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getSpecialType() {
    return specialType;
  }

  public void setSpecialType(int specialType) {
    this.specialType = specialType;
  }

  @Nullable
  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(@Nullable LocalDateTime startDate) {
    this.startDate = startDate;
  }

  @Nullable
  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(@Nullable LocalDateTime endDate) {
    this.endDate = endDate;
  }

  @Nullable
  public LocalDateTime getActualEndDate() {
    return actualEndDate;
  }

  public void setActualEndDate(@Nullable LocalDateTime actualEndDate) {
    this.actualEndDate = actualEndDate;
  }

  /**
   * @return process
   */
  public Process getProcess() {
    return process;
  }

  /**
   * @param process
   */
  public void setProcess(Process process) {
    this.process = process;
  }
}
