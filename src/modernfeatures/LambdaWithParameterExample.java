package modernfeatures;

@FunctionalInterface
interface MessagePrinter {
    void printMessage(String message);
}

public class LambdaWithParameterExample {
    public static void main(String[] args) {
        // Lambda expression with one parameter
        MessagePrinter printer = message -> System.out.println("Message: " + message);

        // Using the lambda expression
        printer.printMessage("Hello from Lambda!");

        // Alternative syntax with explicit parameter type
        MessagePrinter formalPrinter = (String message) -> System.out.println("Formal Message: " + message);
        formalPrinter.printMessage("Welcome to Java 21!");

        printer.printMessage("Hello again!");
    }
}
