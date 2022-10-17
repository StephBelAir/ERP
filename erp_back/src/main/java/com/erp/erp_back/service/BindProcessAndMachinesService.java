package com.erp.erp_back.service;


import com.erp.erp_back.model.Machine;
import java.util.List;

public class BindProcessAndMachinesService {



  private String processName;
  private List<Machine> machineName;

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  public void setMachineName(List<Machine> machineName) {
    this.machineName = machineName;
  }

  public List<Machine> getMachineList() {
    return machineName;
  }
/*
  public void setMachineName(String machineName) {
    for(int i = 0; i < this.machineName.size(); i ++) {
      this.machineName.set(machineName);
    }
  } */
}
