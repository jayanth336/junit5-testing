package com.junit.testing.junit5.bmicalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BMICalculatorTest {

    //Test isDietRecommended method
    @Test
    void should_ReturnTrue_when_DietRecommended() {
        //given
        double weight = 81.2;
        double height = 1.65;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_when_DietNotRecommended() {
        //given
        double weight = 50;
        double height = 1.95;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertFalse(recommended);
    }

    @Test
    void should_ThrowException_when_HeightZero() {
        //given
        double weight = 50;
        double height = 0;
        //when
        /**
         * To test a method that throws an exception, we need to use Executable variable.
         * This is done because, at the time of throwing exception, the execution stops right at the invocation part
         *  and doesn't go further.
         */
        Executable executable = () ->BMICalculator.isDietRecommended(weight, height);
        //then
        assertThrows(ArithmeticException.class, executable);
    }

    //Test
}
