package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import java.time.LocalDateTime;

// = DTO

/**
 * Restriction des données visibles pour le rôle du technicien "Planning"
 * <br>
 * Objets qui transportent des données entre les couches, où toutes les données d'un Lot
 * <br>
 * qui seront utilisées sont rassemblées avant d'aller dans un controlleur.
 */
public class PlanningUserService {
  protected int id;
  protected String productName;
  protected int width;
  protected LocalDateTime startDate;
  protected LocalDateTime endDate;
  protected LocalDateTime actualEndDate;

  protected LocalDateTime estimateEndDate;


  public PlanningUserService() {
  }

  /**
   * Permets de récupérer uniquement les champs utiles du lot
   *
   * @param orignal
   * @return
   */
  public static PlanningUserService fromLot(Lot orignal) {
    PlanningUserService result = new PlanningUserService();
    result.setId(orignal.getId());
    result.setProductName(orignal.getProductName());
    result.setWidth(orignal.getWidth());
    result.setStartDate(orignal.getStartDate());
    result.setEndDate(orignal.getEndDate());
    result.setActualEndDate(orignal.getActualEndDate());
    result.setEstimateEndDate(orignal.getEstimateEndDate());

    return result;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
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

  public LocalDateTime getEstimateEndDate() {
    return estimateEndDate;
  }

  public void setEstimateEndDate(LocalDateTime estimateEndDate) {
    this.estimateEndDate = estimateEndDate;
  }
}
