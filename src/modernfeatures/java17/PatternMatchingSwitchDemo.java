package modernfeatures.java17;

/**
 * This demo shows pattern matching for switch in Java 17+ using sealed interfaces and records.
 * It illustrates how switch expressions can be used with pattern matching to handle different
 * implementations of a sealed interface.
 */
public class PatternMatchingSwitchDemo {

    // Sealed interface representing a geometric shape
    sealed interface Shape permits Circle, Rectangle, Square {}

    // Record representing a circle with a radius
    record Circle(double radius) implements Shape {}

    // Record representing a rectangle with width and height
    record Rectangle(double width, double height) implements Shape {}

    // Record representing a square with a side length
    record Square(double side) implements Shape {}

    /**
     * Iterates over different shapes and uses a switch expression with pattern matching
     * to produce a description of each shape.
     */
    public static void main(String[] args) {
        // Construct an array of various Shape instances
        Shape[] shapes = {
                new Circle(4.0),
                new Rectangle(3.0, 5.0),
                new Square(6.0)
        };
        for (Shape shape : shapes) {
            // Use a switch expression with pattern matching to determine the shape description
            // Each case matches a specific record type and binds it to a variable for access
            // The switch is exhaustive because Shape is sealed and all permitted subclasses are handled
            String desc = switch (shape) {
                case Circle c -> "Circle with radius " + c.radius();
                case Rectangle r -> "Rectangle " + r.width() + " x " + r.height();
                case Square s -> "Square with side " + s.side();
            };
            System.out.println(desc);
        }
    }

}
