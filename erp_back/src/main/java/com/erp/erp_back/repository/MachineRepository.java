package com.erp.erp_back.repository;

import com.erp.erp_back.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {
    List<Machine> findAll();

    Machine findById(int id);
}