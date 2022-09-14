package com.erp.erp_back.repository;

import com.erp.erp_back.model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Integer> {
}
