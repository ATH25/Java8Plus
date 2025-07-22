package modernfeatures.java21;

/**
 * Demonstrates Java 21+ pattern matching for switch with nested record patterns.
 * This example showcases how to use pattern matching in switch expressions
 * to handle various shapes, including nested groups of shapes.
 */
public class PatternMatchingSwitchNestedDemo {

    // Sealed interface representing a geometric shape
    sealed interface Shape permits Circle, Rectangle, Square, Group {}

    // Record representing a circle with a radius
    record Circle(double radius) implements Shape {}

    // Record representing a rectangle with width and height
    record Rectangle(double width, double height) implements Shape {}

    // Record representing a square with a side length
    record Square(double side) implements Shape {}

    // Record representing a group of two shapes, which can be nested
    record Group(Shape first, Shape second) implements Shape {}

    /**
     * Demonstrates pattern matching with nested groups and various shapes.
     * Creates an array of shapes including simple shapes and nested groups,
     * then uses a switch expression with nested patterns to describe each shape.
     */
    public static void main(String[] args) {
        // Test data includes simple shapes and nested groups of shapes
        Shape[] shapes = {
                new Circle(4.0),
                new Rectangle(3.0, 5.0),
                new Group(new Square(2.0), new Circle(1.0)),
                new Group(new Group(new Square(9.0), new Circle(7.0)), new Rectangle(2.0, 4.0))
        };

        for (Shape shape : shapes) {
            String desc = switch (shape) {
                // Matches a simple Circle shape
                case Circle c -> "Circle with radius " + c.radius();
                // Matches a simple Rectangle shape
                case Rectangle r -> "Rectangle " + r.width() + " x " + r.height();
                // Matches a simple Square shape
                case Square s -> "Square with side " + s.side();
                // Matches a Group whose first element is itself a Group (nested group)
                case Group(Group(var a, var b), var second) -> "Group of nested group (" + a + " and " + b + ") and " + second;
                // Matches a Group with two shapes, recursively matching each component
                case Group g -> "Group of " +
                        // Recursively match the first shape in the group
                        switch (g.first()) {
                            case Circle c -> "Circle " + c.radius();
                            case Square s -> "Square " + s.side();
                            case Rectangle r -> "Rectangle " + r.width() + " x " + r.height();
                            case Group nested -> "Nested group";
                        }
                        + " and "
                        // Recursively match the second shape in the group
                        + switch (g.second()) {
                    case Circle c -> "Circle " + c.radius();
                    case Square s -> "Square " + s.side();
                    case Rectangle r -> "Rectangle " + r.width() + " x " + r.height();
                    case Group nested -> "Nested group";
                };
            };
            System.out.println(desc);
        }
    }
}