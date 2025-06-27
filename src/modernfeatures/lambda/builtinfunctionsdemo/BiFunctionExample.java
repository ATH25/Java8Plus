package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class: BiFunctionExample
 * -------------------------
 * This class demonstrates:
 * 1. The built-in functional interface BiFunction<T, U, R>
 *
 * - BiFunction<T, U, R> represents a function that takes two inputs of type T and U,
 *   and returns a result of type R.
 * - The method to implement is apply(T t, U u).
 */
public class BiFunctionExample {

    public static void main(String[] args) {
        // BiFunction that adds two integers
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        int sum = add.apply(10, 20);
        System.out.printf("Sum of 10 and 20 is: %d%n", sum);

        // BiFunction that concatenates two strings
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;
        String combined = concatenate.apply("Java", "21");
        System.out.printf("Concatenation result: %s%n", combined);

        // BiFunction that combines a string and an integer into a formatted message
        BiFunction<String, Integer, String> formatMessage = (name, score) -> String.format("%s scored %d points.", name, score);
        String message = formatMessage.apply("Alice", 95);
        System.out.println(message);

        // Demonstrating the use of andThen() with BiFunction
        // Step 1: BiFunction that multiplies two integers and returns an Integer
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;

        // Step 2: Function that converts the Integer result into a formatted String
        // after will receive the output of the BiFunction (Integer) and return a String
        Function<Integer, String> toResultString = result -> String.format("The result is: %d", result);

        // Step 3: Chain them using andThen
        // andThen returns a new BiFunction that first multiplies the inputs, then applies the Function
        BiFunction<Integer, Integer, String> multiplyAndFormat = multiply.andThen(toResultString);

        // Step 4: Use the combined BiFunction
        String formatted = multiplyAndFormat.apply(7, 6);
        System.out.println(formatted); // Output: The result is: 42

    }
}