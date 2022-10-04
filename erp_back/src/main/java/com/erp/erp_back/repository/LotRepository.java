package com.erp.erp_back.repository;

import com.erp.erp_back.model.Lot;
import java.util.ArrayList;
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


  Lot save(Lot lot);
}
