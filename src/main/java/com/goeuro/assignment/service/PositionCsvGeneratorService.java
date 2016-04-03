package com.goeuro.assignment.service;

import com.goeuro.assignment.client.RestApiClient;
import com.goeuro.assignment.csv.CsvGenerator;
import com.goeuro.assignment.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PositionCsvGeneratorService {
    @Autowired
    public CsvGenerator csvGenerator;

    @Autowired
    private RestApiClient goEuroHttpClient;

    public void generateCsvForLocationQuery(String locationQuery) throws Exception {
        ResponseEntity<Position[]> response = goEuroHttpClient.getPositions(locationQuery);
        Position[] positions = response.getBody();
        csvGenerator.writeToCsv(positions);
    }

}
