package modernfeatures.methodreferences;

import java.util.List;

/**
 * Demonstrates the use of method references in Java, and contrasts them with lambda expressions.
 * Method references provide a concise way to refer to an existing method, making code more readable.
 */
public class MethodReferenceExample {

    /**
     * Main method demonstrates printing each name in a list using both a lambda expression
     * and various types of method references. The output is identical, but the method reference syntax is more concise.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave", "Elizabeth", "Fred", "George", "Harry");

        // Print each name using a lambda expression
        System.out.println("Using Lambdas:");
        names.forEach(name -> System.out.println(name));

        // Print each name using a method reference (more concise and equally effective)
        System.out.println("\nUsing Method References:");
        names.forEach(System.out::println);

        // Static Method Reference example
        System.out.println("\nUsing Static Method Reference:");
        names.forEach(MethodReferenceExample::printUpper);

        // Instance Method Reference (of a particular object)
        // This references the printLower instance method of the obj object
        System.out.println("\nUsing Instance Method Reference (toLowerCase):");
        MethodReferenceExample obj = new MethodReferenceExample();
        names.forEach(obj::printLower);

        /**
         * Demonstrates instance method reference of a parameter/object in the stream.
         * String::toUpperCase is called on each element in the stream.
         */
        // Instance Method Reference of a Parameter/Object in the Stream (String::toUpperCase)
        System.out.println("\nUsing Instance Method Reference of a Parameter/Object in the Stream:");
        // For each name, calls name.toUpperCase()
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        // Equivalent lambda expression (for comparison)
        System.out.println("\nSame as above, but using lambda expression:");
        names.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));


        /**
         * Demonstrates constructor reference (ClassName::new) in a stream.
         * For each name, constructs a new Person object.
         */
        System.out.println("\nUsing Constructor Reference to create Person objects:");
        names.stream().map(Person::new).forEach(System.out::println);

        // Equivalent lambda expression
        System.out.println("\nSame as above, but using lambda expression:");
        names.stream().map(name -> new Person(name)).forEach(System.out::println);

    }

    // static method to print in upper case
    public static void printUpper(String stringName){
        System.out.println(stringName.toUpperCase());
    }

    // instance method to print in lower case
    public void printLower(String stringName){
        System.out.println(stringName.toLowerCase());
    }

    /**
     * Simple Person class for demonstrating constructor references.
     */
    static class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }


}


