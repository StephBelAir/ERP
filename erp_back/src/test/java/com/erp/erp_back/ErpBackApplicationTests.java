package com.erp.erp_back;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.model.Machine;
import com.erp.erp_back.model.Process;
import com.erp.erp_back.repository.LotRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class ErpBackApplicationTests {

  @Autowired
  private LotRepository lotRepository;

  @Autowired
  private MockMvc mockMvc;

  /**
   * Arrange/Act/Assert (AAA) is a pattern for arranging and formatting code in Test methods.
   */


  /**
   * Test UNITAIRE de productionTimeTotalForOneParts()
   */
  @Test
  @Order(1)
  @Rollback(value = false)
  void testProductionTimeTotalForOnePartsUnit() throws Exception {

    // ARRANGE
    int prodTime1 = 5;
    final Machine machine1 = new Machine(13, prodTime1);

    int prodTime2 = 10;
    final Machine machine2 = new Machine(14, prodTime2);

    int prodTime3 = 15;
    final Machine machine3 = new Machine(15, prodTime3);

    int totalProdTime = prodTime1 + prodTime2 + prodTime3;

    final Process process = new Process(3);
    process.addMachine(machine1);
    process.addMachine(machine2);
    process.addMachine(machine3);

    // ACT
    final int productionTimeTotalForOnePartsCheck = process.getProductionTimeTotalForOneParts();

    // ASSERT
    assertEquals(totalProdTime, productionTimeTotalForOnePartsCheck);
  }

  /**
   * Test FONCTIONNEL de productionTimeTotalForOneParts()
   */
  @Test
  @Order(2)
  @Rollback(value = false)
  void testProductionTimeTotalForOnePartsFunctional() throws Exception {
    mockMvc.perform(get("/processes/1"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.productionTimeTotalForOneParts").value(6))
        .andExpect(jsonPath("$.machine.length()").value(3))
        .andReturn();
  }

  /*--====================  Tests non pertinent   ====================--*/


  /**
   * Test non pertinent
   * Test ProductTIme d'un constructeur sans inteligence
   */
  @Test
  @Order(3)
  @Rollback(value = false)
  void testProdTime() throws Exception {
    // ARRANGE
    int prodTime = 5;
    final Machine machine = new Machine(13, prodTime);

    // ACT
    final int prodTimeCheck = machine.getProductionTime();

    // ASSERT
    assertEquals(prodTime, prodTimeCheck);
  }


  /**
   * Test non pertinent
   * Test CRUD Save
   * 2 lots avec Id1 et Id2 sont créé au lancement de ERPBackApplication, l'Id 3 sera donc testé
   */
  @Test
  @Order(4)
  @Rollback(value = false)
  void saveLotTest() {
    // ARRANGE
    int a = 3;
    String b = "test";
    int c = 35;
    Lot lot = new Lot(a, b, c);

    // ACT
    lot = lotRepository.save(lot);

    // ASSERT
    Assertions.assertThat(lot.getId()).isEqualTo(a);

  }

  /**
   * Test non pertinent
   * Test CRUD GetByID
   */
  @Test
  @Order(5)
  void getByIdLotTest() {
    // ARRANGE
    int a = 1;

    // ACT
    Lot lot = lotRepository.findById(a);

    // ASSERT
    Assertions.assertThat(lot.getId()).isEqualTo(a);
  }

  /**
   * Test non pertinent
   * Test CRUD GetALL
   */
  @Test
  @Order(6)
  void getAllLotTest() {
    // ARRANGE
    int a = 0;

    // ACT
    List<Lot> lot = lotRepository.findAll();

    // ASSERT
    Assertions.assertThat(lot.size()).isGreaterThan(a);
  }

  /**
   * Test non pertinent
   * Test DateTime
   */

  @Test
  @Order(7)
  void patchLotStartDate() {

    // ARRANGE
    LocalDateTime a = LocalDateTime.now();
    Date b = new Date();

    String testDate = "a = " + a + "b = " + b;
    // 2022-10-05T11:43:34.658528618
    // Wed Oct 05 14:12:14 CEST 2022

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
