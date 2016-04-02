package com.goeuro.assignment.client;

import com.goeuro.assignment.domain.Position;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestApiClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${client.restEndpoints.getPositions}")
    private String POSITION_ENDPOINT;

    public ResponseEntity<Position[]> getPositions(String location) throws Exception {
        return restTemplate.getForEntity(POSITION_ENDPOINT, Position[].class, location);
    }
}
