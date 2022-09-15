package com.erp.erp_back.controller;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("API pour les opérations CRUD sur les Lots")
@RestController
@CrossOrigin
public class LotController {

    @Autowired
    private LotRepository lotRepository;

    @ApiOperation(value = "Récupère TOUT les lots existant")
    @RequestMapping(value = "/lots", method = RequestMethod.GET)
    public Iterable<Lot> getAllLots() throws Exception {
        try {
            Iterable<Lot> lotsList = lotRepository.findAll();
            return lotsList;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    @ApiOperation(value = "Récupère UN lot grâce à son ID")
    @GetMapping({"/lots/{id}"})
    @ResponseBody
    public Lot getLotById(@PathVariable int id) { return this.lotRepository.findById(id); }

}
