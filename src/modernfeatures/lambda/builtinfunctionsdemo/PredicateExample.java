package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Predicate;

/**
 * Class: PredicateExample
 * ------------------------
 * This class demonstrates:
 * 1. The built-in functional interface {@code Predicate<T>}
 *
 * - {@code Predicate<T>} represents a function that takes an input of type {@code T} and returns a boolean.
 * - The method to implement is {@code test(T t)}.
 * - It is commonly used for conditional checks and filtering.
 */
public class PredicateExample {

    /**
     * The main method demonstrates the usage of the built-in functional interface {@code Predicate<T>}.
     * Several examples of {@code Predicate} functionality are covered, including:
     * - Checking if a string is empty or not.
     * - Checking if a number is even or odd.
     * - Using predicate composition with {@code and()}, {@code or()}, and {@code negate()} methods.
     * - Defining custom predicates for various logical checks (e.g., length of a string, starting pattern, etc.).
     *
     * @param args Command-line arguments passed to the program (not used in this example).
     */
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

        /*Create a predicate that checks: Whether a given string is NOT empty*/
        System.out.println("\n--- Create a predicate that checks: Whether a given string is NOT empty ---");
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.printf("Is string NOT empty? %b%n", isNotEmpty.test(test1));
        System.out.printf("Is string NOT empty? %b%n", isNotEmpty.test(test2));

        Predicate<String> isNotEmpty2 = (s) -> !s.isEmpty();
        System.out.printf("Is string NOT empty? %b%n", isNotEmpty2.test(test1));
        System.out.printf("Is string NOT empty? %b%n", isNotEmpty2.test(test2));

        /*Create a predicate that checks: if the length of a string is greater than 5*/
        System.out.println("\n--- Create a predicate that checks: if the length of a string is greater than 5 ---");
        Predicate<String> isLengthGreaterThan5 = s -> s.length() > 5;
        System.out.printf("Is string greater than 5 characters? %b%n", isLengthGreaterThan5.test("Hello"));
        System.out.printf("Is string greater than 5 characters? %b%n", isLengthGreaterThan5.test("Java"));

        /*Create a predicate that checks: if the string starts with Java*/
        System.out.println("\n--- Create a predicate that checks: if the string starts with Java ---");
        Predicate<String> startsWithJava = s -> s.startsWith("Java");
        System.out.printf("Does string start with 'Java'? %b%n", startsWithJava.test("Java"));
        System.out.printf("Does string start with 'Java'? %b%n", startsWithJava.test("Hello Java"));

        /*Chain predicates*/
        Predicate<String> chainedPredicates = (isNotEmpty2.and(isLengthGreaterThan5)).or(startsWithJava);
        System.out.printf("Is string NOT empty and greater than 5 characters OR does it start with 'Java'? %b%n", chainedPredicates.test("Hello"));
        System.out.printf("Is string NOT empty and greater than 5 characters OR does it start with 'Java'? %b%n", chainedPredicates.test("Java"));
    }
}