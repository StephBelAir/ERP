package com.erp.erp_back.service;


import com.erp.erp_back.model.Machine;
import java.util.List;

public class BindProcessAndMachinesService {



  private int processId;
  private List<Machine> machineId;

  public int getProcessId() {
    return processId;
  }

  public void setProcessId(int processId) {
    this.processId = processId;
  }

  public void setMachineId(List<Machine> machineId) {
    this.machineId = machineId;
  }

  public List<Machine> getMachineList() {
    return machineId;
  }
/*
  public void setMachineName(String machineName) {
    for(int i = 0; i < this.machineName.size(); i ++) {
      this.machineName.set(machineName);
    }
  } */
}
