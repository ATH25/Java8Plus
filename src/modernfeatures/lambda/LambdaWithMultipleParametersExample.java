package modernfeatures.lambda;

// Declaring a functional interface with one abstract method.
// The @FunctionalInterface annotation enforces that only one abstract method exists.
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);  // Method name follows Java naming conventions (camelCase)
}

/**
 * Class: LambdaWithMultipleParametersExample
 * -------------------------------------------
 * Demonstrates how Java 8 Lambda expressions can be used with multiple parameters.
 *
 * Lambdas simplify the implementation of functional interfaces.
 * Here, we use a Calculator interface that takes two integer parameters and returns an integer result.
 */
public class LambdaWithMultipleParametersExample {
    public static void main(String[] args) {
        // Lambda expression for addition
        // Using explicit parameter types
        Calculator add = (int a, int b) -> a + b;
        System.out.println("Addition Result: " + add.calculate(10, 20));

        // Lambda expression for multiplication
        // Relying on type inference; parameter types are optional
        Calculator multiply = (a, b) -> a * b;
        System.out.println("Multiplication Result: " + multiply.calculate(10, 20));

        // Lambda expression for division
        // Simple division operation
        Calculator divide = (a, b) -> a / b;
        System.out.println("Division Result: " + divide.calculate(20, 10));

        // Lambda expression for modulo operation
        // Calculates remainder
        Calculator mod = (a, b) -> a % b;
        System.out.println("Modulo Result: " + mod.calculate(10, 3));

        // Lambda expression for subtraction
        // Using simple subtraction
        Calculator subtract = (a, b) -> a - b;
        System.out.println("Subtraction Result: " + subtract.calculate(10, 3));
    }
}
