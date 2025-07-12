package modernfeatures.lambda;

/**
 * Demonstrates the use of lambda expressions with parameters in Java.
 * <p>
 * This example shows:
 * <ul>
 *   <li>How to declare a functional interface with a single abstract method.</li>
 *   <li>How to implement the interface using lambda expressions with implicit and explicit parameter types.</li>
 *   <li>How to invoke lambda expressions.</li>
 * </ul>
 */
@FunctionalInterface
interface MessagePrinter {
    /**
     * Prints a message.
     *
     * @param message the message to print
     */
    void printMessage(String message);
}

/**
 * <p>
 * This class demonstrates the use of lambda expressions with parameters in Java.
 * It shows how to create and invoke lambda expressions with implicit and explicit parameter types,
 * and how to reuse lambda expressions.
 * <p>
 */
public class LambdaWithParameterExample {

    /**
     * Default constructor.
     */
    public LambdaWithParameterExample() {
        super();
    }

    /**
     * The entry point of the application.
     * <p>
     * This method performs the following steps:
     * <ul>
     *   <li>Creates a lambda expression with an implicit parameter type to print a message.</li>
     *   <li>Invokes the lambda expression with a sample message.</li>
     *   <li>Creates another lambda expression with an explicit parameter type and parentheses.</li>
     *   <li>Invokes the second lambda expression with a different message.</li>
     *   <li>Reuses the first lambda expression to print another message.</li>
     * </ul>
     * <p>
     *
     * @param args the command-line arguments passed to the program
     */
    public static void main(String[] args) {
        // Lambda expression with one parameter (implicit parameter type, parentheses omitted).
        // The compiler infers that 'message' is of type String based on the interface definition.
        MessagePrinter printer = message -> System.out.println("Message: " + message);

        // Invoking the lambda expression implementation
        printer.printMessage("Hello from Lambda!");

        // Alternative syntax with explicit parameter type and parentheses.
        // This form may improve clarity, especially when there are multiple parameters or for beginners.
        MessagePrinter formalPrinter = (String message) -> System.out.println("Formal Message: " + message);

        // Invoking the alternative lambda implementation
        formalPrinter.printMessage("Welcome to Java 21!");

        // Reusing the first lambda implementation
        printer.printMessage("Hello again!");
    }
}
