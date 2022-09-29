package com.erp.erp_back.repository;

import com.erp.erp_back.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette interface permet d’accéder aux Lots pour pouvoir lire ou modifier dans une base de données. *
 */
@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {
  List<Lot> findAll();

  Lot findById(int id);

  @Query("SELECT new Lot (l.id, l.productName) from Lot l")
  ArrayList<Lot> findAllByQuery();

  // @Query("SELECT new Lot (p.id, p.productName, p.width) from Lot p")
  // List<PlanningService> findAllPlaning();

  Lot save(Lot lot);
}
