package com.erp.erp_back.controller;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.MachineRepository;
import com.erp.erp_back.repository.ProcessRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("API pour les opérations CRUD sur les Process")
@RestController
@CrossOrigin
public class ProcessController {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private MachineRepository machineRepository;


    /*--====================  Get   ====================--*/

    @ApiOperation(value = "Récupère TOUT les process existants")
    @GetMapping(value = "/processes")
    public Iterable<Process> getAllProcess() throws Exception {
        try {
            Iterable<Process> processList = processRepository.findAll();
            return processList;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    @ApiOperation(value = "Récupère UN process grâce à son ID")
    @GetMapping({"/processes/{id}"})
    @ResponseBody
    public Process getProcessById(@PathVariable int id) {
        return this.processRepository.findById(id);
    }


    /*--====================  Post   ====================--*/
    @ApiOperation(value = "Ajoute UN process")
    @PostMapping(value = "/processes/add")
    @ResponseBody
    public List<Process> creatProcess(@RequestBody Process processService) throws Exception{
        try{
            processRepository.save(processService);
            List<Process> processes = processRepository.findAll();
            return  processes;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    @ApiOperation(value = "Ajoute UN process")
    @PostMapping(value = "/processes/add/{processId}/machine/{machineId}")
    @ResponseBody
    public Process addMachineToProcess(@PathVariable int processId, @PathVariable int machineId)
            throws Exception {

        try {
            Process process = processRepository.findById(processId);
            Machine machine = machineRepository.findById(machineId);
            if (process.getMachine() == null) {
                process.setMachine(machine);
                processRepository.save(process);
                return process;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
