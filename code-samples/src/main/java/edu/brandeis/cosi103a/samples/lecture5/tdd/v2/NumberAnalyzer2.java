package edu.brandeis.cosi103a.samples.lecture5.tdd.v2;

import java.util.List;

public class NumberAnalyzer2 {
    private List<Double> numbers;

    public NumberAnalyzer2(List<Double> numbers) {
        this.numbers = numbers;
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
