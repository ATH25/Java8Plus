package modernfeatures;

/**
 * Interface: Greeting2
 * --------------------
 * Same as before. A functional interface with a single abstract method.
 */
interface Greeting2 {
    void sayHello();
}

/**
 * Class: LambdaExample
 * ----------------------
 * Demonstrates how Java 8 Lambda expressions simplify the creation
 * of functional interface implementations.
 *
 * Instead of using an anonymous inner class, we directly assign
 * a lambda expression to the interface.
 *
 * NOTE:
 * This works because Greeting2 is a Functional Interface — it has exactly one abstract method.
 * The compiler can safely map the lambda expression to that method.
 * If there were multiple abstract methods, this would not be allowed.
 */
public class LambdaExample {
    public static void main(String[] args) {
        // Using Lambda Expression to implement Greeting interface
        Greeting2 greeting = () -> System.out.println("Hello from Lambda expression!");

        // Invoking the sayHello() method
        greeting.sayHello();
    }
}