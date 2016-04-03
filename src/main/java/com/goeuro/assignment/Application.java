package com.goeuro.assignment;

import com.goeuro.assignment.service.PositionCsvGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PositionCsvGeneratorService positionCsvGeneratorService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) {
        if (strings.length == 1 && !strings[0].trim().isEmpty()) {
            try {
                positionCsvGeneratorService.generateCsvForLocationQuery(strings[0].trim());
                log.debug("CSV file is generated successfully");
            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
            }
        } else {
            log.debug("Invalid params");
        }
    }
}
