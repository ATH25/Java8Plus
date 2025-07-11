package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Predicate;

/**
 * Demonstrates the use of {@link Predicate} and its common operations.
 * <p>
 * Features covered:
 * <ul>
 *   <li>Checking if a string is empty or not</li>
 *   <li>Determining if a number is even or odd</li>
 *   <li>Using {@code negate()} for predicate negation</li>
 *   <li>Composing predicates with {@code and()}, {@code or()}</li>
 *   <li>Defining custom predicates for string length and patterns</li>
 * </ul>
 */
public class PredicateExample {

    /**
     * Demonstrates multiple {@link Predicate} use cases including testing, negation, and composition.
     *
     * @param args Command-line arguments (not used)
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