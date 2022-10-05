package com.erp.erp_back;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class ErpBackApplicationTests {

	@Autowired
	private LotRepository lotRepository;



	/**
	 * Test CRUD Save
	 * Un lot Id1 est créé au lancement de ERPBackApplication, l'Id 2 sera donc testé
	 */
	@Test
	@Order(1)
	@Rollback(value = false)
	void saveLotTest() {
		// ARRANGE
		int a = 2;
		String b = "test";
		int c = 35;
		Lot lot = new Lot(a, b, c);

		// ACT
		lot = lotRepository.save(lot);

		// ASSERT
		Assertions.assertThat(lot.getId()).isEqualTo(a);

	}

	/**
	 * Test CRUD GetByID
	 */
	@Test
	@Order(2)
	void getByIdLotTest() {
		// ARRANGE
		int a = 1;

		// ACT
		Lot lot = lotRepository.findById(a);

		// ASSERT
		Assertions.assertThat(lot.getId()).isEqualTo(a);
	}

	/**
	 * Test CRUD GetALL
	 */
	@Test
	@Order(3)
	void getAllLotTest() {
		// ARRANGE
		int a = 0;

		// ACT
		List<Lot> lot = lotRepository.findAll();

		// ASSERT
		Assertions.assertThat(lot.size()).isGreaterThan(a);
	}

	//Todo add patch Test

	@Test
	@Order(4)
	void patchLotStartDate(){

		// ARRANGE
		LocalDateTime a = LocalDateTime.now();
		Date b = new Date();

		String testDate = "a = " + a + "b = " + b;
		// 2022-10-05T11:43:34.658528618
		// 2022-10-05T11:47:24.801616729

		// ACT

		Lot lot = lotRepository.findById(1);
		lot.setStartDate(a);
		Lot lotUpdated = lotRepository.save(lot);

		// ASSERT
		Assertions.assertThat(lotUpdated.getStartDate()).isEqualTo(a);
		System.out.println(testDate);

	}



	//Todo en cours

	/**
	 * Test CRUD Delete
	 */
	/*
	@Test
	@Order(5)
	void deleteByIDLotTest() {
		// ARRANGE
		int a = 1;

		// ACT
		Lot lot = lotRepository.findById(a);
		lotRepository.deleteById(a);
		List<Lot> lot1 = lotRepository.findAll();


		// ASSERT
		Assertions.assertThat(lot1.size()).isNull();
	}*/

}
