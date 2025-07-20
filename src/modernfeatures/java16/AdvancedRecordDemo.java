package modernfeatures.java16;

/**
 * Demonstrates the use of Java records for immutable, compact data carrier classes.
 */
public class AdvancedRecordDemo {
    // Define a record with two fields
    public record Person(String name, int age) {
        /**
         * Compact canonical constructor for Person record.
         * Validates that age is non-negative.
         *
         * @param name the name of the person
         * @param age the age of the person (must be non-negative)
         * @throws IllegalArgumentException if age is negative
         */
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age must be non-negative");

            }
        }

//        public Person(String name, int age) {
//            if (age < 0) {
//                throw new IllegalArgumentException("Age must be non-negative");
//            }
//            this.name = name;
//            this.age = age;
//        }

        /**
         * Checks if the person is an adult (age >= 18).
         *
         * @return true if age is at least 18, false otherwise
         */
        public boolean isAdult() {
            return age >= 18;
        }
    }


    public static void main(String[] args) {
        // Create a new Person record
        Person aju = new Person("Aju", 42);

        // Accessors are generated automatically
        System.out.println("Name: " + aju.name());
        System.out.println("Age: " + aju.age());

        // toString, equals, and hashCode are also generated
        Person copy = new Person("Aju", 42);
        System.out.println("aju.toString(): " + aju);
        System.out.println("aju.equals(copy): " + aju.equals(copy));
        System.out.println("aju.hashCode(): " + aju.hashCode());
        System.out.println("copy.hashCode(): " + copy.hashCode());
        System.out.println(aju == copy); // This will print: false

        // Check if aju is an adult
        System.out.println("Is aju an adult? " + aju.isAdult());

        // Records are immutable by default
        // aju.name = "Other"; // Error! Cannot assign a value to final variable
    }
}