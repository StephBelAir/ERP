package com.erp.erp_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotController {

    @GetMapping("/lot")
    public String listeLot() {
        return "&#128526";
    }

    @GetMapping("/lot/{id}")
    public String listeLotById(@PathVariable int id){
        return "&#128527      " + id;
    }

}

