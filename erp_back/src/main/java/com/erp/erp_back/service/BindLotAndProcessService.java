package com.erp.erp_back.service;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.LotRepository;

public class BindLotAndProcessService {

  private int id;
  private int processId;

  public BindLotAndProcessService() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProcessId() {
    return processId;
  }

  public void setProcessId(int processId) {
    this.processId = processId;
  }
}
