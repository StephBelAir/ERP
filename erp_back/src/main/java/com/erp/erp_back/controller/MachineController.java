package com.erp.erp_back.controller;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.repository.MachineRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("API pour les opérations CRUD sur les Machines")
@RestController
@CrossOrigin
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;

    @ApiOperation(value = "Récupère TOUTES les machines existants")
    @GetMapping(value = "/machines")
    public Iterable<Machine> getAllMachines() throws Exception {
        try {
            Iterable<Machine> machinesList = machineRepository.findAll();
            return machinesList;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    @ApiOperation(value = "Récupère UNE machine grâce à son ID")
    @GetMapping({"/machines/{id}"})
    @ResponseBody
    public Machine getProcessById(@PathVariable int id) {
        return this.machineRepository.findById(id);
    }
}
