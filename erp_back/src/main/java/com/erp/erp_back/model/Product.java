package com.erp.erp_back.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    protected int productId;
    protected int width;
    protected String type;

    protected int specialType;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime actualEndDate;

    public Product() {
    }

    public Product(int width, String type, int specialType, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime actualEndDate) {
        this.width = width;
        this.type = type;
        this.specialType = specialType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualEndDate = actualEndDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getWidth() {
        return width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
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
}
