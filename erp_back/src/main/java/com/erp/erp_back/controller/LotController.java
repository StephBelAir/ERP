package com.erp.erp_back.controller;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.LotRepository;
import com.erp.erp_back.repository.ProcessRepository;
import com.erp.erp_back.service.LotService;
import com.erp.erp_back.service.PlanningUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Ce contrôleur est une classe, dont l’objectif est de réagir à une interaction avec l’utilisateur vers un Lot.
 * <br>
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

  private PlanningUserService planningUserService;


  /*--====================  Get   ====================--*/

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
   * Get avec Restriction des données visibles pour le rôle du technicien "Planning"
   *
   * @return lotsList
   * @throws Exception
   */

  @ApiOperation(value = "Récupère TOUT les lots existants Pour le role Planning")
  @GetMapping(value = "/lots/planning")
  public List<PlanningUserService> getAllLotsForPlanning() throws Exception {
    try {
      List<Lot> lotsList = lotRepository.findAll();

      List<PlanningUserService> planingsUserDTOsList = new ArrayList<>();
      for (Lot l: lotsList) {
        // transformer le lot en planning
        PlanningUserService p = PlanningUserService.fromLot(l);
        planingsUserDTOsList.add(p);
      }

      return planingsUserDTOsList;
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }

  /*--====================  Get avec une Query ====================--*/

  /**
   * Get avec query SQL
   *
   * @return lotsListByProductName
   * @throws Exception
   */
  /*
  @ApiOperation(value = "Récupère TOUT les lots SEULEMENT avec le productName")
  @GetMapping({"/lots/query"})
  public List<Lot> getFindAllByQuery() throws Exception {
    try {
      List<Lot> lotsListByProductName = lotRepository.findAllByQuery();
      return lotsListByProductName;
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }
*/


  /*--====================  Post   ====================--*/

  /**
   * @param lotService
   * @return lots
   * @throws Exception
   */
  @ApiOperation(value = "Créer UN lot")
  @PostMapping(value = "/lots/add")
  @ResponseBody
  public Lot createLot(@RequestBody Lot lotService) throws Exception {
    try {
      return lotRepository.save(lotService);
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
   * @param id
   * @return lots
   * @throws Exception
   */
  @ApiOperation(value = "Supprime UN lot")
  @DeleteMapping(value = "/lots/delete/{id}")
  public void deleteOneLot(@PathVariable int id) throws Exception {
    try {
      lotRepository.deleteById(id);

    } catch (Exception ex) {
      System.out.println(ex);
    }
  }


  /*--====================  Update   ====================--*/

  /**
   * @param lotService
   * @return lots
   * @throws Exception
   */

  @ApiOperation(value = "Mise en production d'UN lot")
  @PutMapping(value = "/lots")
  @ResponseBody
  public Lot updateLot(@RequestBody LotService lotService) throws Exception {
    try {
      Lot lot = LotService.editLot(lotService);


      return lotRepository.save(lot);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return null;
  }

  /*--====================  Patch Mise en Production pour Plusieurs Paramètres   ====================--*/

  /**
   * Mise en route ou Fin de lot <br>
   * Patch Lot sans effacer les autres paramètres
   *
   * @param id
   * @param updateLot
   * @return updateLot
   */

  @ApiOperation(value = "Mise en production d'UN lot")
  @PatchMapping("/lot/patch/{id}")
  public ResponseEntity<Lot> patchLot(@PathVariable int id,
                                      @RequestBody Lot updateLot) {

    updateLot.setId(id);

    lotRepository.save(updateLot);
    return new ResponseEntity<>(updateLot, HttpStatus.OK);
  }

  /*--====================  Patch Mise en Production pour Chaque Paramètre de date   ====================--*/


  @ApiOperation(value = "Mise en production d'UN lot avec SEULEMENT le param startDate")
  @PatchMapping("/lot/patch/startDate")
  public ResponseEntity<Lot> patchStartDatePartially(@RequestParam int id,
                                                     @RequestParam("startDate")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                     LocalDateTime startDate) {
    try {
      Lot lot = lotRepository.findById(id);
      lot.setStartDate(startDate);
      return new ResponseEntity<Lot>(lotRepository.save(lot), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ApiOperation(value = "Mise en production d'UN lot avec SEULEMENT le param endDate")
  @PatchMapping("/lot/patch/endDate")
  public ResponseEntity<Lot> patchEndDatePartially(@RequestParam int id, @RequestParam("endDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
    try {
      Lot lot = lotRepository.findById(id);
      lot.setEndDate(endDate);
      return new ResponseEntity<Lot>(lotRepository.save(lot), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ApiOperation(value = "Mise en production d'UN lot avec SEULEMENT le param actualEndDate")
  @PatchMapping("/lot/patch/actualEndDate")
  public ResponseEntity<Lot> patchActualEndDatePartially(@RequestParam int id,
                                                         @RequestParam("actualEndDate")
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                         LocalDateTime actualEndDate) {
    try {
      Lot lot = lotRepository.findById(id);
      lot.setActualEndDate(actualEndDate);
      return new ResponseEntity<Lot>(lotRepository.save(lot), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
