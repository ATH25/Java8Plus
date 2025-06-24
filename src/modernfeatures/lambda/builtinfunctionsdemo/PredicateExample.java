package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Predicate;

/**
 * Class: PredicateExample
 * ------------------------
 * This class demonstrates:
 * 1. The built-in functional interface Predicate<T>
 *
 * - Predicate<T> represents a function that takes an input of type T and returns a boolean.
 * - The method to implement is test(T t).
 * - It is commonly used for conditional checks and filtering.
 */
public class PredicateExample {

    public static void main(String[] args) {
        // Predicate that checks if a string is empty
        Predicate<String> isEmpty = message -> message.isEmpty();

        // Test the predicate with an empty string
        String test1 = "";
        System.out.printf("Is string empty? %b%n", isEmpty.test(test1));

        // Test the predicate with a non-empty string
        String test2 = "Java 8 Functional Interfaces";
        System.out.printf("Is string empty? %b%n", isEmpty.test(test2));

        // Predicate that checks if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;
        int testNumber = 10;
        System.out.printf("Is %d even? %b%n", testNumber, isEven.test(testNumber));

        // Predicate with negation using .negate()
        Predicate<Integer> isOdd = isEven.negate();
        int testNumber2 = 15;
        System.out.printf("Is %d odd? %b%n", testNumber2, isOdd.test(testNumber2));
    }
}