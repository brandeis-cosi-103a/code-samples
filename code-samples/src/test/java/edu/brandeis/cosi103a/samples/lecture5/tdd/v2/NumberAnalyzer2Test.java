package edu.brandeis.cosi103a.samples.lecture5.tdd.v2;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NumberAnalyzer2Test {

    @Test
    public void testComputeAverage() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(3.0, analyzer.computeAverage(), 0.0001);
    }

    @Test
    public void testComputeStandardDeviation() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(1.4142, analyzer.computeStandardDeviation(), 0.0001);
    }

    @Test
    public void testCount() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(5, analyzer.count());
    }

    @Test
    public void testComputeMin() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(1.0, analyzer.computeMin(), 0.0001);
    }

    @Test
    public void testComputeMax() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(5.0, analyzer.computeMax(), 0.0001);
    }

    @Test
    public void testComputeSum() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        NumberAnalyzer2 analyzer = new NumberAnalyzer2(numbers);
        assertEquals(15.0, analyzer.computeSum(), 0.0001);
    }
}
