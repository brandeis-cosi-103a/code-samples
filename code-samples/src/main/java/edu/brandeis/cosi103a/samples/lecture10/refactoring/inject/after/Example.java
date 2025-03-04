package edu.brandeis.cosi103a.samples.lecture10.refactoring.inject.after;

interface Emitter {
    void emit(String message);
}

class ConsoleEmitter implements Emitter {
    @Override
    public void emit(String message) {
        System.out.println(message);
    }
}

// We've made the function testable by dependency-injecting a function for output.
// See the test in ...lecture10.refactoring.inject.after.ExampleTest
// Additionally, the functuon is now more flexible as it can output in any way that
// satisfies the Emitter interface.

public class Example {

    public static void printTempStats(double tempFahrenheit, Emitter emitter) {
        double tempCelsius = (tempFahrenheit - 32) * 5 / 9;
        emitter.emit("Temperature is: " + tempCelsius + "C");

        if (tempCelsius > 37) {
            emitter.emit("It's really hot!");
        } else if (tempCelsius < 10) {
            emitter.emit("It's really cold!");
        } else {
            emitter.emit("It's moderate!");
        }
    }
}