package modernfeatures.java9;

/**
 * Demonstrates the use of private and private static methods in interfaces (Java 9+).
 * <p>
 * Private methods in interfaces allow code reuse and organization within default and static methods,
 * without exposing helper logic to implementers or users of the interface.
 */
public class PrivateInterfaceMethodsDemo {

    /**
     * Functional interface for simple message formatting.
     */
    interface Formatter {
        // Default method using a private helper
        default String formatHello(String name) {
            // Calls a private instance method
            return addPrefix(formatName(name));
        }

        // Default method using the same private helper
        default String formatBye(String name) {
            // Calls the same private instance method
            return addSuffix(formatName(name));
        }

        // Private instance method, only accessible within the interface
        private String formatName(String name) {
            return name == null ? "<unknown>" : name.trim();
        }

        // Private static method, for shared static logic
        private static String addPrefix(String s) {
            return "Hello, " + s;
        }

        private static String addSuffix(String s) {
            return "Goodbye, " + s;
        }
    }

    public static void main(String[] args) {
        // Anonymous class implementing Formatter
        Formatter formatter = new Formatter() {};

        System.out.println(formatter.formatHello("Alice"));   // Hello, Alice
        System.out.println(formatter.formatBye(" Bob "));     // Goodbye, Bob
        System.out.println(formatter.formatHello(null));      // Hello, <unknown>
    }
}