package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// = DTO

@Service
public class LotService {
    protected int id;
    protected int quantity;
    protected int length;
    protected int productId;
    protected int processId;

    static LotRepository lotRepository;

    public LotService(){}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getProcessId() { return processId; }
    public void setProcessId(int processId) { this.productId = processId; }

}
