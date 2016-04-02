package com.goeuro.assignment.client;

import com.goeuro.assignment.Application;
import com.goeuro.assignment.domain.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RestApiClientTest {

    private int BERLIN_RESPONSE_ARRAY_LENGTH = 8;
    private int DEFAULT_RESPONSE_ARRAY_LENGTH = 0;

    @Autowired
    private RestApiClient goEuroRestClient;

    @Test
    public void testGetPositionsByLocation_whenLocationValid() throws Exception{
        //given
        String locationBerlin = "BERLIN";
        //when
        ResponseEntity<Position[]> response = goEuroRestClient.getPositions(locationBerlin);
        Position[] positions = response.getBody();
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(positions.length).isEqualTo(BERLIN_RESPONSE_ARRAY_LENGTH);
    }

    @Test
    public void testGetInformationByLocation_whenLocationIsEmptyString() throws Exception{
        //given
        String location = "";
        //when
        ResponseEntity<Position[]> response = goEuroRestClient.getPositions(location);
        Position[] positions = response.getBody();
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(positions.length).isEqualTo(DEFAULT_RESPONSE_ARRAY_LENGTH);
    }

}