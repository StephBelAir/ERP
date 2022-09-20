package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import org.springframework.stereotype.Service;

// = DTO
@Service
public class LotService {
    protected int id;
    protected int quantity;
    protected int length;
    protected int width;
    protected String productName;
    protected String type;
    protected int specialType;

    static LotRepository lotRepository;

    public LotService() {
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


    public static LotRepository getLotRepository() {
        return lotRepository;
    }

    public static void setLotRepository(LotRepository lotRepository) {
        LotService.lotRepository = lotRepository;
    }

    public static Lot addLot( LotService lotService){
        Lot lot = new Lot(lotService.getQuantity(), lotService.getLength(), lotService.getWidth(), lotService.getProductName(), lotService.getType(), lotService.getSpecialType() );
        return lot;
    }




}
