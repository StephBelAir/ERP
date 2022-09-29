package com.erp.erp_back.service;

import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.ProcessRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// = DTO

/**
 * Objets qui transportent des données entre les couches, où toutes les données d'un Process
 * <br>
 * qui seront utilisées sont rassemblées avant d'aller dans un controlleur.
 */
@Service
public class ProcessService {

  protected int processId;
  protected String processName;
  protected List<Machine> machines;

  static ProcessRepository processRepository;

  public ProcessService() {
  }

  public int getProcessId() {
    return processId;
  }

  public void setProcessId(int processId) {
    this.processId = processId;
  }

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  /**
   * @return machines
   */
  public List<Machine> getMachines() {
    return machines;
  }

  /**
   * @param machines
   */
  public void setMachines(List<Machine> machines) {
    this.machines = machines;
  }

  /**
   * @return processRepository
   */
  public static ProcessRepository getProcessRepository() {
    return processRepository;
  }

  /**
   * @param processRepository
   */
  public static void setProcessRepository(ProcessRepository processRepository) {
    ProcessService.processRepository = processRepository;
  }

  /**
   * @param processService
   * @return process
   */
  public static Process addProcess(ProcessService processService) {
    Process process = new Process(processService.getProcessName());
    return process;
  }

  public static Process editProcess(ProcessService processService) {
    Process process = new Process(processService.getProcessId(), processService.getProcessName());
    return process;
  }

}
