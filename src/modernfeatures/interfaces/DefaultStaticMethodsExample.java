package modernfeatures.interfaces;

/**
 * Demonstrates default and static methods in Java interfaces (Java 8+).
 */
interface MyInterface {
    /**
     * A default method provides an implementation directly in the interface.
     */
    default void myDefaultMethod() {
        System.out.println("This is a default implementation!");
    }

    /**
     * A static method in an interface, called via the interface name.
     */
    static void myStaticMethod() {
        System.out.println("This is a static method in the interface!");
    }
}

/**
 * Example class that implements MyInterface to demonstrate default and static methods.
 */
public class DefaultStaticMethodsExample implements MyInterface {

    /**
     * Main method: demonstrates calling default and static interface methods.
     */
    public static void main(String[] args) {
        // Create an instance to call the default method
        DefaultStaticMethodsExample example = new DefaultStaticMethodsExample();
        example.myDefaultMethod(); // Calls the default implementation

        // Call the static method using the interface name
        MyInterface.myStaticMethod();
    }

    // Uncomment below to override the default method
    // @Override
    // public void myDefaultMethod() {
    //     System.out.println("Overridden default implementation!");
    // }
}
