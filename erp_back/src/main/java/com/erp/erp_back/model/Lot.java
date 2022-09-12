package com.erp.erp_back.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lot {

    @Id
    private int id;
    private int quantity;

    public Lot() {
    }

    public Lot(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
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
}
