package com.erp.erp_back.controller;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LotController {

    @Autowired
    private LotRepository lotRepository;


    @RequestMapping(value = "/lots", method = RequestMethod.GET)
    /* public Iterable<Lot> getAllLots(){
        Iterable<Lot> lotsList = lotRepository.findAll();
        return lotsList;
    } */

    public Iterable<Lot> getAllLots() throws Exception{
        try{
            Iterable<Lot> lotsList = lotRepository.findAll();
            return  lotsList;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
