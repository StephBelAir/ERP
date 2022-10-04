package com.erp.erp_back;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.repository.LotRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErpBackApplicationTests {

	@Autowired
	private LotRepository lotRepository;

	@Test
	void contextLoads() {
		// ARRANGE
		int a = 2;
		String b = "test";
		int c = 35;
		Lot lot = new Lot(a, b, c);

		// ACT
		lot = lotRepository.save(lot);

		// ASSERT
		Assertions.assertThat(lot.getId()).isEqualTo(2);


	}

}
