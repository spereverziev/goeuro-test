package com.goeuro.assignment;

import com.goeuro.assignment.service.PositionCsvGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PositionCsvGeneratorService positionCsvGeneratorService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        if (strings.length == 1) {
            positionCsvGeneratorService.generateCsvForLocationQuery(strings[0]);
            System.out.println("SUCCESS");
        }
    }
}
