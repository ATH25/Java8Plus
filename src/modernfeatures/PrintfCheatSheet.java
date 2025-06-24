package modernfeatures;

/**
 * Java printf() Cheat Sheet
 * -------------------------
 * Introduced in Java 5 (java.util.Formatter API).
 * Allows formatted output similar to printf in C/C++.
 */
public class PrintfCheatSheet {
    public static void main(String[] args) {
        // Integer formatting
        int number = 42;
        System.out.printf("Integer: %d%n", number);
        System.out.printf("Integer with width 5 (right-aligned): |%5d|%n", number);
        System.out.printf("Integer with width 5 (left-aligned):  |%-5d|%n", number);

        // Floating-point formatting
        double pi = Math.PI;
        System.out.printf("Floating-point: %f%n", pi);
        System.out.printf("Rounded to 2 decimals: %.2f%n", pi);
        System.out.printf("Rounded to 4 decimals: %.4f%n", pi);

        // String formatting
        String name = "Alice";
        System.out.printf("String: %s%n", name);
        System.out.printf("String with width 10 (right-aligned): |%10s|%n", name);
        System.out.printf("String with width 10 (left-aligned):  |%-10s|%n", name);

        // Mixing multiple variables
        System.out.printf("Name: %s, Score: %d, GPA: %.2f%n", name, 95, 3.75);
    }
}