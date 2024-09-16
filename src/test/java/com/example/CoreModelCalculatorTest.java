//package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoreModelCalculatorTest {

    @Test
    public void testCoreModelCalculator() {
        CoreModelCalculator calculator = new CoreModelCalculator("EE25/13/7");

        assertEquals(2.32, calculator.getCoreFactor(), 0.01);
        assertEquals(2410.0, calculator.getEffectiveVolume(), 0.1);
        assertEquals(58.0, calculator.getEffectiveLength(), 0.1);
        assertEquals(41.55, calculator.getEffectiveArea(), 0.01);
        assertEquals(22.75, calculator.getMinimumArea(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCoreModel() {
        new CoreModelCalculator("InvalidModel");
    }
}