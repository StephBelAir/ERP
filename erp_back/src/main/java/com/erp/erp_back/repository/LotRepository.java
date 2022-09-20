package com.erp.erp_back.repository;

import com.erp.erp_back.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {
    List<Lot> findAll();

    Lot findById(int id);

    Lot save(Lot lot);
}
