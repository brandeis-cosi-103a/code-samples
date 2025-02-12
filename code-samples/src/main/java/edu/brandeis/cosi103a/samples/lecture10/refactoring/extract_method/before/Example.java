package edu.brandeis.cosi103a.samples.lecture10.refactoring.extract_method.before;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Weight in kgs: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in cms: ");
        double height = scanner.nextDouble();

        double height2 = height / 100;
        double BMI = weight / (height2 * height2);

        System.out.println("BMI is: " + BMI);

        scanner.close();
    }
}