package com.erp.erp_back.repository;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.service.PlanningUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Cette interface permet d’accéder aux Lots pour pouvoir lire ou modifier dans une base de données. *
 */
@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {

  Lot findById(int id);

 @Query("SELECT new Lot (l.id, l.productName) from Lot l")
 ArrayList<Lot> findAllByQuery();

  @Query("SELECT new Lot (p.id, p.productName, p.width) from Lot p")
  List<PlanningUserService> findAllPlaning();

  Lot save(Lot lot);
}
