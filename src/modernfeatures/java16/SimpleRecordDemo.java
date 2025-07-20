package modernfeatures.java16;

/**
 * Demonstrates the use of Java records for immutable, compact data carrier classes.
 * <p>
 * This class shows how records in Java provide a concise way to declare data carrier classes
 * that are immutable and come with automatically generated methods such as accessors,
 * {@code toString()}, {@code equals()}, and {@code hashCode()}.
 */
public class SimpleRecordDemo {
    /**
     * A record is a special data carrier class in Java that is immutable and compact.
     * <p>
     * The record automatically generates:
     * <ul>
     *     <li>Accessors for each component (e.g., {@code name()}, {@code age()})</li>
     *     <li>{@code toString()} method</li>
     *     <li>{@code equals()} and {@code hashCode()} methods</li>
     *     <li>Canonical constructor</li>
     * </ul>
     */
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create a new Person record instance
        Person aju = new Person("Aju", 42); // Person record is created here

        // Use auto-generated accessors (name() and age())
        System.out.println("Name: " + aju.name()); // Accessor method
        System.out.println("Age: " + aju.age());   // Accessor method

        // Use auto-generated toString, equals, and hashCode
        Person copy = new Person("Aju", 42);
        System.out.println("aju.toString(): " + aju); // Auto-generated toString()
        System.out.println("aju.equals(copy): " + aju.equals(copy)); // Auto-generated equals()
        System.out.println("aju.hashCode(): " + aju.hashCode()); // Auto-generated hashCode()
        System.out.println("copy.hashCode(): " + copy.hashCode());

        // Reference equality comparison (aju and copy are different objects)
        System.out.println(aju == copy); // false, different object references

        // Fields are immutable: cannot assign to them after creation
        // aju.name = "Other"; // Error! Cannot assign a value to final variable
        // This is because record fields are implicitly final.
    }
}