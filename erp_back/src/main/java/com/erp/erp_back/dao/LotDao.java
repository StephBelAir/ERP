package com.erp.erp_back.dao;

import com.erp.erp_back.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotDao extends JpaRepository<Lot, Integer> {

    List<Lot> findAll();
    Lot findById(int id);
    Lot save(Lot lotDto);

}
