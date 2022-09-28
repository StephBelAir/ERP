package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// = DTO
/**
 * Objets qui transportent des données entre les couches, où toutes les données d'un Lot
 * <br>
 * qui seront utilisées sont rassemblées avant d'aller dans un controlleur.
 */
@Service
public class LotService {
    protected int id;
    protected int quantity;
    protected int length;
    protected int width;
    protected String productName;
    protected String type;
    protected int specialType;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime actualEndDate;

    static LotRepository lotRepository;

    public LotService() {
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

    /**
     * @return lotRepository
     */
    public static LotRepository getLotRepository() {
        return lotRepository;
    }

    /**
     * @param lotRepository
     */
    public static void setLotRepository(LotRepository lotRepository) {
        LotService.lotRepository = lotRepository;
    }

    /**
     * @param lotService
     * @return lot
     */
    public static Lot addLot(LotService lotService) {
        Lot lot = new Lot(lotService.getQuantity(), lotService.getLength(), lotService.getWidth(), lotService.getProductName(), lotService.getType(), lotService.getSpecialType(), lotService.getStartDate(), lotService.getEndDate(), lotService.getActualEndDate());
        return lot;
    }

    public static Lot editLot(LotService lotService) {
        Lot lot = new Lot(lotService.getId(), lotService.getQuantity(), lotService.getLength(), lotService.getWidth(), lotService.getProductName(), lotService.getType(), lotService.getSpecialType(), lotService.getStartDate(), lotService.getEndDate(), lotService.getActualEndDate());
        return lot;
    }


}
