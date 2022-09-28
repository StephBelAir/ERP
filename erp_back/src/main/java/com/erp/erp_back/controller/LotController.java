package com.erp.erp_back.controller;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.LotRepository;
import com.erp.erp_back.repository.ProcessRepository;
import com.erp.erp_back.service.LotService;
import com.erp.erp_back.service.MachineService;
import com.erp.erp_back.service.PlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Ce contrôleur est une classe, dont l’objectif est de réagir à une interaction avec l’utilisateur vers un Lot.
 * <p>
 * Il doit permettre à l'utilisateur de poster les requêtes HTTP des opérations de base du CRUD au serveur.
 */
@Api("API pour les opérations CRUD sur les Lots")
@RestController
@CrossOrigin
public class LotController {

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ProcessRepository processRepository;


    /*--====================  Get   ====================--*/

    /**
     * @return lotsList
     * @throws Exception
     */
    @ApiOperation(value = "Récupère TOUT les lots existants")
    @GetMapping(value = "/lots")
    public Iterable<Lot> getAllLots() throws Exception {
        try {
            Iterable<Lot> lotsList = lotRepository.findAll();
            return lotsList;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    /**
     * @param id
     * @return lotRepository.findById(id)
     */
    @ApiOperation(value = "Récupère UN lot grâce à son ID")
    @GetMapping({"/lots/{id}"})
    @ResponseBody
    public Lot getLotById(@PathVariable int id) {
        return this.lotRepository.findById(id);
    }

    /*--====================  Get pour le Planning  ====================--*/

    /**
     *  Get avec Restriction des données visibles pour le rôle du technicien "Planning"
     * @return lotsList
     * @throws Exception
     */
    /*
    @ApiOperation(value = "Récupère TOUT les lots existants Pour le role Planning")
    @GetMapping(value = "/lots/planning")
    public Iterable<PlanningService> getAllLotsForPlanning() throws Exception {
        try {
            Iterable<PlanningService> lotsListForPlanning = lotRepository.findAllPlaning();
            return lotsListForPlanning;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    } */

    /*--====================  Get avec une Query ====================--*/

    /**
     * Get avec query SQL
     * @return lotsListByProductName
     * @throws Exception
     */
    @ApiOperation(value = "Récupère TOUT les lots SEULEMENT avec le productName")
    @GetMapping({"/lots/query"})
    public ArrayList<Lot> getFindAllByQuery() throws Exception {
        try {
            ArrayList<Lot> lotsListByProductName = lotRepository.findAllByQuery();
             return lotsListByProductName;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /*--====================  Post   ====================--*/

    /**
     * @param lotService
     * @return lots
     * @throws Exception
     */
    @ApiOperation(value = "Ajoute UN lot")
    @PostMapping(value = "/lots/add")
    @ResponseBody
    public List<Lot> createLot(@RequestBody Lot lotService) throws Exception {
        try {
            lotRepository.save(lotService);
            List<Lot> lots = lotRepository.findAll();
            return lots;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /**
     * @param id
     * @param processId
     * @return lot
     * @throws Exception
     */
    @ApiOperation(value = "Ajoute UN process dans UN lot")
    @PostMapping(value = "/lots/add/{id}/process/{processId}")
    @ResponseBody
    public Lot addProcessToLot(@PathVariable int id, @PathVariable int processId) throws Exception {
        try {
            Lot lot = lotRepository.findById(id);
            Process process = processRepository.findById(processId);
            if (lot.getProcess() == null) {
                lot.setProcess(process);
                lotRepository.save(lot);
                return lot;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*--====================  Delete   ====================--*/

    /**
     *
     * @param id
     * @return lots
     * @throws Exception
     */
    @ApiOperation(value = "Supprime UN lot")
    @DeleteMapping(value = "/lots/delete/{id}")
    public List<Lot> deleteOneLot(@PathVariable int id) throws Exception {
        try {
            lotRepository.deleteById(id);
            List<Lot> lots = lotRepository.findAll();
            return lots;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /*--====================  Update   ====================--*/

    /**
     *
     * @param lotService
     * @return lots
     * @throws Exception
     */

    @ApiOperation(value = "Modifie UN Lot")
    @PutMapping(value = "/lots")
    @ResponseBody
    public List<Lot> updateLot(@RequestBody LotService lotService) throws Exception {
        try {
            Lot lot = LotService.editLot(lotService);
            lotRepository.save(lot);
            List<Lot> lots = lotRepository.findAll();
            return lots;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
