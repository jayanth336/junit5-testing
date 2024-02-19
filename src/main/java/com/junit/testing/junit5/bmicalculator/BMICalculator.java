package com.junit.testing.junit5.bmicalculator;

public class BMICalculator {
    private static final double BMI_THRESHOLD = 25.0;

    public static boolean isDietRecommended(double weight, double height) {
        if (height == 0.0) throw new ArithmeticException();
        double bmi = weight / (height * height);
        if (bmi < BMI_THRESHOLD)
            return false;
        return true;
    }
}
