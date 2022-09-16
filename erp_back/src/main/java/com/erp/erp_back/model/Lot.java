package com.erp.erp_back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lot")
public class Lot {

    @Id
    protected int id;
    protected int quantity;
    protected int length;
    protected int width;
    protected String productName;
    protected String type;
    protected int specialType;
    protected int processId;


    public Lot() {
    }

    public Lot(int id, int quantity, int length, int width, String productName, String type, int specialType, int processId) {
        this.id = id;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.productName = productName;
        this.type = type;
        this.specialType = specialType;
        this.processId = processId;
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

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
