package com.goeuro.assignment.csv;

import com.goeuro.assignment.Application;
import com.goeuro.assignment.domain.GeoPosition;
import com.goeuro.assignment.domain.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.assertj.core.api.StrictAssertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CsvGeneratorTest {

    @Autowired
    private CsvGenerator csvGenerator;

    private Position[] positions;

    @Value("${csv.fileName}")
    private String CSV_FILE_NAME_ACTUAL;
    private String CSV_FILE_NAME_EXPECTED = "exptected_test_locations.csv";

    @Test
    public void testWriteToCsv() throws Exception {
        //given
        positions = new Position[2];
        Position position1 = new Position();
        position1.setId(1L);
        position1.setName("positionName1");
        position1.setType("positionType1");
        position1.setType("location");

        GeoPosition geoPosition1 = new GeoPosition();
        geoPosition1.setLatitude(10.1111);
        geoPosition1.setLatitude(1111.111);

        position1.setGeoPosition(geoPosition1);

        Position position2 = new Position();
        position2.setId(1L);
        position2.setName("positionName1");
        position2.setType("positionType1");
        position2.setType("location");

        GeoPosition geoPosition2 = new GeoPosition();
        geoPosition1.setLatitude(10.1111);
        geoPosition1.setLatitude(1111.111);

        position2.setGeoPosition(geoPosition2);

        positions[0] = position1;
        positions[1] = position2;

        //when
        csvGenerator.writeToCsv(positions);

        //then
        BufferedReader brActual = new BufferedReader(new FileReader(CSV_FILE_NAME_ACTUAL));
        BufferedReader brExpected = new BufferedReader(new FileReader(CSV_FILE_NAME_EXPECTED));

        String currentLineActual;
        String currentLineExpected;

        while ((currentLineActual = brActual.readLine()) != null && (currentLineExpected = brExpected.readLine()) != null) {
            assertThat(currentLineActual).isEqualTo(currentLineExpected);
        }
    }
}