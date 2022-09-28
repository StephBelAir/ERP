package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import org.springframework.stereotype.Service;

import java.util.List;

// = DTO

/**
 * Restriction des données visibles pour le rôle du technicien "Planning"
 * <br>
 * Objets qui transportent des données entre les couches, où toutes les données d'un Lot
 * <br>
 * qui seront utilisées sont rassemblées avant d'aller dans un controlleur.
 */
@Service
public class PlanningService {
    protected int id;
    protected String productName;
    protected int width;


    public PlanningService() {
    }

    public PlanningService(int id, String productName, int width) {
        this.id = id;
        this.productName = productName;
        this.width = width;
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

}
