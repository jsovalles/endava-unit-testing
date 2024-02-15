package com.endava.tdd;

import java.util.Scanner;

import com.endava.tdd.service.CalculatorServiceImpl;
import com.endava.tdd.service.ICalculatorService;

public class Calculator {
    
    private final ICalculatorService calculatorService;

    public Calculator(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int a, int b) {
        return calculatorService.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculatorService.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return calculatorService.multiply(a, b);
    }

    public int divide(int a, int b) {
        return calculatorService.divide(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator App!");

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Choose the operation (+, -, *, /): ");
        String operation = scanner.next();

        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        Calculator calculator = new Calculator(calculatorService);

        int result = 0;

        switch (operation) {
            case "+":
                result = calculator.add(num1, num2);
                break;
            case "-":
                result = calculator.subtract(num1, num2);
                break;
            case "*":
                result = calculator.multiply(num1, num2);
                break;
            case "/":
                try {
                    result = calculator.divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Division by zero");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation");
                scanner.close();
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
