package modernfeatures;

/**
 * Interface: Greeting
 * --------------------
 * Represents a simple contract for any class that wishes to provide
 * a greeting functionality. This interface has only one method: sayHello().
 *
 * Since this interface has exactly one abstract method, it qualifies as a
 * Functional Interface (used later in Java 8 for lambda expressions).
 */
interface Greeting {
    void sayHello();
}

/**
 * Class: AnonymousInnerClassExample
 * -----------------------------------
 * Demonstrates how to use an Anonymous Inner Class in Java.
 *
 * Normally, to implement the Greeting interface, we would create a new class
 * like `class GreetingImpl implements Greeting { ... }`. But for short, one-time
 * implementations, anonymous inner classes let us define the behavior inline
 * without creating a separate named class.
 */
public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        // Creating an anonymous inner class that implements Greeting.
        // The implementation of the interface is provided right at the moment
        // we create the object using 'new Greeting() {...}'.
        // This creates an unnamed subclass of Greeting at runtime.
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("\n Hello from anonymous inner class!");
            }
        };

        // Invoking the sayHello() method on the anonymous class instance
        greeting.sayHello();
    }
}
