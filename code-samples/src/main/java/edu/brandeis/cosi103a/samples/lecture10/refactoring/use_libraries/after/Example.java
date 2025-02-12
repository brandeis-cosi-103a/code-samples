package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_libraries.after;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.ArrayRealVector;

// We've delegate all the statistical calculations to Apache Commons Math, 
// which is a mature, well-tested library. This class may not even need to exist anymore.

public class Example {
    private RealVector numbers;

    public Example(double[] numbers) {
        this.numbers = new ArrayRealVector(numbers);
    }

    public double getSum() {
        return numbers.getL1Norm();
    }

    public double getAverage() {
        return numbers.getL1Norm() / numbers.getDimension();
    }

    public double getMax() {
        return numbers.getMaxValue();
    }

    public double getMin() {
        return numbers.getMinValue();
    }

    public double getStandardDeviation() {
        StandardDeviation sd = new StandardDeviation();
        return sd.evaluate(numbers.toArray());
    }

    public double getDotProduct(double[] other) {
        RealVector otherVector = new ArrayRealVector(other);
        return numbers.dotProduct(otherVector);
    }
}
