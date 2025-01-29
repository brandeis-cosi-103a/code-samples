package edu.brandeis.cosi103a.samples.lecture5.tdd.v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {
    private List<Double> numbers;

    public NumberAnalyzer(String filePath) throws IOException {
        numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Double.parseDouble(line));
            }
        }
    }

    public double computeAverage() {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public double computeStandardDeviation() {
        double mean = computeAverage();
        double sum = 0;
        for (double number : numbers) {
            sum += Math.pow(number - mean, 2);
        }
        return Math.sqrt(sum / numbers.size());
    }

    public int count() {
        return numbers.size();
    }

    public double computeMin() {
        double min = Double.MAX_VALUE;
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public double computeMax() {
        double max = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public double computeSum() {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
    // Additional methods for other statistics can be added here
}
