package modernfeatures.java17;

/**
 * Demonstrates Java 17+ sealed classes, which restrict which classes can extend a superclass.
 * <p>
 * This example shows:
 * <ul>
 *   <li>How to declare a sealed class ({@code Shape}) and specify the permitted subclasses.</li>
 *   <li>Usage of {@code final} and {@code non-sealed} subclasses to control the inheritance hierarchy.</li>
 *   <li>How pattern matching with switch expressions can safely handle all permitted subclasses,
 *       providing exhaustive type checking at compile time.</li>
 * </ul>
 */
public class SealedClassesDemo {
    // Sealed base class permits only the listed subclasses
    public sealed abstract static class Shape permits Circle, Rectangle, Square {}

    public final static class Circle extends Shape {
        public double radius;
        public Circle(double radius) { this.radius = radius; }
        @Override public String toString() { return "Circle(" + radius + ")"; }
    }

    // non-sealed allows further extension outside the sealed hierarchy
    public non-sealed static class Rectangle extends Shape {
        public double width, height;
        public Rectangle(double width, double height) { this.width = width; this.height = height; }
        @Override public String toString() { return "Rectangle(" + width + ", " + height + ")"; }
    }

    public final static class Square extends Shape {
        public double side;
        public Square(double side) { this.side = side; }
        @Override public String toString() { return "Square(" + side + ")"; }
    }

    /**
     * Main entry point: creates instances of the permitted {@code Shape} subclasses,
     * iterates through them, and uses a pattern-matching switch expression to print
     * descriptive information about each shape.
     */
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(3, 4);
        Shape s = new Square(2);

        // Pattern-matching switch: new case syntax uses 'case Type var ->', and the arrow is not a lambda.
        // The switch is exhaustive because all permitted subclasses of Shape are covered.
        for (Shape shape : new Shape[]{c, r, s}) {
            String desc = switch (shape) {
                case Circle circle -> "It's a circle with radius " + circle.radius;
                case Rectangle rect -> "It's a rectangle " + rect;
                case Square sq -> "It's a square " + sq;
            };
            System.out.println(desc);
        }
    }
}