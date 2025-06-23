package modernfeatures.lambda;

// Declaring a functional interface with one abstract method.
// The @FunctionalInterface annotation tells the compiler to enforce this rule.
@FunctionalInterface
interface MessagePrinter {
    void printMessage(String message);
}

public class LambdaWithParameterExample {
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
