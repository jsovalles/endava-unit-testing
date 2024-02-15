package com.endava.tdd.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void testAdd() {
        assertEquals(8, calculatorService.add(5, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculatorService.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calculatorService.multiply(5, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        try {
            calculatorService.divide(6, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }
}
