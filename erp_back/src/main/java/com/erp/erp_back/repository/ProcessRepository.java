package com.erp.erp_back.repository;

import com.erp.erp_back.model.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface permet d’accéder aux Process pour pouvoir lire ou modifier dans une base de données. *
 */
@Repository
public interface ProcessRepository extends JpaRepository<Process, Integer> {
  List<Process> findAll();

  Process findById(int id);

  Process save(Process process);
}
