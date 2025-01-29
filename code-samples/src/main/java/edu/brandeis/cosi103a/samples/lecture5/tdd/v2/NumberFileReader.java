package edu.brandeis.cosi103a.samples.lecture5.tdd.v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberFileReader {
    public List<Double> readNumbersFromFile(String filePath) throws IOException {
        List<Double> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Double.parseDouble(line));
            }
        }
        return numbers;
    }
}
