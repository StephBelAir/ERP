package com.erp.erp_back.controller;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.MachineRepository;
import com.erp.erp_back.repository.ProcessRepository;
import com.erp.erp_back.service.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Ce contrôleur est une classe, dont l’objectif est de réagir à une interaction avec l’utilisateur vers un Process.
 * <p>
 * Il doit permettre à l'utilisateur de poster les requêtes HTTP des opérations de base du CRUD au serveur.
 */
@Api("API pour les opérations CRUD sur les Process")
@RestController
@CrossOrigin
public class ProcessController {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private MachineRepository machineRepository;


    /*--====================  Get   ====================--*/

    /**
     * @return processList
     * @throws Exception
     */
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

    /**
     * @param id
     * @return processRepository.findById(id)
     */
    @ApiOperation(value = "Récupère UN process grâce à son ID")
    @GetMapping({"/processes/{id}"})
    @ResponseBody
    public Process getProcessById(@PathVariable int id) {
        return this.processRepository.findById(id);
    }


    /*--====================  Post   ====================--*/

    /**
     * @param processService
     * @return processes
     * @throws Exception
     */
    @ApiOperation(value = "Ajoute UN process")
    @PostMapping(value = "/processes/add")
    @ResponseBody
    public List<Process> createProcess(@RequestBody Process processService) throws Exception {
        try {
            processRepository.save(processService);
            List<Process> processes = processRepository.findAll();
            return processes;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*Todo : ajouter try catch
     *  Ajouter HttpStatus dans le return ?*/

    /**
     * @param processId
     * @param machineId
     * @return processRepository.save(process)
     */
    @ApiOperation(value = "Ajoute UNE machine dans UN process")
    @PutMapping("/{processId}/machines/{machineId}")
    @ResponseBody
    public Process addMachineToProcess(@PathVariable int processId, @PathVariable int machineId) {
        Process process = processRepository.findById(processId);
        Machine machine = machineRepository.findById(machineId);
        process.addMachine(machine);
        return processRepository.save(process);
    }

    /*Todo : ajouter try catch*/

    /**
     * @param machineList
     * @param processId
     */
    @ApiOperation(value = "Ajoute DES machines dans UN process, efface les machines existantes")
    @PutMapping("/{processId}/addMachineList")
    @ResponseBody
    public void addMachineListToProcess(@RequestBody List<Machine> machineList, @PathVariable int processId) {
        Process process = processRepository.findById(processId);
        if (process == null)
            return;
        process.setMachine(machineList);
        processRepository.save(process);
    }

    /*--====================  Delete   ====================--*/

    /**
     * @param processId
     * @return processes
     * @throws Exception
     */
    @ApiOperation(value = "Supprime UN process")
    @DeleteMapping(value = "/processes/delete/{processId}")
    public List<Process> deleteOneProcess(@PathVariable int processId) throws Exception {
        try {
            processRepository.deleteById(processId);
            List<Process> processes = processRepository.findAll();
            return processes;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*--====================  Update   ====================--*/

    /**
     * @param processService
     * @return processes
     * @throws Exception
     */


    @ApiOperation(value = "Modifie UN Process")
    @PutMapping(value = "/processes")
    @ResponseBody
    public List<Process> updateProcesses(@RequestBody ProcessService processService) throws Exception {
        try {
            Process process = ProcessService.editProcess(processService);
            processRepository.save(process);
            List<Process> processes = processRepository.findAll();
            return processes;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


}