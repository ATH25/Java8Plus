package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.BiFunction;

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

        /*use andThen()*/


    }
}