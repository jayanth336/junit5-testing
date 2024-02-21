package com.junit.testing.junit5.dietplanner;

import com.junit.testing.junit5.domain.Coder;
import com.junit.testing.junit5.domain.DietPlan;
import com.junit.testing.junit5.domain.Gender;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DietPlannerTest {

    /**Methods in DietPlanner class is not static. So we need an object to call them.
     * We have given the object in @BeforeEach method to reuse the same object for every test case.
     *
     */
    private DietPlanner dietPlanner;

    @BeforeEach
    void setUp() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Unit test is finished");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before executing all testcases");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After executing all testcases");
    }


    //Test calculateDiet method
    @Test()
    void should_return_correct_dietPlan() {
        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);
        //when
        DietPlan actual = dietPlanner.calculateDiet(coder);
        //then
        assertEquals(expected, actual);
    }
}
