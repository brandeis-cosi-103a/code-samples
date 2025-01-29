package edu.brandeis.cosi103a.samples.lecture5.tdd.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberAnalyzerTest {
    private NumberAnalyzer analyzer;

    @BeforeEach
    public void setUp() throws IOException {
        analyzer = new NumberAnalyzer("src/test/resources/test_numbers.txt");
    }

    @Test
    public void testComputeAverage() {
        assertEquals(3.0, analyzer.computeAverage(), 0.001);
    }

    @Test
    public void testComputeStandardDeviation() {
        assertEquals(1.414, analyzer.computeStandardDeviation(), 0.001);
    }

    @Test
    public void testCount() {
        assertEquals(5, analyzer.count());
    }

    @Test
    public void testComputeMin() {
        assertEquals(1.0, analyzer.computeMin(), 0.001);
    }

    @Test
    public void testComputeMax() {
        assertEquals(5.0, analyzer.computeMax(), 0.001);
    }

    @Test
    public void testComputeSum() {
        assertEquals(15.0, analyzer.computeSum(), 0.001);
    }
}
