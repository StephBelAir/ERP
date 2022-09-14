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
    protected int productId;
    protected int processId;


    public Lot() {
    }

    public Lot(int id,int quantity, int length, int productId, int processId) {
        this.id = id;
        this.quantity = quantity;
        this.length = length;
        this.productId = productId;
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
    public void setLength(int lenght) {
        this.length = lenght;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
