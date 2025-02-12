package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_libraries.before;

import java.util.List;

class StatisticsCalculator {
    private List<Double> numbers;

    public StatisticsCalculator(List<Double> numbers) {
        this.numbers = numbers;
    }

    public double getSum() {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getAverage() {
        return getSum() / numbers.size();
    }

    public double getMax() {
        return numbers.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
    }

    public double getMin() {
        return numbers.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
    }

    public double getStandardDeviation() {
        double mean = getAverage();
        double variance = numbers.stream()
                .mapToDouble(num -> Math.pow(num - mean, 2))
                .sum() / numbers.size();
        return Math.sqrt(variance);
    }

    public double getDotProduct(List<Double> list) {
        if (numbers.size() != list.size()) {
            throw new IllegalArgumentException("The lengths of the two lists must be the same.");
        }
        double dotProduct = 0;
        for (int i = 0; i < numbers.size(); i++) {
            dotProduct += numbers.get(i) * list.get(i);
        }
        return dotProduct;
    }
}