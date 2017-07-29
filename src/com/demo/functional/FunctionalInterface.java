package com.demo.functional;

@java.lang.FunctionalInterface
interface MathOperation {
    float operation(float a, float b);
}

public class FunctionalInterface {
    public static void main(String[] args) {
        /***
         * Multiply of two numbers
         */

        MathOperation mathOperation = (a, b) -> {
            return a * b;
        };

        System.out.println(multiply(5, 6, mathOperation));

        mathOperation = (a, b) -> {
            b = b == 0 ? b : 1;
            return a / b;
        };

        System.out.println(divide(25, 5, mathOperation));

        mathOperation = (a, b) -> {
            return a + b;
        };

        System.out.println(add(10, 5, mathOperation));
        mathOperation = (a, b) -> {
            return a - b;
        };

        System.out.println(add(10, 5, mathOperation));

    }

    public static float multiply(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    public static float add(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static float divide(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static float minus(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
