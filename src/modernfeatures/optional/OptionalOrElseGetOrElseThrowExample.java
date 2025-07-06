package modernfeatures.optional;

import java.util.Optional;

public class OptionalOrElseGetOrElseThrowExample {

    public static void main(String[] args) {
        // 8. Use orElseGet: only generates the default if Optional is empty
        // The method signature for empty() is: public static <T> Optional<T> empty()
        // The <T> before the return type makes this a generic method: it returns an empty Optional of whatever type you assign it to (e.g., Optional<String>, Optional<Integer>, etc.).
        Optional<String> expensiveOpt = Optional.empty();
        String expensiveValue = expensiveOpt.orElseGet(() -> {
            System.out.println("Generating expensive default value...");
            return "Expensive Value";
        });
        System.out.println("orElseGet result: " + expensiveValue);

// 9. Use orElseThrow: throws if value is missing
        try {
            Optional<String> missingOpt = Optional.empty();
            // Uncommenting below will throw NoSuchElementException
            // String value2 = missingOpt.orElseThrow();
            // Custom exception:
            String value3 = missingOpt.orElseThrow(() -> new IllegalStateException("Value not present!"));
        } catch (Exception e) {
            System.out.println("Caught exception from orElseThrow: " + e);
        }
    }

}
