package com.erp.erp_back.controller;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.repository.MachineRepository;
import com.erp.erp_back.service.MachineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("API pour les opérations CRUD sur les Machines")
@RestController
@CrossOrigin
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;


    /*--====================  Get   ====================--*/

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


    /*--====================  Post   ====================--*/
    @ApiOperation(value = "Ajoute UNE machine")
    @PostMapping(value = "/machines/add")
    @ResponseBody
    public List<Machine> creatUser(@RequestBody Machine machineService) throws Exception{
        try{
            machineRepository.save(machineService);
            List<Machine> machines = machineRepository.findAll();
            return  machines;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /*--====================  Delete   ====================--*/

    @ApiOperation(value = "Supprime UNE machine")
    @DeleteMapping (value = "/machines/delete/{id}")
    public List<Machine> deleteOneMachine(@PathVariable int id) throws Exception {
        try {
            machineRepository.deleteById(id);
            List<Machine> machines = machineRepository.findAll();
            return machines;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /*--====================  Update   ====================--*/

    @ApiOperation(value = "Modifie UNE machine")
    @PutMapping (value = "/machines")
    @ResponseBody
    public List<Machine> updateMachine(@RequestBody MachineService machineService)throws Exception{
        try {
            Machine machine = MachineService.editMachine(machineService);
            machineRepository.save(machine);
            List<Machine> machines = machineRepository.findAll();
            return machines;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
