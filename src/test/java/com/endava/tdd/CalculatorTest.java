package com.endava.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.endava.tdd.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    private Calculator calculator;
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = mock(CalculatorServiceImpl.class);
        calculator = new Calculator(calculatorService);
    }

    @Test
    public void testAdd() {
        int a = 5;
        int b = 3;
        int expectedSum = 8;
        when(calculatorService.add(a, b)).thenReturn(expectedSum);


        int result = calculator.add(a, b);

        assertEquals(expectedSum, result);
    }

    @Test
    public void testSubtract() {
        int a = 5;
        int b = 3;
        int expectedDifference = 2;
        when(calculatorService.subtract(a, b)).thenReturn(expectedDifference);

    
        int result = calculator.subtract(a, b);

        assertEquals(expectedDifference, result);
    }

    @Test
    public void testMultiply() {

        int a = 5;
        int b = 3;
        int expectedProduct = 15;
        when(calculatorService.multiply(a, b)).thenReturn(expectedProduct);


        int result = calculator.multiply(a, b);

        assertEquals(expectedProduct, result);
    }

    @Test
    public void testDivide() {

        int a = 6;
        int b = 3;
        int expectedQuotient = 2;
        when(calculatorService.divide(a, b)).thenReturn(expectedQuotient);

        int result = calculator.divide(a, b);

        assertEquals(expectedQuotient, result);
    }

    @Test
    public void testDivideByZero() {

        int a = 6;
        int b = 0;
        when(calculatorService.divide(a, b)).thenThrow(new IllegalArgumentException("Cannot divide by zero"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
