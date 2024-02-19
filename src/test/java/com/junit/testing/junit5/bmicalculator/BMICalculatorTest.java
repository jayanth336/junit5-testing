package com.junit.testing.junit5.bmicalculator;

import com.junit.testing.junit5.domain.Coder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    //Test findCoderWithWorstBMI method
    @Test
    void should_return_coderWithWorstBMI_when_listIsNotEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>(List.of(
                new Coder(1.80,60.0),
                new Coder(1.82, 98.0),
                new Coder(1.82, 64.7)
        ));
        //when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
//        assertEquals(1.82, coderWithWorstBMI.getHeight());
//        assertEquals(98.0, coderWithWorstBMI.getWeight());

        /**
         * The above 2 tet cases can be written as a single assertAll test case
         */
        assertAll(
                () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWithWorstBMI.getWeight())
        );
    }

    @Test
    void should_return_null_when_listIsEmpty() {
        //given
        List<Coder> coderList = new ArrayList<>();
        //when
        Coder coder = BMICalculator.findCoderWithWorstBMI(coderList);
        //then
        assertNull(coder);
    }

    //Test getBMIScores method
    @Test
    void should_return_BMIScores_of_all_coders() {
        //given
        List<Coder> coderList = new ArrayList<>(List.of(
                new Coder(1.80,60.0),
                new Coder(1.82, 98.0),
                new Coder(1.82, 64.7)
        ));
        double[] expected = {18.52, 29.59, 19.53};
        //when
        double[] bmiScore = BMICalculator.getBMIScores(coderList);
        //then
        assertArrayEquals(expected, bmiScore);
    }
}
