package edu.brandeis.cosi103a.samples.lecture10.refactoring.extract_variable.before;

public class Example {

    public static void printTempStats(double tempFahrenheit) {
        System.out.println("Temperature is: " + (tempFahrenheit - 32) * 5 / 9 + "C");

        if ((tempFahrenheit - 32) * 5 / 9 > 37) {
            System.out.println("It's really hot!");
        } else if ((tempFahrenheit - 32) * 5 / 9 < 10) {
            System.out.println("It's really cold!");
        } else {
            System.out.println("It's moderate!");
        }
    }

    public static void main(String[] args) {
        printTempStats(100); // Example usage
    }
}
