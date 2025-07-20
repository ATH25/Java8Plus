package modernfeatures.java16;

/**
 * Demonstrates pattern matching for instanceof (Java 16+).
 * Simplifies type checks and eliminates manual casting.
 */
public class PatternMatchingInstanceofDemo {
    /**
     * Demonstrates both classic and pattern matching approaches for instanceof,
     * showing the benefits of the new syntax in simplifying code and reducing boilerplate.
     */
    public static void main(String[] args) {
        Object[] objects = {"Hello", 123, 4.56, "World"};

        for (Object obj : objects) {
            // Classic way: Check type with instanceof and then cast manually
            if (obj instanceof String) {
                String s = (String) obj;
                System.out.println("Classic: Uppercase = " + s.toUpperCase());
            }

            // Modern way: Use pattern matching with instanceof to declare and initialize variable in one step
            if (obj instanceof String s) {
                System.out.println("Pattern matching: Uppercase = " + s.toUpperCase());
            } else if (obj instanceof Integer i) {
                System.out.println("Pattern matching: Integer doubled = " + (i * 2));
            } else {
                System.out.println("Pattern matching: Other type = " + obj);
            }
        }
    }
}