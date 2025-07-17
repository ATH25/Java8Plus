package modernfeatures.java10;

/**
 * Demonstrates the use of the {@code var} keyword for local variable type inference (Java 10+).
 * <p>
 * Shows how the compiler infers types for local variables, and how this can reduce boilerplate in everyday code.
 */
public class VarKeywordDemo {
    public static void main(String[] args) {
        // Old way: explicit type declaration
        String explicit = "Hello, Java 10!";
        System.out.println("Explicit type: " + explicit);

        // Java 10+ way: type is inferred from the initializer
        var inferred = "Hello with var!";
        System.out.println("Inferred type: " + inferred);

        // Compiler infers the type as ArrayList<String>
        var names = new java.util.ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        System.out.println("Names: " + names);

        // Infers Map<String, Integer>
        var map = new java.util.HashMap<String, Integer>();
        map.put("Thomas", 40);
        map.put("Sara", 38);
        System.out.println("Map: " + map);

        // Loop variable with var
        for (var name : names) {
            System.out.println("Name: " + name);
        }

        // var works for local variables only:
        // var cannot be used for class fields, method parameters, or return types

        // The inferred type is always fixed at compile time!
    }
}