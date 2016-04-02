package com.goeuro.assignment.csv;

import com.goeuro.assignment.domain.Position;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Component
public class CsvGenerator {

    private static final String CSV_SEPARATOR = ",";

    @Value("${csv.fileName}")
    private String CSV_FILE_NAME;

    @Value("${csv.fileEncoding}")
    private String CSV_FILE_ENCODING;

    public void writeToCsv(Position[] positions) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(
                    new FileOutputStream(CSV_FILE_NAME), CSV_FILE_ENCODING);
            BufferedWriter bw = new BufferedWriter(out);

            for (Position position : positions) {
                bw.write(toCsvReocord(position));
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
        }
    }

    private String toCsvReocord(Position position) {
        StringBuilder record = new StringBuilder();
        record.append(position.getId());
        record.append(CSV_SEPARATOR);
        record.append(position.getName());
        record.append(CSV_SEPARATOR);
        record.append(position.getType());
        record.append(CSV_SEPARATOR);
        record.append(position.getGeoPosition().getLatitude());
        record.append(CSV_SEPARATOR);
        record.append(position.getGeoPosition().getLongitude());
        return record.toString();
    }

}
