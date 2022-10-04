package com.erp.erp_back;

import com.erp.erp_back.model.Lot;
import com.erp.erp_back.model.Machine;
import com.erp.erp_back.repository.LotRepository;
import com.erp.erp_back.repository.MachineRepository;
import com.erp.erp_back.repository.ProcessRepository;
import java.lang.invoke.MethodHandles;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ErpBackApplication {

  private static final Logger LOGGER = LoggerFactory.logger(MethodHandles.lookup().lookupClass());


  public static void main(String[] args) {
    SpringApplication.run(ErpBackApplication.class, args);
  }

  /*--====================  Add default data at app init   ====================--*/

  @Bean
  public CommandLineRunner commandLineRunner(LotRepository lotRepository,
                                             MachineRepository machineRepository,
                                             ProcessRepository processRepository) {

    return args -> {

      Machine machineCreated;
      machineCreated = new Machine(4, "TTH");
      machineCreated = machineRepository.save(machineCreated);

      Lot lotCreated;
      lotCreated = new Lot(1, "HSR", 30);
      lotCreated = lotRepository.save(lotCreated);


      LOGGER.info("*** Application started with Default Data ***");

    };
  }


}
